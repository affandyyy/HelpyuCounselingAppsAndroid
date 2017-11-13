package com.example.affandyyy.testing.Counselor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.affandyyy.testing.R;

import java.util.List;



public class ArtistList extends ArrayAdapter<Event> {
    private Activity context;
    List<Event> events;

    public ArtistList(Activity context, List<Event> events) {
        super(context, R.layout.layout_artist_list, events);
        this.context = context;
        this.events = events;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_artist_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.textViewDesc);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Event event = events.get(position);

        textViewName.setText(event.getEventName());
        textViewDesc.setText(event.getEventDesc());
        textViewGenre.setText(event.getEventGenre());

        return listViewItem;
    }
}