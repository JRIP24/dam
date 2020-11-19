package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

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
    private static int SPLASH_SCREEN = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

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