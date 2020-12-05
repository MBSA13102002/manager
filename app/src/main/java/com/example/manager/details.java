package com.example.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class details extends AppCompatActivity {

    EditText nametxt,rolltxt,semestertxt,branchtxt,phonetxt,emailtxt,dobtxt,modtxt,fathertxt,mothertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String name=getIntent().getStringExtra("sendingname");
        String roll=getIntent().getStringExtra("sendingroll");
        String semester=getIntent().getStringExtra("sendingsemester");
        String branch=getIntent().getStringExtra("sendingbranch");
        String phone=getIntent().getStringExtra("sendingphoneno");
        String email=getIntent().getStringExtra("sendingemail");
        String dob=getIntent().getStringExtra("sendingdob");
        String mode=getIntent().getStringExtra("sendingmode");
        String father=getIntent().getStringExtra("sendingfather");
        String mother=getIntent().getStringExtra("sendingmother");


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


        nametxt.setHint(name);
        nametxt.setEnabled(false);

        rolltxt.setHint(roll);
        rolltxt.setEnabled(false);

        semestertxt.setHint(semester);
        semestertxt.setEnabled(false);

        branchtxt.setHint(branch);
        branchtxt.setEnabled(false);

        phonetxt.setHint(phone);
        phonetxt.setEnabled(false);

        emailtxt.setHint(email);
        emailtxt.setEnabled(false);

        dobtxt.setHint(dob);
        dobtxt.setEnabled(false);

        modtxt.setHint(mode);
        modtxt.setEnabled(false);

        fathertxt.setHint(father);
        fathertxt.setEnabled(false);

        mothertxt.setHint(mother);
        mothertxt.setEnabled(false);
    }
}