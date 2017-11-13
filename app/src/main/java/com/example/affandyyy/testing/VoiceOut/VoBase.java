package com.example.affandyyy.testing.VoiceOut;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by affandyyy on 27/08/2017.
 */

@IgnoreExtraProperties

public class VoBase {
    public String voPost;
    public String voID;

    public VoBase(){

    }


    public VoBase(String id, String voPost, String voID) {
        this.voPost = voPost;
        this.voID = voID;
    }

    public String getVoPost() {
        return voPost;
    }

    public String getVoID() {
        return voID;
    }
}

