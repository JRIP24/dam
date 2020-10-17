package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String HOME_TAG = MainActivity.class.getSimpleName();
    private static int SPLASH_SCREEN= 4000;


    void logMsg(String mensaje){

        Log.i(HOME_TAG, mensaje);
    }

    void toastMsg(String mensaje){
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void secondA(View view){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                //finish();
            }
        }, SPLASH_SCREEN);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logMsg("Activity created");
        toastMsg("onCreate method called");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        logMsg("Activity started");
        toastMsg("onStart method called");

    }

    @Override
    protected void onResume() {
        super.onResume();

        logMsg("Activity resumed");
        toastMsg("onResume method called");
    }


    @Override
    protected void onPause() {
        super.onPause();

        logMsg("Activity paused");
        toastMsg("onPause method called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        logMsg("Activity stopped");
        toastMsg("onStop method called");
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        logMsg("Activity restarted");
        toastMsg("onRestart method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        logMsg("Activity is being destroyed");
        toastMsg("onDestroy method called");
    }
}