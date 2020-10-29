package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    boolean frontDone = false;
    boolean flipDone = false;
    ObjectAnimator objectAnimator;
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator3;
    ObjectAnimator objectAnimator4;
    ObjectAnimator objectAnimator5;
    ObjectAnimator objectAnimator6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);


        //MediaPlayer mplayer = MediaPlayer.create(MainActivity.this, R.raw.oldCar);



        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objectAnimator3 = ObjectAnimator.ofFloat(img2, "rotationY", 0f, 180f);
                objectAnimator3.setDuration(1000);

                objectAnimator4 = ObjectAnimator.ofFloat(img2, "alpha", 1f, 0f);
                objectAnimator4.setStartDelay(500);
                objectAnimator4.setDuration(1);

                objectAnimator5 = ObjectAnimator.ofFloat(img3, "alpha", 0f, 1f);
                objectAnimator5.setStartDelay(500);
                objectAnimator5.setDuration(1);

                objectAnimator6 = ObjectAnimator.ofFloat(img3, "rotationY", 0f, 180f);
                objectAnimator6.setDuration(1000);


                if (!flipDone){

                    objectAnimator3.start();
                    objectAnimator4.start();
                    objectAnimator5.start();
                    objectAnimator6.start();

                    flipDone = false;

                }




            }
        });


/*
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objectAnimator5 = ObjectAnimator.ofFloat(img3, "alpha", 1f, 0f);
                objectAnimator5.setStartDelay(500);
                objectAnimator5.setDuration(1);

                objectAnimator6 = ObjectAnimator.ofFloat(img3, "rotationY", 180f, 0f);
                objectAnimator6.setDuration(1000);


                if (flipDone){

                    objectAnimator5.start();
                    objectAnimator6.start();

                    flipDone = true;

                }


            }
        });*/

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectAnimator = ObjectAnimator.ofFloat(img1, "rotationY", 0f, 180f);
                objectAnimator.setDuration(1000);

                objectAnimator2 = ObjectAnimator.ofFloat(img1, "alpha", 1f, 0.2f);
                objectAnimator2.setDuration(1000);

                objectAnimator2.setStartDelay(500);


                objectAnimator.start();
                objectAnimator2.start();
            }
        });

/*
        img1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Animator set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.frontanimator);
                Animator set2 = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.backanimator);


                if (!frontDone){

                    set.setTarget(v);
                    set.start();
                    frontDone = true;

                } else {

                    set2.setTarget(v);
                    set2.start();
                    frontDone = false;
                }




            }
        });*/


    }
}