package com.example.manager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student extends AppCompatActivity {

    EditText nametxt,rolltxt,semestertxt,branchtxt,phonetxt,emailtxt,dobtxt,modtxt,fathertxt,mothertxt;
    FloatingActionButton add;
    DatabaseReference ref;
    Member member;
    String pushkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        nametxt=findViewById(R.id.nametxt);
        rolltxt=findViewById(R.id.rolltxt);
        semestertxt=findViewById(R.id.semestertxt);
        branchtxt=findViewById(R.id.branchtxt);
        phonetxt=findViewById(R.id.phonetxt);
        emailtxt=findViewById(R.id.emailtxt);
        dobtxt=findViewById(R.id.dobtxt);
        modtxt=findViewById(R.id.modtxt);
        fathertxt=findViewById(R.id.fathertxt);
        mothertxt=findViewById(R.id.mothertxt);

        member=new Member();
        ref= FirebaseDatabase.getInstance().getReference().child("Students");

        add=findViewById(R.id.floatingActionButton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nametxt.getText().toString().isEmpty()){
                    if(!rolltxt.getText().toString().isEmpty()){
                        if(!semestertxt.getText().toString().isEmpty()){
                            if(!branchtxt.getText().toString().isEmpty()){
                                if(!phonetxt.getText().toString().isEmpty() && phonetxt.getText().toString().length()==10){
                                    if(!dobtxt.getText().toString().isEmpty()){
                                        if(!modtxt.getText().toString().isEmpty()){
                                            if(!fathertxt.getText().toString().isEmpty()){
                                                if(!mothertxt.getText().toString().isEmpty()){

                                                    pushkey=ref.push().getKey();

                                                    member.setName(nametxt.getText().toString());
                                                    member.setRoll(rolltxt.getText().toString());
                                                    member.setSemester(semestertxt.getText().toString());
                                                    member.setBranch(branchtxt.getText().toString());
                                                    member.setPhone(phonetxt.getText().toString());
                                                    member.setEmail(emailtxt.getText().toString());
                                                    member.setDob(dobtxt.getText().toString());
                                                    member.setMode(modtxt.getText().toString());
                                                    member.setFather(fathertxt.getText().toString());
                                                    member.setMother(mothertxt.getText().toString());

                                                    ref.child(pushkey).setValue(member);

                                                    Intent open=new Intent(Student.this,MainActivity.class);
                                                    startActivity(open);
                                                    finish();
                                                }
                                                else{
                                                    Snackbar.make(findViewById(android.R.id.content),"Mother Name cannot be empty.",Snackbar.LENGTH_LONG).show();
                                                }
                                            }
                                            else{
                                                Snackbar.make(findViewById(android.R.id.content),"Father Name cannot be empty.",Snackbar.LENGTH_LONG).show();
                                            }
                                        }
                                        else{
                                            Snackbar.make(findViewById(android.R.id.content),"Mode Of Admission cannot be empty.",Snackbar.LENGTH_LONG).show();
                                        }
                                    }
                                    else{
                                        Snackbar.make(findViewById(android.R.id.content),"Date Of Birth cannot be empty.",Snackbar.LENGTH_LONG).show();
                                    }
                                }
                                else{
                                    Snackbar.make(findViewById(android.R.id.content),"Phone no. must be of 10 digits and cannot be empty.",Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else{
                                Snackbar.make(findViewById(android.R.id.content),"branch cannot be empty.",Snackbar.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Snackbar.make(findViewById(android.R.id.content),"Semester cannot be empty.",Snackbar.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Snackbar.make(findViewById(android.R.id.content),"Roll no. cannot be empty.",Snackbar.LENGTH_LONG).show();
                    }
                }
                else{
                    Snackbar.make(findViewById(android.R.id.content),"Name cannot be empty.",Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent open=new Intent(Student.this,MainActivity.class);
        startActivity(open);

        finish();
        super.onBackPressed();

    }
}