package com.example.recyclerviewclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDescription;
    private ImageView imageDetail;

    String title, desc, urlImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hook
        textTitle = findViewById(R.id.textTitle);
        textDescription = findViewById(R.id.textDescription);
        imageDetail = findViewById(R.id.imageDetail);
        
        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("title") && getIntent().hasExtra("desc") && getIntent().hasExtra("urlImage")){
            title = getIntent().getStringExtra("title");
            desc = getIntent().getStringExtra("desc");
            urlImage = getIntent().getStringExtra("urlImage");
        }else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {

        textTitle.setText(title);
        textDescription.setText(desc);

        Picasso.get().load(urlImage)
                .fit()
                .centerCrop()
                .into(imageDetail);

    }
}