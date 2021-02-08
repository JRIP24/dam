package com.example.animaciongif;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textTitle;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook

        imageView = (ImageView) findViewById(R.id.imageView);
        textTitle = (TextView) findViewById(R.id.textTitle);
        imageView.setBackgroundResource(R.drawable.animation);

        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.setOneShot(false);
        //animationDrawable.start();

        textTitle.setText("Start");
        textTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(textTitle, "alpha", 0f, 1f);
        objectAnimator1.setDuration(500);
        objectAnimator1.setStartDelay(2000);

        objectAnimator1.start();

    }

    //Cuando la actividad esta totalmente cargada..
    //Se puede lanzar la animacion en el oncrate, pero es mejor aqui
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.start();
    }
}