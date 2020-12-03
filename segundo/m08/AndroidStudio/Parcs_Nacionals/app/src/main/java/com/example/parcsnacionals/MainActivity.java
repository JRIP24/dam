package com.example.parcsnacionals;

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

    private static int SPLASH_SCREEN = 4000;
    ImageView mainLogo;
    ImageView backLogo;
    TextView title;
    TextView subTitle;
    ObjectAnimator objectAnimator;
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator3;
    ObjectAnimator objectAnimator4;
    ObjectAnimator objectAnimator5;
    ObjectAnimator objectAnimator6;
    ObjectAnimator objectAnimator7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //hook
        mainLogo = (ImageView) findViewById(R.id.mainLogo);
        backLogo = (ImageView) findViewById(R.id.backLogo);
        title = (TextView) findViewById(R.id.title);
        subTitle = (TextView) findViewById(R.id.subTitle);

        objectAnimator = ObjectAnimator.ofFloat(mainLogo, "x", -1000f, 0f);
        objectAnimator2 = ObjectAnimator.ofFloat(mainLogo, "alpha", 0f, 1f);

        objectAnimator3 = ObjectAnimator.ofFloat(title, "x", 1000f, 0f);
        objectAnimator4 = ObjectAnimator.ofFloat(title, "alpha", 0f, 1f);

        objectAnimator5 = ObjectAnimator.ofFloat(subTitle, "x", 1000f, 0f);
        objectAnimator6 = ObjectAnimator.ofFloat(subTitle, "alpha", 0f, 1f);

        objectAnimator7 = ObjectAnimator.ofFloat(backLogo, "alpha", 0f, 1f);


        objectAnimator.setDuration(2000);
        objectAnimator2.setDuration(2000);
        objectAnimator3.setDuration(2000);
        objectAnimator4.setDuration(2000);
        objectAnimator5.setDuration(2000);
        objectAnimator6.setDuration(2000);
        objectAnimator7.setDuration(6000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator, objectAnimator2, objectAnimator3, objectAnimator4, objectAnimator5, objectAnimator6);
        animatorSet.start();

        objectAnimator7.start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                //Intent
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(mainLogo, "imageapp");
                pairs[1] = new Pair<View, String>(title, "textapp");

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
        h.postDelayed(r, SPLASH_SCREEN);
    }
}