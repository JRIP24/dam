package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private ImageView img1;
    private ImageView img1_2;
    private ImageView img2;
    private ImageView img2_2;
    private ImageView img3;
    private ImageView img3_2;
    private ImageView img4;
    private ImageView img4_2;
    private ImageView img5;
    private LinearLayout layout;

    private boolean img1Flipped = false;
    private boolean img2Flipped = false;
    private boolean img3Flipped = false;
    private boolean img4Flipped = false;
    private boolean img5Flipped = false;

    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator3;
    ObjectAnimator objectAnimator4;



    boolean flipImage(ImageView imagen1, ImageView imagen2, String eje, boolean flipped){



        if (!flipped){

            objectAnimator1 = ObjectAnimator.ofFloat(imagen1, eje, 0f, 180f);
            objectAnimator1.setDuration(1000);

            objectAnimator2 = ObjectAnimator.ofFloat(imagen1, "alpha",1f, 0f);
            objectAnimator2.setStartDelay(500);


            objectAnimator3 = ObjectAnimator.ofFloat(imagen2, eje, 0f, 180f);
            objectAnimator3.setDuration(1000);
            objectAnimator4 = ObjectAnimator.ofFloat(imagen2, "alpha", 0f, 1f);
            objectAnimator4.setStartDelay(500);
            objectAnimator4.setDuration(1);


            flipped = true;

        } else {

            objectAnimator1 = ObjectAnimator.ofFloat(imagen1, eje, 180f, 0f);
            objectAnimator1.setDuration(1000);

            objectAnimator2 = ObjectAnimator.ofFloat(imagen1, "alpha",0f, 1f);
            objectAnimator2.setStartDelay(500);


            objectAnimator3 = ObjectAnimator.ofFloat(imagen2, eje, 180f, 0f);
            objectAnimator3.setDuration(1000);
            objectAnimator4 = ObjectAnimator.ofFloat(imagen2, "alpha", 1f, 0f);
            objectAnimator4.setStartDelay(500);
            objectAnimator4.setDuration(1);



            flipped = false;

        }

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3, objectAnimator4);
        animatorSet.start();

        return  flipped;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Hook
        img1 = (ImageView) findViewById(R.id.img1);
        img1_2 = (ImageView) findViewById(R.id.img1_2);
        img2 = (ImageView) findViewById(R.id.img2);
        img2_2 = (ImageView) findViewById(R.id.img2_2);
        img3 = (ImageView) findViewById(R.id.img3);
        img3_2 = (ImageView) findViewById(R.id.img3_2);
        img4 = (ImageView) findViewById(R.id.img4);
        img4_2 = (ImageView) findViewById(R.id.img4_2);
        img5 = (ImageView) findViewById(R.id.img5);
        layout = (LinearLayout) findViewById(R.id.layout);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img1Flipped = flipImage(img1, img1_2, "rotationY", img1Flipped);
            }
        });


        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img2Flipped = flipImage(img2, img2_2, "rotationX", img2Flipped);
            }
        });


        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img3Flipped = flipImage(img3, img3_2, "rotationY", img3Flipped);
            }
        });


        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img4Flipped = flipImage(img4, img4_2, "rotationY", img4Flipped);
            }
        });



        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!img5Flipped){

                    objectAnimator1 = ObjectAnimator.ofFloat(img5, "rotationY", 0f, 180f);
                    objectAnimator1.setDuration(1000);

                    objectAnimator2 = ObjectAnimator.ofFloat(img5, "alpha",1f, 0.5f);
                    objectAnimator2.setStartDelay(500);


                    objectAnimator3 = ObjectAnimator.ofFloat(layout, "rotationY", -180f, 0f);
                    objectAnimator3.setDuration(1000);
                    objectAnimator4 = ObjectAnimator.ofFloat(layout, "alpha", 0f, 1f);
                    objectAnimator4.setStartDelay(500);
                    objectAnimator4.setDuration(1);


                    img5Flipped = true;

                } else {

                    objectAnimator1 = ObjectAnimator.ofFloat(img5, "rotationY", 180f, 0f);
                    objectAnimator1.setDuration(1000);

                    objectAnimator2 = ObjectAnimator.ofFloat(img5, "alpha",0.5f, 1f);
                    objectAnimator2.setStartDelay(500);


                    objectAnimator3 = ObjectAnimator.ofFloat(layout, "rotationY", 0f, -180f);
                    objectAnimator3.setDuration(1000);
                    objectAnimator4 = ObjectAnimator.ofFloat(layout, "alpha", 1f, 0f);
                    objectAnimator4.setStartDelay(500);
                    objectAnimator4.setDuration(1);



                    img5Flipped = false;

                }

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimator1, objectAnimator2, objectAnimator3, objectAnimator4);
                animatorSet.start();

            }
        });






    }
}