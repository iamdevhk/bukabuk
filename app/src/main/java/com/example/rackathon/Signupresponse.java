package com.example.rackathon;








import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class Signupresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public Signupresponse(Context context) {
        this.context = context;
    }


    public static String response="";
    public String name=Signup.name;
    public String email=Signup.email;
    public String phnnum=Signup.phnnum;
    public String cllg=Signup.cllg;
    public String loc=Signup.loc;
    public String course=Signup.course;
    public String password=Signup.pass;

    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://bulbcontrol.000webhostapp.com/rakathon/signup.php?name="+ name+"&email="+ email+"&phnnum="+ phnnum+"&cllg="+ cllg+"&loc="+ loc+"&course="+ course+"&pass="+ password;
        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                response = jsonObj.getString("val");
                Log.v("Hk", response);

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


            Toast.makeText(this.context, "Successfully Signed up", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, MainActivity.class));//the website should return the samed number if theres no entry for it
        }

    }

}

