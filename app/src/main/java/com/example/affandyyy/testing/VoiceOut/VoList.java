package com.example.affandyyy.testing.VoiceOut;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.affandyyy.testing.R;

import java.util.List;

/**
 * Created by affandyyy on 27/08/2017.
 */

public class VoList extends ArrayAdapter<VoBase> {
    private Activity context;
    List<VoBase> voiceout;


    public VoList(Activity context, List<VoBase> voiceout) {
        super(context, R.layout.vo_list, voiceout);
        this.context = context;
        this.voiceout = voiceout;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.vo_list, null, true);

        TextView voPost = (TextView) listViewItem.findViewById(R.id.voPost);
        TextView voID = (TextView) listViewItem.findViewById(R.id.voID);



        VoBase voiceouts = voiceout.get(position);
        voPost.setText(voiceouts.getVoPost());
        voID.setText(voiceouts.getVoID());

        return listViewItem;
    }
}

