package com.example.rackathon;







import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class response extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public response(Context context) {
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


        String url = "http://bulbcontrol.000webhostapp.com/rakathon/login.php?un="+ e_mail+"&pass="+ password;
        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                response =jsonObj.getString("val");
                result = Integer.parseInt(response);
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


            Toast.makeText(this.context, "Logged in Successfully", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, mainview.class));//the website should return the samed number if theres no entry for it
            result=0;
        }
        else if(result==0){
            Toast.makeText(this.context, "Invalid user", Toast.LENGTH_SHORT).show();
        }
        else if(result==2){
            Toast.makeText(this.context, "Invalid password", Toast.LENGTH_SHORT).show();
            result=0;
        }

    }

}

