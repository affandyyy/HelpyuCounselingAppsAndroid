package com.example.affandyyy.testing.VoiceOut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.affandyyy.testing.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by affandyyy on 27/08/2017.
 */

public class VoMain extends AppCompatActivity implements View.OnClickListener{

    EditText voPost, voID;
    Button btnPost;
    ListView listViewVO;


    //a list to store all the artist from firebase database
    List<VoBase> voiceout;

    //our database reference object
    DatabaseReference databaseVo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vo_main);

        //getting the reference of events node
        databaseVo = FirebaseDatabase.getInstance().getReference("voiceout");

        voPost = (EditText) findViewById(R.id.voPost);
        voID = (EditText) findViewById(R.id.voID);
        listViewVO = (ListView) findViewById(R.id.listViewVO);
        btnPost = (Button) findViewById(R.id.btnPost);

//        editTextName = (EditText) findViewById(R.id.editTextName);
//        editTextDesc = (EditText) findViewById(R.id.editTextDesc);
//        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
//        listViewArtists = (ListView) findViewById(R.id.listViewArtists);
//
//        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);
//        btnApt = (Button) findViewById(R.id.btnApt);


        //list to store events
        voiceout = new ArrayList<>();

        //adding an onclicklistener to button
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addPost();
            }
        });

    } // end onCreate




    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseVo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                voiceout.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting event
                    VoBase vopost = postSnapshot.getValue(VoBase.class);
                    //adding event to the list
                    voiceout.add(vopost);
                }

                //creating adapter
                VoList voAdapter = new VoList(VoMain.this, voiceout);
                //attaching adapter to the listview
                listViewVO.setAdapter(voAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void addPost(){
        //getting the values to save
        String vopost = voPost.getText().toString().trim();
        String vonickname = voID.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(vopost)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Event
            String id = databaseVo.push().getKey();

            //creating an Event Object
            VoBase voiceout = new VoBase(id, vopost, vonickname);

            //Saving the Event
            databaseVo.child(id).setValue(voiceout);

            //setting edittext to blank again
            voPost.setText("");
            voID.setText("");

            //displaying a success toast
            Toast.makeText(this, "Voice-d !", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Update something ?", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {

    }
}
