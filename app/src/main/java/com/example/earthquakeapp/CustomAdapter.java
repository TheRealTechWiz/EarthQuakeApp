package com.example.earthquakeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CustomAdapter extends ArrayAdapter<MyWord> {

    public CustomAdapter(Context context, ArrayList<MyWord> arrayList) {
        super(context,0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null){listitemView = LayoutInflater.from(getContext()).inflate(R.layout.app_layout,parent,false);
        }
        MyWord currentWord = getItem(position);

        TextView tmag = listitemView.findViewById(R.id.magnitude);
        tmag.setText(currentWord.getmag());
        TextView tloc = listitemView.findViewById(R.id.location);
        tloc.setText(currentWord.getloc());
        TextView tdate = listitemView.findViewById(R.id.date);
        TextView ttime = listitemView.findViewById(R.id.time);

        Date dateObject = new Date(currentWord.getdate());

        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        tdate.setText(formattedDate);
        ttime.setText(formattedTime);

        return listitemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
