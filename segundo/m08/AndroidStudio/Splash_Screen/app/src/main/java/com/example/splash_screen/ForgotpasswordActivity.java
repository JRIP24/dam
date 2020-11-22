package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForgotpasswordActivity extends AppCompatActivity {

    private TextView singUpText;
    private LinearLayout linearLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        //hook

        singUpText = (TextView) findViewById(R.id.singUpText);
        linearLay = (LinearLayout) findViewById(R.id.linearLay);

        linearLay.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_in
        ));

        singUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotpasswordActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}