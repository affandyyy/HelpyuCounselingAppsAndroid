package com.example.affandyyy.testing.Counselor;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties

public class Event {
    private String eventID;
    private String eventName;
    private String eventDesc;
    private String eventGenre;

    public Event() {

    }

    public Event(String eventID, String eventName, String eventDesc, String eventGenre) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventGenre = eventGenre;
    }

    public String getEventID() { return eventID; }

    public String getEventName() {
        return eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public String getEventGenre() {
        return eventGenre;
    }
}


