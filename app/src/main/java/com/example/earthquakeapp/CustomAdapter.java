package com.example.earthquakeapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CustomAdapter extends ArrayAdapter<MyWord> {
    private static final String LOCATION_SEPARATOR = " of ";

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

        //----------magnitude------
        TextView tmag = listitemView.findViewById(R.id.magnitude);
        String mag = formatMagnitude(currentWord.getmag());
        tmag.setText(mag);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) tmag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentWord.getmag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        //-----------location------
        TextView locoffset = listitemView.findViewById(R.id.offset);
        TextView locplace = listitemView.findViewById(R.id.place);

        String name = currentWord.getloc();
//        String[] arraystring  = name.split("of ");
        String ofset;
        String place;
//        if (arraystring.length == 2){
//             ofset = arraystring[0]+"of";
//             place = arraystring[1]; }
//        else {
//            ofset = "Near";
//            place = arraystring[0]; }


        if (name.contains(LOCATION_SEPARATOR)) {
            String[] parts = name.split(LOCATION_SEPARATOR);
            ofset = parts[0] + LOCATION_SEPARATOR;
            place = parts[1];
        } else {
            ofset = "Near the";
            place = name;
        }
         locoffset.setText(ofset);
         locplace.setText(place);

        // ---------Date-----
        TextView tdate = listitemView.findViewById(R.id.date);
        TextView ttime = listitemView.findViewById(R.id.time);
        Date dateObject = new Date(currentWord.getdate());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        tdate.setText(formattedDate);
        ttime.setText(formattedTime);

        return listitemView;
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLL, yyyy");
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
