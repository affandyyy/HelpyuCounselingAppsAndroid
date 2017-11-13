package com.example.affandyyy.testing.Appointment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.affandyyy.testing.R;

import java.util.List;

/**
 * Created by affandyyy on 26/08/2017.
 */

//where to handle list of Apt

public class AptList extends ArrayAdapter<Apt> {
    private Activity context;
    List<Apt> appointments;

    public AptList(Activity context, List<Apt> appointments) {
        super(context, R.layout.apt_list, appointments);
        this.context = context;
        this.appointments = appointments;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.apt_list, null, true);

        TextView stdName = (TextView) listViewItem.findViewById(R.id.stdName);
        TextView stdEmail = (TextView) listViewItem.findViewById(R.id.stdEmail);
        TextView stdId = (TextView) listViewItem.findViewById(R.id.stdId);
        TextView spinnerApt = (TextView) listViewItem.findViewById(R.id.spinnerApt);
        TextView dateView = (TextView) listViewItem.findViewById(R.id.dateView);

        Apt appointment = appointments.get(position);

        stdName.setText(appointment.getStdName());
        stdEmail.setText(appointment.getStdEmail());
        stdId.setText(appointment.getStdId());
        spinnerApt.setText(appointment.getSpinnerApt());
        dateView.setText(appointment.getDateView());

        return listViewItem;
    }
}

