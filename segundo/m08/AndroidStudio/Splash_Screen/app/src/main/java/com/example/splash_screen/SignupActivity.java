package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {


    DatePickerDialog picker;
    private EditText textDate;
    private Spinner spinnerClass;
    private Switch switchNewsletter;
    private TextView singUpText;
    private LinearLayout linearLay;

    private ArrayList<Bike> mBike;
    private BikeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        //hook
        textDate = (EditText) findViewById(R.id.textDate);
        spinnerClass = (Spinner) findViewById(R.id.spinnerClass);
        switchNewsletter = (Switch) findViewById(R.id.switchNewsletter);
        singUpText = (TextView) findViewById(R.id.singUpText);
        linearLay = (LinearLayout) findViewById(R.id.linearLay);

        linearLay.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_in
        ));


        singUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });


        //Spinner Class

        mBike = new ArrayList<>();
        mBike.add(new Bike("Bike 1", R.drawable.b3));
        mBike.add(new Bike("Bike 2", R.drawable.b1));

        mAdapter = new BikeAdapter(this, mBike);
        spinnerClass.setAdapter(mAdapter);
        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast
                Toast.makeText(SignupActivity.this, "Nada seleccionado", Toast.LENGTH_SHORT).show();
            }
        });




        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Seleccionamos fecha actual
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);


                picker = new DatePickerDialog(SignupActivity.this, AlertDialog.THEME_HOLO_LIGHT,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //Se muestra la fecha selecionada
                                month++;
                                textDate.setText(dayOfMonth + "/" + month + "/" + year);

                            }
                        }, year, month, day);

                picker.show();

            }
        });



        if (switchNewsletter != null) {
            switchNewsletter.setOnCheckedChangeListener(new
            CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        //Toast.makeText(SignupActivity.this, "" + isChecked,Toast.LENGTH_SHORT).show();
                    } else {
                        //Toast.makeText(SignupActivity.this, "" + isChecked,Toast.LENGTH_SHORT).show();
                    }
                }
            });
}
    }
}