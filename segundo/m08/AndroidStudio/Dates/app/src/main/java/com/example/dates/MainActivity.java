package com.example.dates;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText textDate;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook
        textDate = (EditText) findViewById(R.id.textDate);

        Calendar calendar = Calendar.getInstance();

        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        final int year = calendar.get(Calendar.YEAR);

        //month++;

        Toast.makeText(this, day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();


        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                picker = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public  void onDateSet(DatePicker view, int year, int month, int day){

                                //setText
                                month++;
                                textDate.setText( day + "/" + month + "/" + year);


                            }
                        }, year, month, day
                );

                picker.show();

            }
        });




    }
}