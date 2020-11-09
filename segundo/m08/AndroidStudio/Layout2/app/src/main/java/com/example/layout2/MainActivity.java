package com.example.layout2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String LANG_TITLE = "com.example.layout2.LANG_TITLE";
    public static String LANG_IMAGE = "com.example.layout2.LANG_IMAGE";
    public static String LANG_PRICE = "com.example.layout2.LANG_PRICE";
    public static String LANG_DIFICULTY = "com.example.layout2.LANG_DIFICULTY";
    public static String LANG_DURATION = "com.example.layout2.LANG_DURATION";

    TextView titulo;
    TextView subTitulo;
    CardView card1;
    CardView card2;
    CardView card3;
    CardView card4;
    CardView card5;
    CardView card6;
    CardView card7;
    CardView card8;
    CardView card9;
    CardView card10;
    CardView card11;
    CardView card12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook
        titulo = (TextView) findViewById(R.id.title);
        subTitulo = (TextView) findViewById(R.id.subTitle);
        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);
        card5 = (CardView) findViewById(R.id.card5);
        card6 = (CardView) findViewById(R.id.card6);
        card7 = (CardView) findViewById(R.id.card7);
        card8 = (CardView) findViewById(R.id.card8);
        card9 = (CardView) findViewById(R.id.card9);
        card10 = (CardView) findViewById(R.id.card10);
        card11 = (CardView) findViewById(R.id.card11);
        card12 = (CardView) findViewById(R.id.card12);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Rusian";
                int image = R.drawable.russia;
                String price = "80€";
                String duration = "1200h";
                String dificulty = "8/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Garmany";
                int image = R.drawable.germany;
                String price = "20€";
                String duration = "120h";
                String dificulty = "8/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Spanish";
                int image = R.drawable.spain;
                String price = "20€";
                String duration = "100h";
                String dificulty = "5/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Chinese";
                int image = R.drawable.china;
                String price = "200€";
                String duration = "3000h";
                String dificulty = "10/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "English";
                int image = R.drawable.uk;
                String price = "200€";
                String duration = "2000h";
                String dificulty = "5/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "French";
                int image = R.drawable.france;
                String price = "150€";
                String duration = "2000h";
                String dificulty = "7/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Italian";
                int image = R.drawable.italy;
                String price = "70€";
                String duration = "200h";
                String dificulty = "6/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Turkish";
                int image = R.drawable.turkey;
                String price = "200€";
                String duration = "2000h";
                String dificulty = "8/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Portuguese";
                int image = R.drawable.portugal;
                String price = "300€";
                String duration = "1200h";
                String dificulty = "6/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Swedish";
                int image = R.drawable.sweden;
                String price = "300€";
                String duration = "3000h";
                String dificulty = "8/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Japanese";
                int image = R.drawable.japan;
                String price = "500€";
                String duration = "3000h";
                String dificulty = "10/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });


        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = "Ukrainian";
                int image = R.drawable.ukraine;
                String price = "200€";
                String duration = "2000h";
                String dificulty = "8/10";

                Intent intent = new Intent (MainActivity.this, CardViewActivity.class);
                intent.putExtra(LANG_TITLE, title);
                intent.putExtra(LANG_IMAGE, image);
                intent.putExtra(LANG_PRICE, price);
                intent.putExtra(LANG_DIFICULTY, dificulty);
                intent.putExtra(LANG_DURATION, duration);
                startActivity(intent);
            }
        });





    }
}