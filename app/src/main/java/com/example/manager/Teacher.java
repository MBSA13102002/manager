package com.example.manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Teacher extends AppCompatActivity {

    DatabaseReference ref;
    FirebaseDatabase database;
    RecyclerView recyclerView;
    SearchView searchView;

    ArrayList<Member> list;
    boolean once=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        ref= FirebaseDatabase.getInstance().getReference().child("Students");
        recyclerView=findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(layoutManager);

        searchView=findViewById(R.id.searchView);

        list=new ArrayList<>();
    }
    @Override
    protected void onStart() {
        super.onStart();

        if(ref!=null){

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.exists() && !once) {
                        for(DataSnapshot ds:snapshot.getChildren()){
                            list.add(ds.getValue(Member.class));

                            StudentAdapter studentAdapter=new StudentAdapter(Teacher.this,list);
                            recyclerView.setAdapter(studentAdapter);
                        }

                        once=true;

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(Teacher.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(searchView!=null){
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return true;
                }
            });
        }

    }
    private void search(String str) {

        ArrayList<Member> mylist=new ArrayList<>();
        for(Member object:list){

            if(object.getName().toLowerCase().contains(str.toLowerCase().trim()))
            {
                mylist.add(object);
            }
        }
        StudentAdapter studentAdapter=new StudentAdapter(Teacher.this,mylist);
        recyclerView.setAdapter(studentAdapter);

    }
    @Override
    public void onBackPressed() {

        Intent open=new Intent(Teacher.this,MainActivity.class);
        startActivity(open);

        finish();
        super.onBackPressed();

    }
}