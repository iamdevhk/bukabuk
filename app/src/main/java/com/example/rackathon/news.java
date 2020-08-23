package com.example.rackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class news extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.independent.co.uk/topic/books");
    }
}
