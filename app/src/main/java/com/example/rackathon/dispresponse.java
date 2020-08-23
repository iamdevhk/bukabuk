package com.example.rackathon;









import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class dispresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public dispresponse(Context context) {
        this.context = context;
    }


    public static String response = "";
    String data = "";
    String singleParsed1 = "";
    String dataParsed = "";
    public String id, pwd;
    public String name = postbook.name;
    public String aname = postbook.aname;
    public String edition = postbook.edition;
    public String password = MainActivity.password;
    public String e_mail = MainActivity.emails;
    public int hk = 0;
    public int credits = 10;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://bulbcontrol.000webhostapp.com/rakathon/book_post.php?name=" + name + "&email=" + e_mail + "&author=" + aname + "&edition=" + edition + "&credits=" + credits;
        hk = 1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

       /* if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                response =jsonObj.getString("val");
                Log.v("po", response);

            } catch (final JSONException e) {
                Log.e("MainActivity", "Json parsing error: " + e.getMessage());
            }

        } else {
            Log.e("MainActivity", "Couldn't get json from server.");
        }*/
        try {
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed1 = "   BNAME  : " + JO.get("bname") +
                        "   AUTHOR  : " + JO.get("author")  +
                        "   EDITION : " + JO.get("edition")  +
                        "   CREDITS : " + JO.get("credits")  +
                        "   MAIL : " + JO.get("mail") +
                        "   SNO  : " + JO.get("sno");

            }
        } catch (final JSONException e) {
            Log.e("MainActivity", "Json parsing error: " + e.getMessage());
        }

            return null;
        }


        @Override
        protected void onPostExecute (Void aVoid){

            if (hk == 1) {


                Toast.makeText(this.context, "Bookposted Successfully", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, mainview.class));//the website should return the samed number if theres no entry for it
            }

        }

    }


