package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int WAIT_SCREEN = 1000;
    private static final String HOME_TAG = MainActivity.class.getSimpleName();

    private EditText num1;
    private EditText num2;
    private TextView textResult;
    private Button btAdd;
    private Button btSubs;
    private Button btMult;
    private Button btDiv;
    private Button btPow;
    private Button btCle;


    void errorMsg(String mensaje){
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        Log.w(HOME_TAG, "Mensaje warning");
    }

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
        btPow = (Button) findViewById(R.id.btPow);
        btCle = (Button) findViewById(R.id.btCle);





        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num1.getText().toString().trim().isEmpty() || num2.getText().toString().trim().isEmpty()){

                    errorMsg("Enter a number");

                } else{

                    double result = Double.parseDouble(num1.getText().toString().trim())
                            + Double.parseDouble(num2.getText().toString().trim());

                    textResult.setText(result + "");
                }

            }
        });


        btSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (num1.getText().toString().trim().isEmpty() || num2.getText().toString().trim().isEmpty()){

                    errorMsg("Enter a number");

                } else{

                    double result = Double.parseDouble(num1.getText().toString().trim())
                            - Double.parseDouble(num2.getText().toString().trim());

                    textResult.setText(result + "");
                }




            }
        });


        btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (num1.getText().toString().trim().isEmpty() || num2.getText().toString().trim().isEmpty()){

                    errorMsg("Enter a number");

                } else{

                    double result = Double.parseDouble(num1.getText().toString().trim())
                            * Double.parseDouble(num2.getText().toString().trim());

                    textResult.setText(result + "");
                }



            }
        });

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num1.getText().toString().trim().isEmpty() || num2.getText().toString().trim().isEmpty()){

                    errorMsg("Enter a number");

                } else{

                    double n2 = Double.parseDouble(num2.getText().toString().trim());

                    if (n2 == 0.0){

                        errorMsg("Divide by zero impossible");
                        Log.e(HOME_TAG, "Impossible divide by " +  num2.getText().toString());

                    } else{

                        double result = Double.parseDouble(num1.getText().toString().trim())
                                / n2;

                        textResult.setText(result + "");
                    }

                }

            }
        });

        btPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num1.getText().toString().trim().isEmpty() || num2.getText().toString().trim().isEmpty()){

                    errorMsg("Enter a number");

                } else{

                    double result = Math.pow(Double.parseDouble(num1.getText().toString().trim()), Double.parseDouble(num2.getText().toString().trim()));

                    textResult.setText(result + "");


                }

            }
        });

        btCle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText("0");
            }
        });



    }


    public void aboutUs(View view){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent);
                finish();//Para cerrar la pantalla anterior, si era la principal, al darle a volver irá a la pantala de inicio del móvil.

            }
        }, WAIT_SCREEN);

    }
}