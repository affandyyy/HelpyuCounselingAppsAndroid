package com.example.affandyyy.testing.Appointment;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by affandyyy on 26/08/2017.
 */

// constructor & getter

@IgnoreExtraProperties

public class Apt {
    public String aptID;
    public String stdName;
    public String stdId;
    public String stdEmail;
    public String spinnerApt;
    public String dateView;

    public Apt(){

    }




    public Apt(String aptID, String stdName, String stdId, String stdEmail, String spinnerApt, String dateView) {
        this.aptID = aptID;
        this.stdName = stdName;
        this.stdId = stdId;
        this.stdEmail = stdEmail;
        this.spinnerApt = spinnerApt;
        this.dateView = dateView;
    }


    public String getAptID() { return aptID; }

    public String getStdName() {
        return stdName;
    }

    public String getStdId() {
        return stdId;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public String getSpinnerApt() { return spinnerApt; }

    public String getDateView() {
        return dateView;
    }


}


//@IgnoreExtraProperties
//public class User {
//
//    public String username;
//    public String email;
//
//    public User() {
//        // Default constructor required for calls to DataSnapshot.getValue(User.class)
//    }
//
//    public User(String username, String email) {
//        this.username = username;
//        this.email = email;
//    }
//
//}