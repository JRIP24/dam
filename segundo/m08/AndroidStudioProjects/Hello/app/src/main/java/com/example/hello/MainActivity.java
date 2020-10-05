package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView textResult;
    private Button btAdd;
    private Button btSubs;
    private Button btMult;
    private Button btDiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Hook = enlace, con los elementos del view
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        textResult = (TextView) findViewById(R.id.textResult);

        btAdd = (Button) findViewById(R.id.btAdd);
        btSubs = (Button) findViewById(R.id.btSubs);
        btMult = (Button) findViewById(R.id.btMult);
        btDiv = (Button) findViewById(R.id.btDiv);


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result = Double.parseDouble(num1.getText().toString().trim())
                        + Double.parseDouble(num2.getText().toString().trim());

                textResult.setText(result + "");
            }
        });


        btSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result = Double.parseDouble(num1.getText().toString().trim())
                        - Double.parseDouble(num2.getText().toString().trim());

                textResult.setText(result + "");

            }
        });


        btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result = Double.parseDouble(num1.getText().toString().trim())
                        * Double.parseDouble(num2.getText().toString().trim());

                textResult.setText(result + "");

            }
        });

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result = Double.parseDouble(num1.getText().toString().trim())
                        / Double.parseDouble(num2.getText().toString().trim());

                textResult.setText(result + "");

            }
        });






    }
}