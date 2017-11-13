package com.example.affandyyy.testing.Appointment;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.affandyyy.testing.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by affandyyy on 12/08/2017.
 */


public class AptCounselor extends AppCompatActivity {



    //view objects


    //form materials
    ListView listViewApt;

    //a list to store all the artist from firebase database
    List<Apt> appointments;

    //our database reference object
    DatabaseReference databaseApt;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apt_counselor);



        //getting the reference of events node
        databaseApt = FirebaseDatabase.getInstance().getReference("appointments");

        //getting views-
        listViewApt = (ListView) findViewById(R.id.listViewApt);


        //list to store events
        appointments = new ArrayList<>();



    } // end of oncreate



    // form materials



    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseApt.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                appointments.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting event
                    Apt apt = postSnapshot.getValue(Apt.class);
                    //adding event to the list
                    appointments.add(apt);
                }

                //creating adapter
                AptList aptAdapter = new AptList(AptCounselor.this, appointments);
                //attaching adapter to the listview
                listViewApt.setAdapter(aptAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }





}
