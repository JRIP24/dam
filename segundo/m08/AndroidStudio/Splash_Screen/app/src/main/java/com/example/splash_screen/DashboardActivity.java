package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView signUp;
    private TextView forgotPassText;
    private LinearLayout linearLay;

    ObjectAnimator objectAnimator;
    ObjectAnimator objectAnimator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //hook
        signUp = (TextView) findViewById(R.id.singUpText);
        forgotPassText = (TextView) findViewById(R.id.forgotPassText);
        linearLay = (LinearLayout) findViewById(R.id.linearLay);


        linearLay.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_in
        ));

        /*
        objectAnimator = ObjectAnimator.ofFloat(linearLay, "scaleY", 0f, 100f);
        objectAnimator2 = ObjectAnimator.ofFloat(linearLay, "scaleX", 0f, 100f);

        objectAnimator.setDuration(3000);
        objectAnimator2.setDuration(3000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator, objectAnimator2);
        animatorSet.start();*/


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        forgotPassText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(DashboardActivity.this, ForgotpasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}