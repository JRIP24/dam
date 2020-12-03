package com.example.parcsnacionals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {


    public static String REF_TITLE = "com.example.parcsnacionals.REF_TITLE";
    public static String FER_IMAGE = "com.example.parcsnacionals.FER_IMAGE";

    CardView c1;
    CardView c2;
    CardView c3;
    CardView c4;
    CardView c5;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //hook
        c1 = (CardView) findViewById(R.id.c1);
        c2 = (CardView) findViewById(R.id.c2);
        c3 = (CardView) findViewById(R.id.c3);
        c4 = (CardView) findViewById(R.id.c4);
        c5 = (CardView) findViewById(R.id.c5);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = t1.getText().toString();
                int image = R.drawable.foto1;

                Intent intent = new Intent (DashboardActivity.this, ReservaActivity.class);
                intent.putExtra(REF_TITLE, title);
                intent.putExtra(FER_IMAGE, image);
                startActivity(intent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = t2.getText().toString();
                int image = R.drawable.foto2;

                Intent intent = new Intent (DashboardActivity.this, ReservaActivity.class);
                intent.putExtra(REF_TITLE, title);
                intent.putExtra(FER_IMAGE, image);
                startActivity(intent);
            }
        });



        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = t3.getText().toString();
                int image = R.drawable.foto3;

                Intent intent = new Intent (DashboardActivity.this, ReservaActivity.class);
                intent.putExtra(REF_TITLE, title);
                intent.putExtra(FER_IMAGE, image);
                startActivity(intent);
            }
        });


        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = t4.getText().toString();
                int image = R.drawable.foto4;

                Intent intent = new Intent (DashboardActivity.this, ReservaActivity.class);
                intent.putExtra(REF_TITLE, title);
                intent.putExtra(FER_IMAGE, image);
                startActivity(intent);
            }
        });


        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = t5.getText().toString();
                int image = R.drawable.foto5;

                Intent intent = new Intent (DashboardActivity.this, ReservaActivity.class);
                intent.putExtra(REF_TITLE, title);
                intent.putExtra(FER_IMAGE, image);
                startActivity(intent);
            }
        });






    }
}