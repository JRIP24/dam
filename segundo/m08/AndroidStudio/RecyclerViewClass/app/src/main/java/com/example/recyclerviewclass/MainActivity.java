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

        int numImagenesSlider = 4;

        for (int i=1; i <= 38; i++){

            Picture picture;
            ArrayList<String> urls = new ArrayList<>();

            if (i >= 34){//Recogeremos las imagenes anteriores, para que al llegar a 38 no busque 39, 40, etc

                int numImage = i;
                for (int x = 0; x < numImagenesSlider ;x++ ){
                    if (x > 0){
                        numImage--;
                    }
                    urls.add("https://joanseculi.com/images/img"+ numImage + ".jpg");

                }

            } else {
                for (int x = 0; x < numImagenesSlider;x++ ){
                    int numImage = x + i;
                    if (numImage < 10){
                        urls.add("https://joanseculi.com/images/img0"+ numImage + ".jpg");
                    } else {
                        urls.add("https://joanseculi.com/images/img"+ numImage + ".jpg");
                    }

                }
            }


            picture = new Picture(urls, "Desc " + i, "Pic " + i);


            pictures.add(picture);

        }

    }
}