package com.example.rackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    public static String name, email, phnnum, cllg,loc,course,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void login(View view) {
        EditText text2 = (EditText) findViewById(R.id.input_name);
        name = text2.getText().toString();
        EditText t = (EditText) findViewById(R.id.input_email);
        email = t.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_num);
        phnnum = text3.getText().toString();
        EditText text4 = (EditText) findViewById(R.id.input_cllg);
        cllg = text4.getText().toString();
        EditText text5 = (EditText) findViewById(R.id.input_cllgloc);
        loc = text5.getText().toString();
        EditText text6 = (EditText) findViewById(R.id.input_course);
        course = text6.getText().toString();
        EditText text7 = (EditText) findViewById(R.id.input_password);
        pass = text7.getText().toString();
        Signupresponse hu = new Signupresponse(this.getApplicationContext());
        hu.execute();

    }
    public void log(View view) {

        Intent al = new Intent(Signup.this, MainActivity.class);

        // Start the new activity
        startActivity(al);
    }
}
