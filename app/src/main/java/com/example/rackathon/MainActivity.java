package com.example.rackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String namee, service, phnum, emails,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view) {
        EditText text2 = (EditText) findViewById(R.id.input_email);
        emails = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_password);
        password = text3.getText().toString();
        response hu = new response(this.getApplicationContext());
        hu.execute();

    }
    public void siggn(View view) {

        Intent al = new Intent(MainActivity.this, Signup.class);

        // Start the new activity
        startActivity(al);
    }
}
