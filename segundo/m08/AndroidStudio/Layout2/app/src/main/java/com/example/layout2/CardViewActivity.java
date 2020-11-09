package com.example.layout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends AppCompatActivity {

    private TextView textTitle;
    private TextView secondTitle;
    private TextView price;
    private TextView dificultyText;
    private TextView durationText;
    private ImageView imageTop;
    private ImageView secondImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        //hook
        textTitle = (TextView) findViewById(R.id.textTitle);
        secondTitle = (TextView) findViewById(R.id.secondTitle);
        price = (TextView) findViewById(R.id.price);
        dificultyText = (TextView) findViewById(R.id.dificultyText);
        durationText = (TextView) findViewById(R.id.durationText);
        imageTop = (ImageView) findViewById(R.id.imageTop);
        secondImage = (ImageView) findViewById(R.id.secondImage);

        Intent i = getIntent();

        String sLangTitle = i.getStringExtra(MainActivity.LANG_TITLE);
        String sPrice = i.getStringExtra(MainActivity.LANG_PRICE);
        String sDifictulty = i.getStringExtra(MainActivity.LANG_DIFICULTY);
        String sDurada = i.getStringExtra(MainActivity.LANG_DURATION);
        int img = i.getIntExtra(MainActivity.LANG_IMAGE, 0);

        textTitle.setText(sLangTitle);
        secondTitle.setText(sLangTitle);
        price.setText(sPrice);
        dificultyText.setText(dificultyText.getText() + " " + sDifictulty);
        durationText.setText(durationText.getText() + " " + sDurada);
        imageTop.setImageResource(img);
        secondImage.setImageResource(img);





    }
}