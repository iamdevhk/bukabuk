package com.example.rackathon;









import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class creditresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public creditresponse(Context context) {
        this.context = context;
    }


    public static String response="";
    public static int result;
    public String e_mail=MainActivity.emails;
    //public String password=MainActivity.password;

    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response

        String url = "http://bulbcontrol.000webhostapp.com/rakathon/current_credit.php?mail="+ e_mail;
        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                response =jsonObj.getString("val");
                result = Integer.parseInt(response);
                //Log.v("po", response);
                hk=1;

            } catch (final JSONException e) {
                Log.e("MainActivity", "Json parsing error: " + e.getMessage());
            }

        } else {
            Log.e("MainActivity", "Couldn't get json from server.");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        if(hk==1) {
            Toast.makeText(this.context, "Credits verified", Toast.LENGTH_SHORT).show();
           context.startActivity(new Intent(context, creditsbal.class));

        }

    }

}

