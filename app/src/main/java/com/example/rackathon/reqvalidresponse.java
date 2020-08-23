package com.example.rackathon;







import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class reqvalidresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public reqvalidresponse(Context context) {
        this.context = context;
    }


    public static String response="";
    public static int result;
    public String e_mail=MainActivity.emails;
    public String password=MainActivity.password;

    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://bulbcontrol.000webhostapp.com/rakathon/buy.php?buy="+e_mail+"&sell="+vigneswetha@gmail.com&sno=7
        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                response =jsonObj.getString("val;\n" +
                        "                result = Integer.parseInt(response);")
                Log.v("po", response);

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

        if(result==1) {


            Toast.makeText(this.context, "You have less credits!", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, creditsbal.class));
        }
        else if(result==0){
            Toast.makeText(this.context, "request sent", Toast.LENGTH_SHORT).show();
        }


    }

}

