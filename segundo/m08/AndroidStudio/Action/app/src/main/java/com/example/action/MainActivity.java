package com.example.action;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button webViewBtn;
    Button webBtn;
    Button MapsBtn;
    Button instagramBtn;
    Button facebookBtn;
    Button mailBtn;
    Button callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        webViewBtn = findViewById(R.id.webViewBtn);
        webBtn = findViewById(R.id.webBtn);
        MapsBtn = findViewById(R.id.MapsBtn);
        instagramBtn = findViewById(R.id.instagramBtn);
        facebookBtn = findViewById(R.id.facebookBtn);
        mailBtn = findViewById(R.id.mailBtn);
        callBtn = findViewById(R.id.callBtn);


        webViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });



        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("instagram://edtbarcelona");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    //Si no troba la app Instagram, obrirà internet
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/edtbarcelona")));
                }
            }
        });


        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlId ="fb://page/proactivaservice";
                String urlUrl ="https://www.facebook.com/proactivaservice";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlId)));
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlUrl)));
                }
            }
        });
    }
}