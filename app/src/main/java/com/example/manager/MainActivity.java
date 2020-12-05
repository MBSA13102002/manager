package com.example.manager;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    CardView teacher,student;
    DatabaseReference reference;
    String passT;
    Dialog dialogAnimated;
    EditText getcode;
    String passS;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacher=findViewById(R.id.teacher);
        student=findViewById(R.id.student);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                passT=snapshot.child("passT").getValue(String.class);
                passS=snapshot.child("passS").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAnimated=new Dialog(MainActivity.this,R.style.dialogstyle);
                dialogAnimated.setContentView(R.layout.passcode);
                dialogAnimated.show();

                button=dialogAnimated.findViewById(R.id.button2);
                getcode=dialogAnimated.findViewById(R.id.editTextNumber3);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       if(getcode.getText().toString().equals(passT)){
                           Intent teach=new Intent(MainActivity.this,Teacher.class);
                           startActivity(teach);
                           finish();
                       }
                       else{
                           getcode.setError("Wrong Password");
                       }
                    }
                });

            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAnimated=new Dialog(MainActivity.this,R.style.dialogstyle);
                dialogAnimated.setContentView(R.layout.passcode);
                dialogAnimated.show();

                button=dialogAnimated.findViewById(R.id.button2);
                getcode=dialogAnimated.findViewById(R.id.editTextNumber3);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(getcode.getText().toString().equals(passS)){
                            Intent stud=new Intent(MainActivity.this,Student.class);
                            startActivity(stud);
                            finish();
                        }
                        else{
                            getcode.setError("Wrong Password");
                        }
                    }
                });
            }
        });
    }
}