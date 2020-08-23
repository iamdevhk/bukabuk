package com.example.rackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.rackathon.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchableActivity extends AppCompatActivity {
    ProductAdapter adapter;
    //a list to store all the products
    public List<Product> productList;
    public List<Product> productLists;
    //the recyclerview
    int id1=1;
    int r1=3;
    String dist="45";
    String query="";
    SearchView searchView;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    RequestQueue rq;
    public String titl="",author="",credits="",sno="",mail="";
    String request_url = "http://bulbcontrol.000webhostapp.com/rakathon/disp_book.php?search=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        rq = Volley.newRequestQueue(this);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        //searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView.setLayoutManager(layoutManager);
        //initializing the productlist
        //productList = new ArrayList<>();
        productLists = new ArrayList<>();
        call(query);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.v("hj",query);
                call(query);
                return true;
               /*
                ArrayList<String> arr=new ArrayList<String>();
                // arr=new String[productList.size()];
                for(int o=0;o<productList.size();o++){

                    arr.add(productList.get(o).title);
                   // index=0;
                }
                if(arr.contains(query)) {
                    //ProductAdapter adapter = new ProductAdapter(this, productList);
                    Toast.makeText(MainActivity.this, "Match found",Toast.LENGTH_SHORT).show();
                    //setting adapter to recyclerview
                    // recyclerView.setAdapter();
                    // adapters = new ProductAdapter(this, productList.getClass(0));
                    //recyclerView.setAdapter(adapters);
                    // adapters.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
                */
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
    public void ope(View view)
    {
        Intent log =new Intent(this,mainview.class);
        startActivity(log);
    }


    public void sendRequest(String query1){
        productList = new ArrayList<>();
        String request_url = "http://bulbcontrol.000webhostapp.com/rakathon/disp_book.php?search="+query1;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    //Product personUtils = new Product();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        titl=jsonObject.getString("bname");
                        Log.v("h",titl);
                        // Product.getTitle(titl);
                        sno=jsonObject.getString("sno");
                        author=jsonObject.getString("author");
                        mail=jsonObject.getString("mail");
                        credits=jsonObject.getString("credits");
                        productList.add(
                                new Product(
                                        sno,
                                        titl,
                                        author,
                                        4.9,
                                        credits,
                                        mail,
                                        "6677.8",
                                        R.drawable.ecomm3));
                        //jsonObject.getString("credits");




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                }
                adapter.notifyDataSetChanged();


                //  mAdapter = new CustomRecyclerAdapter(MainActivity.this, personUtilsList);

                //recyclerView.setAdapter(mAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        });

        rq.add(jsonArrayRequest);

    }
    public void call(String query){
        sendRequest(query);
         adapter = new ProductAdapter(this, productList);
        // Log.v("kk",productList.get(0).getTitle());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        searchView = (SearchView) findViewById(R.id.searchView);
    }
}