package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;

    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;
    private RadioButton option4;
    private RadioButton option5;
    private RadioButton option6;
    private RadioButton option7;
    private RadioButton option8;
    private RadioButton option9;

    private Button buttonCheck;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //hook

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);

        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option4 = (RadioButton) findViewById(R.id.option4);
        option5 = (RadioButton) findViewById(R.id.option5);
        option6 = (RadioButton) findViewById(R.id.option6);
        option7 = (RadioButton) findViewById(R.id.option7);
        option8 = (RadioButton) findViewById(R.id.option8);
        option9 = (RadioButton) findViewById(R.id.option9);

        buttonCheck = (Button) findViewById(R.id.buttonCheck);
        switch1 = (Switch) findViewById(R.id.switch1);


        //Asignamos disahabilitados por defecto
        radioGroup3.clearCheck();
        /*
        option7.setEnabled(false);
        option8.setEnabled(false);
        option9.setEnabled(false);*/

        option7.setClickable(false);
        option8.setClickable(false);
        option9.setClickable(false);



        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /*
                if (isChecked){

                    /* Manera larga
                    option7.setEnabled(true);
                    option8.setEnabled(true);
                    option9.setEnabled(true);

                    Toast.makeText(MainActivity.this, "Switch: " + isChecked, Toast.LENGTH_SHORT).show();

                    for(int i = 0; i < radioGroup3.getChildCount(); i++){
                        ((RadioButton)radioGroup3.getChildAt(i)).setEnabled(true);
                    }

                } else {

                    radioGroup3.clearCheck();
                    /*
                    option7.setEnabled(false);
                    option8.setEnabled(false);
                    option9.setEnabled(false);

                    Toast.makeText(MainActivity.this, "Switch: " + isChecked, Toast.LENGTH_SHORT).show();

                    for(int i = 0; i < radioGroup3.getChildCount(); i++){
                        ((RadioButton)radioGroup3.getChildAt(i)).setEnabled(false);
                    }


                }*/


                //Para no repetir código se ha implementado de la siguiente manera
                Toast.makeText(MainActivity.this, "Switch: " + isChecked, Toast.LENGTH_SHORT).show();

                for(int i = 0; i < radioGroup3.getChildCount(); i++){
                    //((RadioButton)radioGroup3.getChildAt(i)).setEnabled(isChecked);

                    //Se ha cambiado por clickable porque parece que en el video tutorial se usa este método
                    ((RadioButton)radioGroup3.getChildAt(i)).setClickable(isChecked);
                }

                if(!isChecked){
                    radioGroup3.clearCheck();
                }


            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioSelected = radioGroup1.getCheckedRadioButtonId();
                switch (radioSelected){

                    case R.id.option1:
                        Toast.makeText(MainActivity.this, "Radio Button 1", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option2:

                        Toast.makeText(MainActivity.this, "Radio Button 2", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.option3:

                        Toast.makeText(MainActivity.this, "Radio Button 3", Toast.LENGTH_SHORT).show();

                        break;

                    default:
                        break;

                }



            }

        });


        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioSelected = radioGroup2.getCheckedRadioButtonId();
                switch (radioSelected){

                    case R.id.option4:
                        Toast.makeText(MainActivity.this, "Radio Button 4", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option5:

                        Toast.makeText(MainActivity.this, "Radio Button 5", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.option6:

                        Toast.makeText(MainActivity.this, "Radio Button 6", Toast.LENGTH_SHORT).show();

                        break;

                    default:
                        break;

                }

            }

        });


        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioSelected = radioGroup3.getCheckedRadioButtonId();

                switch (radioSelected){

                    case R.id.option7:
                        Toast.makeText(MainActivity.this, "Radio Button 7", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option8:

                        Toast.makeText(MainActivity.this, "Radio Button 8", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.option9:

                        Toast.makeText(MainActivity.this, "Radio Button 9", Toast.LENGTH_SHORT).show();

                        break;

                    default:
                        break;

                }


            }

        });




        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selected1 = radioGroup1.getCheckedRadioButtonId();
                int selected2 = radioGroup2.getCheckedRadioButtonId();
                int selected3 = -1;
                String textRadio3 = "Disable";

                //Hook
                RadioButton radio1 = (RadioButton) findViewById(selected1);
                RadioButton radio2 = (RadioButton) findViewById(selected2);


                if (switch1.isChecked()){
                    selected3 = radioGroup3.getCheckedRadioButtonId();

                    if (selected3 != -1){

                        RadioButton radio3 = (RadioButton) findViewById(selected3);
                        textRadio3 = radio3.getText().toString();
                    }

                }

                String mensaje = radio1.getText() + "\n" + radio2.getText() + "\n" + textRadio3;

                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();


            }
        });







    }
}