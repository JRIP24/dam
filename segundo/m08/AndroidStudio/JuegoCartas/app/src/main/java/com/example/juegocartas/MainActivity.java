package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ObjectStreamException;

public class MainActivity extends AppCompatActivity {

    static final String FILE_SHARED_NAME = "Socores_singlePlayer";
    static String GAME_RESUMED = "com.example.juegocartas.GAME_RESUMED";


    Button button1;
    Button button2;
    Button resumeBtn;
    Button newBtn;
    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;
    AnimatorSet animatorSet1;
    boolean gameResumed = false;

    private void animacionFinal() {

        objectAnimator1 = ObjectAnimator.ofFloat(button1, "translationX", 0f, -1000f);
        objectAnimator2 = ObjectAnimator.ofFloat(button2, "translationX", 0f, 1000f);

        objectAnimator1.setDuration(1000);
        objectAnimator2.setDuration(1000);

        animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(objectAnimator1, objectAnimator2);
        animatorSet1.start();
    }

    private void chargeSinglePlayer(boolean gameResumed) {

        Intent intent = new Intent (MainActivity.this, SinglePlayerActivity.class);

        if (gameResumed){
            intent.putExtra(GAME_RESUMED, gameResumed);
        }

        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        resumeBtn = findViewById(R.id.resumeBtn);
        newBtn = findViewById(R.id.newBtn);

        objectAnimator1 = ObjectAnimator.ofFloat(button1, "translationX", -1000f, 0f);
        objectAnimator2 = ObjectAnimator.ofFloat(button2, "translationX", 1000f, 0f);

        objectAnimator1.setDuration(1000);
        objectAnimator2.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.start();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
                int scoreBank = sharedPreferences.getInt("scoreBank", -1);
                int scorePlayer = sharedPreferences.getInt("scorePlayer", -1);

                if (scoreBank <= 0 && scorePlayer <= 0){ //No hay datos guardados (o se guardó 0-0)

                    chargeSinglePlayer(false);

                } else {

                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(button1, "translationX", 0f, -1000f );
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(button2, "translationX", 0f, 1000f );

                    animator1.setDuration(1000);
                    animator2.setDuration(1000);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(animator1, animator2);
                    animatorSet2.start();

                    animatorSet2.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                            resumeBtn.setVisibility(View.VISIBLE);
                            newBtn.setVisibility(View.VISIBLE);

                            ObjectAnimator animator1 = ObjectAnimator.ofFloat(resumeBtn, "translationX", -1000f, 0f );
                            ObjectAnimator animator2 = ObjectAnimator.ofFloat(newBtn, "translationX", 1000f, 0f );

                            animator1.setDuration(1000);
                            animator2.setDuration(1000);
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.playTogether(animator1, animator2);
                            animatorSet2.start();

                        }
                    });

                }


            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (MainActivity.this, MultiplayerActivity.class);
                startActivity(intent);

            }

        });


        resumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chargeSinglePlayer(true);

            }
        });

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargeSinglePlayer(false);
            }
        });


    }




}