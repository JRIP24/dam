package com.example.splash_screen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BikeAdapter  extends ArrayAdapter<Bike> {

    public BikeAdapter(Context context, ArrayList<Bike> bikesArrayList){

        super(context, 0, bikesArrayList);

    }

    public View init(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){

            //inflaremos el convertView
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row,
                    parent,
                    false
            );

        }

        //hook
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        Bike currentBike = getItem(position);
        if (currentBike != null){

            textView.setText(currentBike.getCoverName());
            imageView.setImageResource(currentBike.getImgCover());
        }

        return convertView;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return  init(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return  init(position, convertView, parent);
    }

}
