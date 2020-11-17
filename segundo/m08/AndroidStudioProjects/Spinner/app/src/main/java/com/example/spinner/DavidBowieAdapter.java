package com.example.spinner;

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

public class DavidBowieAdapter extends ArrayAdapter<DavidBowie> {

    public DavidBowieAdapter(Context context, ArrayList<DavidBowie> davidBowieArrayList){

        super(context, 0, davidBowieArrayList);

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

        DavidBowie currentDavidBowie = getItem(position);
        if (currentDavidBowie != null){

            textView.setText(currentDavidBowie.getCoverName());
            imageView.setImageResource(currentDavidBowie.getImgCover());
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
