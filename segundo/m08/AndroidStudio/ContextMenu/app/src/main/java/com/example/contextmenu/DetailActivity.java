package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView textDesc;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //hook
        textTitle = findViewById(R.id.textTitle);
        textDesc = findViewById(R.id.textDesc);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String text_Title = intent.getStringExtra(MainActivity4.EXTRA_TEXT_TITLE);
        String text_Desc = intent.getStringExtra(MainActivity4.EXTRA_TEXT_DESC);
        int image_View = intent.getIntExtra(MainActivity4.EXTRA_IMAGE, 1);

        textTitle.setText(text_Title);
        textDesc.setText(text_Desc);
        imageView.setImageResource(image_View);

    }
}