package com.example.runapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView trainer;
    TextView description;
    TextView kcal;
    TextView duration;
    TextView room;
    TextView date;
    TextView time;

    Toolbar toolbar;

    GridView gridView;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.user:
                Toast.makeText(this, "User", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cart:
                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
                return true;

            case android.R.id.home:
                //intents
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        trainer = findViewById(R.id.trainer);
        description = findViewById(R.id.description);
        kcal = findViewById(R.id.kcal);
        duration = findViewById(R.id.duration);
        room = findViewById(R.id.room);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        gridView = findViewById(R.id.gridView);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        int[] images = intent.getIntArrayExtra(MainActivity.EXTRA_IMAGES);
        String text_Title = intent.getStringExtra(MainActivity.EXTRA_TEXT_TITLE);
        String text_Desc = intent.getStringExtra(MainActivity.EXTRA_TEXT_DESC);
        String trainerText = intent.getStringExtra(MainActivity.EXTRA_TEXT_TRAINER);
        String dateText = intent.getStringExtra(MainActivity.EXTRA_TEXT_DATE);
        String timeText = intent.getStringExtra(MainActivity.EXTRA_TEXT_TIME);
        String kcalText = intent.getStringExtra(MainActivity.EXTRA_KCAL);
        String durationText = intent.getStringExtra(MainActivity.EXTRA_DURATION);
        String roomText = intent.getStringExtra(MainActivity.EXTRA_ROOM);

        int image_View = intent.getIntExtra(MainActivity.EXTRA_IMAGE, 1);


        textView.setText(text_Title);
        description.setText(text_Desc);
        trainer.setText(trainerText);
        kcal.setText(kcalText);
        duration.setText(durationText);
        room.setText(roomText);
        date.setText(dateText);
        time.setText(timeText);
        imageView.setImageResource(images[0]);


        CustomAdapter customAdapter = new CustomAdapter(this, images);
        gridView.setAdapter(customAdapter);
    }

    private class CustomAdapter extends BaseAdapter {

        private Context context;
        private int[] images;

        public CustomAdapter(Context context, int[] images) {
            this.context = context;
            this.images = images;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Inflar menú row
            View view = getLayoutInflater().inflate(R.layout.grid_images, null);

            //Declarar las variables
            ImageView imageG = view.findViewById(R.id.image4grid);

            //Setters
            imageG.setImageResource(images[position]);

            return view;
        }
    }
}