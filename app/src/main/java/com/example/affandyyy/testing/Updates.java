package com.example.affandyyy.testing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.affandyyy.testing.Counselor.ArtistList;
import com.example.affandyyy.testing.Counselor.Event;
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


public class Updates extends AppCompatActivity {



    //view objects


    //form materials
    ListView listViewArtists;

    //a list to store all the artist from firebase database
    List<Event> events;

    //our database reference object
    DatabaseReference databaseEvents;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);



        //getting the reference of events node
        databaseEvents = FirebaseDatabase.getInstance().getReference("events");

        //getting views-
        listViewArtists = (ListView) findViewById(R.id.listViewArtists);


        //list to store events
        events = new ArrayList<>();



    } // end of oncreate



    // form materials



    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                events.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting event
                    Event event = postSnapshot.getValue(Event.class);
                    //adding event to the list
                    events.add(event);
                }

                //creating adapter
                ArtistList artistAdapter = new ArtistList(Updates.this, events);
                //attaching adapter to the listview
                listViewArtists.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }





}
