package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int[] mImagesIds = new int[]{
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto1,
            R.drawable.foto2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //hook
        ViewPager viewPager = findViewById(R.id.viewPager);

        ImageAdapter imageAdapter = new ImageAdapter(this, mImagesIds);
        viewPager.setAdapter(imageAdapter);
    }
}