package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private TextView subTitle;
    ObjectAnimator objectAnimator;
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator3;
    ObjectAnimator objectAnimator4;
    ObjectAnimator objectAnimator5;
    ObjectAnimator objectAnimator6;

    private static int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        subTitle = (TextView) findViewById(R.id.subTitle);

        objectAnimator = ObjectAnimator.ofFloat(imageView, "y", -1000f, 0f);
        objectAnimator2 = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);

        objectAnimator3 = ObjectAnimator.ofFloat(textView, "y", 5000f, 1100f);
        objectAnimator4 = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);

        objectAnimator5 = ObjectAnimator.ofFloat(subTitle, "y", 5000f, 1400f);
        objectAnimator6 = ObjectAnimator.ofFloat(subTitle, "rotation", 360f, 0f);




        objectAnimator.setDuration(2000);
        objectAnimator2.setDuration(2000);
        objectAnimator3.setDuration(2000);
        objectAnimator4.setDuration(2000);
        objectAnimator5.setDuration(2000);
        objectAnimator6.setDuration(2000);

        //objectAnimator.start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator, objectAnimator2, objectAnimator3, objectAnimator4, objectAnimator5, objectAnimator6);
        animatorSet.start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                //Intent
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(imageView, "imageapp");
                pairs[1] = new Pair<View, String>(textView, "textapp");

                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this, pairs
                    );

                    startActivity(intent, options.toBundle());
                }

            }
        };


        Handler h = new Handler(Looper.getMainLooper());
        //Handler h = new Handler();
        h.postDelayed(r, SPLASH_SCREEN);
    }
}