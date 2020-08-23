package com.example.rackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class wait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        creditresponse hu = new creditresponse(this.getApplicationContext());
        hu.execute();
    }
}
