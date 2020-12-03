package com.example.parcsnacionals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservaActivity extends AppCompatActivity {

    ImageView image;
    Spinner spinner;
    EditText fecha;
    EditText fecha2;
    DatePickerDialog picker;
    //TextView text1;
    List<String> refugis = new ArrayList<String>();
    List<Integer> refugisImg = new ArrayList<Integer>();

    RadioGroup radioGroup;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;


    Switch switch1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);


        //hook
        image = (ImageView) findViewById(R.id.image);
        spinner = (Spinner) findViewById(R.id.spinner);
        //text1 = (TextView) findViewById(R.id.text1);
        fecha = (EditText) findViewById(R.id.fecha);
        fecha2 = (EditText) findViewById(R.id.fecha2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option4 = (RadioButton) findViewById(R.id.option4);
        switch1 = (Switch) findViewById(R.id.switch1);


        Intent i = getIntent();

        String texto = i.getStringExtra(DashboardActivity.REF_TITLE);
        int img = i.getIntExtra(DashboardActivity.FER_IMAGE, 0);

        //text1.setText(texto);
        image.setImageResource(img);

        refugis.add(0, "Selecciona Refugi");
        refugis.add("Refugi Josep Maria Blanc");
        refugis.add("Refugi Cap de Llauset");
        refugis.add("Refugi Ventosa i Clavell");
        refugis.add("Refugi Amitges");
        refugis.add("Refugi Josep Maria Montfort");

        refugisImg.add(0);
        refugisImg.add(R.drawable.foto1);
        refugisImg.add(R.drawable.foto2);
        refugisImg.add(R.drawable.foto3);
        refugisImg.add(R.drawable.foto4);
        refugisImg.add(R.drawable.foto5);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, refugis);
        spinner.setAdapter(dataAdapter);


        for (int indice = 0; indice < refugis.size(); indice++){

            if (refugis.get(indice).equals(texto)){

                spinner.setSelection(indice);

            }
        }


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String cursSelected = parent.getItemAtPosition(position).toString();
                image.setImageResource(refugisImg.get(position));
                Toast.makeText(ReservaActivity.this, cursSelected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ReservaActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        Calendar calendar = Calendar.getInstance();

        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        final int year = calendar.get(Calendar.YEAR);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                picker = new DatePickerDialog(
                        ReservaActivity.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public  void onDateSet(DatePicker view, int year, int month, int day){
                                month++;
                                fecha.setText( day + "/" + month + "/" + year);
                            }
                        }, year, month, day
                );
                picker.show();

            }
        });


        fecha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                picker = new DatePickerDialog(
                        ReservaActivity.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public  void onDateSet(DatePicker view, int year, int month, int day){
                                month++;
                                fecha2.setText( day + "/" + month + "/" + year);
                            }
                        }, year, month, day
                );
                picker.show();

            }
        });


        option1.setClickable(false);
        option2.setClickable(false);
        option3.setClickable(false);
        option4.setChecked(true);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Toast.makeText(ReservaActivity.this, "Switch: " + isChecked, Toast.LENGTH_SHORT).show();

                for(int i = 0; i < radioGroup.getChildCount(); i++){
                    ((RadioButton)radioGroup.getChildAt(i)).setClickable(isChecked);
                }

                if(!isChecked){
                    radioGroup.clearCheck();
                }

                if (!isChecked){
                    option4.setChecked(true);
                }


            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioSelected = radioGroup.getCheckedRadioButtonId();

                switch (radioSelected){

                    case R.id.option1:
                        Toast.makeText(ReservaActivity.this, "Vegetariana", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option2:
                        Toast.makeText(ReservaActivity.this, "Sense gluten", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.option3:

                        Toast.makeText(ReservaActivity.this, "Celiac", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.option4:

                        Toast.makeText(ReservaActivity.this, "Cap", Toast.LENGTH_SHORT).show();

                        break;

                    default:
                        break;

                }
            }

        });


    }
}