package com.example.animaciongif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ImageView imageView3;
    TextView textView3;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //hook

        imageView3 = findViewById(R.id.imageView3);
        textView3 = findViewById(R.id.textView3);

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });




        animation = new AnimationDrawable();

        //animation.addFrame(getResources().getDrawable(R.drawable.rocket17), 20);

        String sImage = "spaceship";
        for (int i = 1; i <= 225;i++){
            animation.addFrame(
                    getResources().getDrawable(
                            getResources().getIdentifier(sImage + i, "drawable",
                                    getPackageName())),20);
        }

        animation.setOneShot(false);
        imageView3.setImageDrawable(animation);
        animation.start();

    }
}