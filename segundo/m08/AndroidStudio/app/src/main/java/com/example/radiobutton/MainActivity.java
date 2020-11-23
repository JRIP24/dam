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
        option7.setEnabled(false);
        option8.setEnabled(false);
        option9.setEnabled(false);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){

                    option7.setEnabled(true);
                    option8.setEnabled(true);
                    option9.setEnabled(true);

                } else {

                    radioGroup3.clearCheck();
                    option7.setEnabled(false);
                    option8.setEnabled(false);
                    option9.setEnabled(false);


                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioSelected = radioGroup1.getCheckedRadioButtonId();
                switch (radioSelected){

                    case R.id.option1:
                        Toast.makeText(MainActivity.this, "Option 1", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option2:

                        Toast.makeText(MainActivity.this, "Option 2", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.option3:

                        Toast.makeText(MainActivity.this, "Option 3", Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(MainActivity.this, "Option 4", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option5:

                        Toast.makeText(MainActivity.this, "Option 5", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.option6:

                        Toast.makeText(MainActivity.this, "Option 6", Toast.LENGTH_SHORT).show();

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
                int selected3 = radioGroup3.getCheckedRadioButtonId();

                //Hook
                RadioButton radio1 = (RadioButton) findViewById(selected1);
                RadioButton radio2 = (RadioButton) findViewById(selected2);
                RadioButton radio3 = (RadioButton) findViewById(selected3);

                String mensaje = radio1.getText() + ", " + radio2.getText() + ", " + radio3.getText() + " selected";

                Toast.makeText(MainActivity.this,  mensaje, Toast.LENGTH_SHORT).show();


            }
        });







    }
}