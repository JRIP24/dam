package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private GridView gridView; //GridView

    List<String> cursos = new ArrayList<>();
    ArrayAdapter<String> dataAdapter;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose an option: ");
        menu.add(0, 1, 1, "Share");
        menu.add(0, 2, 2, "Delete");
        menu.add(0, 3, 3, "Web");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Web", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //hook
        gridView = findViewById(R.id.gridView);
        cursos.add("curso1");
        cursos.add("curso2");
        cursos.add("curso3");
        cursos.add("curso4");
        cursos.add("curso5");
        cursos.add("curso6");
        cursos.add("curso7");
        cursos.add("curso8");
        cursos.add("curso9");
        cursos.add("curso10");
        cursos.add("curso11");
        cursos.add("curso12");
        cursos.add("curso13");
        cursos.add("curso14");
        cursos.add("curso15");
        cursos.add("curso16");
        cursos.add("curso17");
        cursos.add("curso18");
        cursos.add("curso19");
        cursos.add("curso20");

        dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cursos);

        gridView.setAdapter(dataAdapter);
        registerForContextMenu(gridView);
    }
}