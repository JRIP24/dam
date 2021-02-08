package com.example.animaciongif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView2;
    TextView textTitle2;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //hook
        imageView2 = findViewById(R.id.imageView2);
        textTitle2 = findViewById(R.id.textTitle2);


        textTitle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);

            }
        });


        animation = new AnimationDrawable();

        //animation.addFrame(getResources().getDrawable(R.drawable.rocket17), 20);

        String sImage = "rocket";
        for (int i = 17; i <= 167;i++){
            animation.addFrame(
                    getResources().getDrawable(
                            getResources().getIdentifier(sImage + i, "drawable",
                                    getPackageName())),20);
        }

        animation.setOneShot(true);
        imageView2.setImageDrawable(animation);
        animation.start();

    }
}