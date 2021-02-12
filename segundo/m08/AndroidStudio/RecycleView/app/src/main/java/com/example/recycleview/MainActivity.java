package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String title[];
    String desc[];

    int images[] = {
            R.drawable.airplane,
            R.drawable.ambulance,
            R.drawable.car,
            R.drawable.helicopter,
            R.drawable.hot_air_balloon,
            R.drawable.bicycle,
            R.drawable.bus,
            R.drawable.blimp,
            R.drawable.ship,
            R.drawable.drone,
    };

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = getResources().getStringArray(R.array.title);
        desc = getResources().getStringArray(R.array.description);

        recyclerView = findViewById(R.id.recycleView);

        MyAdapter myAdapter = new MyAdapter(title, desc, images, this);
        recyclerView.setAdapter(myAdapter);

        //List
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Grid
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2,RecyclerView.VERTICAL, false));
    }
}