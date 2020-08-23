package com.example.rackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class postbook extends AppCompatActivity {
    public static String name="";
    public static String aname="";
    public static String edition="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postbook);
    }
    public void posty(View view) {
        EditText text2 = (EditText) findViewById(R.id.bookname);
        name = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.author);
        aname = text3.getText().toString();
        EditText text4 = (EditText) findViewById(R.id.edition);
        edition = text4.getText().toString();
        postresponse hu = new postresponse(this.getApplicationContext());
        hu.execute();

    }
}
