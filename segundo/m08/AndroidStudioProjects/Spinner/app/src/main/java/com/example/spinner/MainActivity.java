package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Spinner spinnerString;
    private Spinner spinnerArrayList;
    private Spinner spinnerClass;

    private List<String> cursos = new ArrayList<String>();
    private ArrayList<DavidBowie> mDavidBowie;
    private  DavidBowieAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hook
        spinnerString = (Spinner) findViewById(R.id.spinnerString);
        spinnerArrayList = (Spinner) findViewById(R.id.spinnerArrayList);
        spinnerClass = (Spinner) findViewById(R.id.spinnerClass);

        cursos.add(0, "Selecciona curs");
        cursos.add("1 ESO");
        cursos.add("2 ESO");
        cursos.add("3 ESO");
        cursos.add("4 ESO");

        //Instanciar DBs
        mDavidBowie = new ArrayList<>();
        mDavidBowie.add(new DavidBowie("Stardust", R.drawable.db8));
        mDavidBowie.add(new DavidBowie("Aladdin Sane", R.drawable.db6));
        mDavidBowie.add(new DavidBowie("Low", R.drawable.db7));
        mDavidBowie.add(new DavidBowie("Heroes", R.drawable.db3));



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                cursos
        );

        spinnerArrayList.setAdapter(dataAdapter);


        spinnerArrayList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String cursSelected = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, cursSelected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });



        ArrayAdapter<String>dataAdapter2 = new ArrayAdapter<>(
                this,
                R.layout.style_spinner_layout,
                getResources().getStringArray(R.array.cursos)
        );

        spinnerString.setAdapter(dataAdapter2);
        dataAdapter2.setDropDownViewResource(R.layout.style_spinner_layout_dropdown);


        spinnerString.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String cursSelected = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, cursSelected, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //Toast
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();

            }
        });


        //Spinner by Class
        mAdapter = new DavidBowieAdapter(this, mDavidBowie);
        spinnerClass.setAdapter(mAdapter);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DavidBowie currentDAvidBowie = (DavidBowie) parent.getItemAtPosition(position);
                String cover = currentDAvidBowie.getCoverName();

                Toast.makeText(MainActivity.this, cover, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //Toast
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });


    }
}