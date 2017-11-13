package com.example.affandyyy.testing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.affandyyy.testing.Appointment.AptMain;
import com.example.affandyyy.testing.Counselor.CLoginActivity;
import com.example.affandyyy.testing.VoiceOut.VoMain;

public class MainActivity extends AppCompatActivity {

    Button nextbtn, adminacc, Updates, Appointment, vobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // untuk address kan kat mana dia duduk
        nextbtn = (Button) findViewById(R.id.ChatStep);


        // declare apa benda yang dia kena buat pula
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChatStep.class));
            }
        });


        vobtn = (Button) findViewById(R.id.VoiceOut);


        // declare apa benda yang dia kena buat pula
        vobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VoMain.class));
            }
        });


        adminacc = (Button) findViewById(R.id.AdminAccess);


        // declare apa benda yang dia kena buat pula
        adminacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CLoginActivity.class));
            }
        });


        Updates = (Button) findViewById(R.id.Updates);


        // declare apa benda yang dia kena buat pula
        Updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Updates.class));
            }
        });



        Appointment = (Button) findViewById(R.id.Appointment);


        // declare apa benda yang dia kena buat pula
        Appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AptMain.class));
            }
        });






    } // onCreate tamat



}
