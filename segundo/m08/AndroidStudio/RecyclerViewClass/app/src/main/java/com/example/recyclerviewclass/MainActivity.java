package com.example.recyclerviewclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Picture> pictures = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        recyclerView = findViewById(R.id.recyclerView);
        initData();

        MyAdapter myAdapter = new MyAdapter(pictures, this);
        recyclerView.setAdapter(myAdapter);

        //List
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Grid
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3,RecyclerView.VERTICAL, false));


    }


    private void initData(){

        for (int i=1; i <= 38; i++){

            Picture picture;
            if ( i < 10){

                picture = new Picture(
                        "https://joanseculi.com/images/img0"+ i + ".jpg",
                        "Description " + i,
                        "Pic0" + i
                );

            } else {
                picture = new Picture(
                        "https://joanseculi.com/images/img"+ i + ".jpg",
                        "Description " + i,
                        "Pic" + i
                );
            }

            pictures.add(picture);

        }

    }
}