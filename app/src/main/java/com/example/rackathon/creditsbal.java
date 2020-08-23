package com.example.rackathon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class creditsbal extends AppCompatActivity {
    public String e_mail=MainActivity.emails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditsbal);

        String hj=creditresponse.response;
        TextView n= (TextView) findViewById (R.id.name);
        TextView c = (TextView) findViewById (R.id.credits);

        n.setText(e_mail);
        c.setText(hj);
    }
    public void twe(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/intent/tweet?text=..rackathon"));
        startActivity(browserIntent);
    }
    public void sha(View view)
    {

    }
    public void host(View view){
        Intent al = new Intent(creditsbal.this, Host.class);
        startActivity(al);
    }
}
