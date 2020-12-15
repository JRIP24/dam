package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_photo:
                //Itents
                Toast.makeText(this, "Foto", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.item_profile:

                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.item_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.item_shop:
                Toast.makeText(this, "Shop", Toast.LENGTH_SHORT).show();
                return  true;

            case android.R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);



    }
}