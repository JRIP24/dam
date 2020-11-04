package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;

    private boolean img1Flipped = false;

    ObjectAnimator objectAnimator1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Hook
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!img1Flipped){

                    objectAnimator1 = ObjectAnimator.ofFloat(img1, "RotationY", 0f, 180f);
                    img1Flipped = true;

                } else {

                    objectAnimator1 = ObjectAnimator.ofFloat(img1, "RotationY", 180f, 0f);
                    img1Flipped = false;

                }

                objectAnimator1.setDuration(1000);
                objectAnimator1.start();
            }
        });



    }
}