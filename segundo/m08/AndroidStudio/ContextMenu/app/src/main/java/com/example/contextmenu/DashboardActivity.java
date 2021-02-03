package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button listViewBtn;
    private Button listViewImagesBtn;
    private Button gridViewBtn;
    private Button listViewClass;
    private Button listViewBtnActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //hook
        listViewBtn = findViewById(R.id.listViewBtn);
        listViewImagesBtn = findViewById(R.id.listViewImagesBtn);
        gridViewBtn = findViewById(R.id.gridViewBtn);
        listViewClass = findViewById(R.id.listViewClass);
        listViewBtnActionMode = findViewById(R.id.listViewBtnActionMode);

        listViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listViewImagesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        gridViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        listViewClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        listViewBtnActionMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DashboardActivity.this, MainActivityListActionContext.class);
                startActivity(intent);
            }
        });

    }
}