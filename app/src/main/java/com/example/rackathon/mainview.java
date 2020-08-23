package com.example.rackathon;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;



import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

public class mainview extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText emailaddr,password;
    Context context;
    String emails;
    GridLayout gridLayout;

    public static int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        gridLayout=(GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);
        //BottomNavigationView navView = findViewById(R.id.navigation);
       // navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainview, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent al = new Intent(mainview.this, Signup.class);

            // Start the new activity
            startActivity(al);
        } else if (id == R.id.nav_gallery) {
            Intent al = new Intent(mainview.this, chat.class);

            // Start the new activity
            startActivity(al);

        } else if (id == R.id.nav_slideshow) {
            Intent al = new Intent(mainview.this, postbook.class);

            // Start the new activity
            startActivity(al);

        } else if (id == R.id.nav_tools) {
            Intent al = new Intent(mainview.this, SearchableActivity.class);

            // Start the new activity
            startActivity(al);

        }   else if (id == R.id.nav_news) {
            Intent al = new Intent(mainview.this, news.class);

            // Start the new activity
            startActivity(al);
        }
        else if (id == R.id.nav_credits) {
            Intent al = new Intent(mainview.this, creditsbal.class);

            // Start the new activity
            startActivity(al);
        }
        else if (id == R.id.nav_share) {
            Intent al = new Intent(mainview.this, news.class);

            // Start the new activity
            startActivity(al);
        } else if (id == R.id.nav_send) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/intent/tweet?text=..rackathon"));
            startActivity(browserIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public  void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(cv.this,"Clicked at index "+ finalI,
                    //Toast.LENGTH_SHORT).show();
                    if(finalI==0)
                    {
                        Intent log = new Intent(mainview.this, postbook.class);

                        // Start the new activity
                        startActivity(log);
                    }
                    else if(finalI==1)
                    {
                        Intent log = new Intent(mainview.this, SearchableActivity.class);

                        // Start the new activity
                        startActivity(log);
                    }
                    else if(finalI==2)
                    {
                        Intent log = new Intent(mainview.this, wait.class);

                        // Start the new activity
                        startActivity(log);
                    }
                    else if(finalI==3)
                    {
                        Intent log = new Intent(mainview.this, chat.class);

                        // Start the new activity
                        startActivity(log);
                    }
                    else if(finalI==4)
                    {
                        Intent log = new Intent(mainview.this, news.class);

                        // Start the new activity
                        startActivity(log);
                    }
                    else if(finalI==5)
                    {
                        Intent log = new Intent(mainview.this, notifi.class);

                        // Start the new activity
                        startActivity(log);
                    }
                }
            });
        }
    }





}
