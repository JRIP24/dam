package com.example.recyclerviewclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDescription;
    //private ImageView imageDetail;
    private CustomViewPager imageDetailSlider;

    String title, desc, urlImage;
    ArrayList<String> listImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hook
        textTitle = findViewById(R.id.textTitle);
        textDescription = findViewById(R.id.textDescription);
        //imageDetail = findViewById(R.id.imageDetail);
        imageDetailSlider = findViewById(R.id.imageDetailSlider);
        
        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("title") && getIntent().hasExtra("desc") && getIntent().hasExtra("urlImage") && getIntent().hasExtra("urlImages")){
            title = getIntent().getStringExtra("title");
            desc = getIntent().getStringExtra("desc");
            urlImage = getIntent().getStringExtra("urlImage");
            listImages = getIntent().getStringArrayListExtra("urlImages");
        }else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {

        textTitle.setText(title);
        textDescription.setText(desc);

        /*Picasso.get().load(urlImage)
                .fit()
                .centerCrop()
                .into(imageDetail);*/

        ImageAdapter imageAdapter = new ImageAdapter(this, listImages);
        imageDetailSlider.setAdapter(imageAdapter);

    }
}