package com.example.affandyyy.testing.Appointment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.affandyyy.testing.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by affandyyy on 26/08/2017.
 */

public class AptMain extends AppCompatActivity implements View.OnClickListener{

    //our database reference object
    DatabaseReference databaseApt;

    EditText stdName, stdId, stdEmail;
    Spinner spinnerApt;
    Button aptSubmit;


    //Date
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    //Date




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_apt);


        //Date
        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);


        //Date


        //getting the reference of events node
        databaseApt = FirebaseDatabase.getInstance().getReference("appointments");


        // this for hidupkan xml
        stdName = (EditText) findViewById(R.id.stdName);
        stdId = (EditText) findViewById(R.id.stdId);
        stdEmail = (EditText) findViewById(R.id.stdEmail);
        spinnerApt = (Spinner) findViewById(R.id.spinnerApt);
        aptSubmit = (Button) findViewById(R.id.aptSubmit);


        // from Lab Picker


        // this is for add to database

        aptSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addApt();
            }
        });


    }

    // end of oncreate




    // Date

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Click OK confirm",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }


    // Date











    // for save Apt to database

    private void addApt(){
        //getting the values to save
        String stdname = stdName.getText().toString().trim();
        String stdid = stdId.getText().toString().trim();
        String stdemail = stdEmail.getText().toString().trim();
        String spinnerapt = spinnerApt.getSelectedItem().toString();
        String stddate = dateView.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(stdname)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Event
            String id = databaseApt.push().getKey();

            //creating an Event Object
            Apt appointments = new Apt(id, stdname, stdid, stdemail, spinnerapt, stddate);

            //Saving the Event
            databaseApt.child(id).setValue(appointments);

            //setting edittext to blank again
            stdName.setText("");
            stdId.setText("");
            stdEmail.setText("");


            //displaying a success toast
            Toast.makeText(this, "Appointment submit", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter the details", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {

    }
}




