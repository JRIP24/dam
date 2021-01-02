package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashSet;

public class SinglePlayerActivity extends AppCompatActivity {

    ImageView deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        //hook
        deck = findViewById(R.id.deck);

        HashSet<String> baraja = new HashSet<String>();


        deck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        


    }
}