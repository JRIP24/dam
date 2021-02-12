package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDesc;
    private ImageView image;

    String title;
    String desc;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hook
        textTitle = findViewById(R.id.textTitle);
        textDesc = findViewById(R.id.textDesc);
        image = findViewById(R.id.image);

        getData();
        setData();


    }

    private void getData() {

        if(
                getIntent().hasExtra("title") &&
                        getIntent().hasExtra("desc") &&
                        getIntent().hasExtra("images") ){

            title = getIntent().getStringExtra("title");
            desc = getIntent().getStringExtra("desc");
            myImage = getIntent().getIntExtra("images", 1);

        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData() {
        textTitle.setText(title);
        textDesc.setText(desc);
        image.setImageResource(myImage);

    }
}