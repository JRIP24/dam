package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button1;
    Button button2;
    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        objectAnimator1 = ObjectAnimator.ofFloat(button1, "translationX", -1000f, 0f);
        objectAnimator2 = ObjectAnimator.ofFloat(button2, "translationX", 1000f, 0f);

        objectAnimator1.setDuration(2000);
        objectAnimator2.setDuration(2000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.start();




    }
}