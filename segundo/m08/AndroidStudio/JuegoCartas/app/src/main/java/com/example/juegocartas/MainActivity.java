package com.example.juegocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button1;
    Button button2;
    ObjectAnimator objectAnimator1;
    ObjectAnimator objectAnimator2;
    AnimatorSet animatorSet1;

    private void animacionFinal() {

        objectAnimator1 = ObjectAnimator.ofFloat(button1, "translationX", 0f, -1000f);
        objectAnimator2 = ObjectAnimator.ofFloat(button2, "translationX", 0f, 1000f);

        objectAnimator1.setDuration(1000);
        objectAnimator2.setDuration(1000);

        animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(objectAnimator1, objectAnimator2);
        animatorSet1.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

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

                animacionFinal();

                //TODO poner un intent para preguntar si se inicia un nuevo juego o se continua uno en caso de haberlo
                Intent intent = new Intent (MainActivity.this, SinglePlayerActivity.class);
                startActivity(intent);


            }

        });






    }




}