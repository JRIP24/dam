package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String HOME_TAG = MainActivity.class.getSimpleName();


    void logMsg(String mensaje){
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        Log.i(HOME_TAG, mensaje);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logMsg("");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}