package com.example.rackathon;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
public class Host extends AppCompatActivity implements View.OnClickListener{
    Button btnDatePicker;
    EditText txtDate;
    public int chour,cmin,cyear,cmonth,cday;
    public static int mYear;
    public static int mMonth;
    public static int mDay;

    public String e_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        Calendar calendar = Calendar.getInstance();
        chour = calendar.get(Calendar.HOUR_OF_DAY);
        e_mail=MainActivity.emails;
        cmin = calendar.get(Calendar.MINUTE);
        btnDatePicker = (Button) findViewById(R.id.btn_date);

        txtDate = (EditText) findViewById(R.id.in_date);


        btnDatePicker.setOnClickListener(this);


    }

    public void onClick(View view) {

        if (view == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog
                    (this,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    mYear = year;
                                    mMonth = monthOfYear;
                                    mDay = dayOfMonth;
                                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            }, mYear, mMonth, mDay);
            datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
            datePickerDialog.show();
        }



    }

    public void host(View view){
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://bulbcontrol.000webhostapp.com/rakathon/book_fair_mail.php?mail="+e_mail;
        //hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);
        Toast.makeText(this, "Check Your E-mail", Toast.LENGTH_LONG).show();
    }
}
