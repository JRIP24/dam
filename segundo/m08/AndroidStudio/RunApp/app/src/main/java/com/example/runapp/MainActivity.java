package com.example.runapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_TEXT_TITLE = "com.example.startup.EXTRA_TEXT_TITLE";
    public static String EXTRA_TEXT_TRAINER = "com.example.startup.EXTRA_TEXT_TRAINER";
    public static String EXTRA_TEXT_DATE = "com.example.startup.EXTRA_TEXT_DATE";
    public static String EXTRA_TEXT_TIME = "com.example.startup.EXTRA_TEXT_TIME";
    public static String EXTRA_IMAGE = "com.example.startup.EXTRA_IMAGE";
    public static String EXTRA_IMAGES = "com.example.startup.EXTRA_IMAGES";
    public static String EXTRA_TEXT_DESC = "com.example.startup.EXTRA_TEXT_DESC";
    public static String EXTRA_KCAL = "com.example.startup.EXTRA_KCAL";
    public static String EXTRA_DURATION = "com.example.startup.EXTRA_DURATION";
    public static String EXTRA_ROOM = "com.example.startup.EXTRA_ROOM";

    Toolbar toolbar;
    ListView listView;

    int[] spinningImages = {
            R.drawable.spinning1,
            R.drawable.spinning2,
            R.drawable.spinning3,
            R.drawable.spinning4,
            R.drawable.spinning5,
            R.drawable.spinning6
    };

    int[] spartanImages = {
            R.drawable.spartan1,
            R.drawable.spartan2,
            R.drawable.spartan3
    };

    int[] kombatImages = {
            R.drawable.kombat1,
            R.drawable.kombat2,
            R.drawable.kombat3
    };

    int[] zumbaImages = {
            R.drawable.zumba0
    };


    int[] fitnessImages = {
            R.drawable.fitness1,
            R.drawable.fitness2,
            R.drawable.fitness3,
            R.drawable.fitness4,
            R.drawable.fitness5,
            R.drawable.fitness6
    };

    Gym gym1 = new Gym("Spinning", "Peter K","10/10/2020","09:00", R.drawable.spinning0, spinningImages, "Description Spinning", "200kCal", "60 min", "2B");
    Gym gym2 = new Gym("Spartan", "Jhon M","10/10/2020","07:00", R.drawable.spartan0, spartanImages, "Description Spartan", "100kCal", "45 min", "21");
    Gym gym3 = new Gym("Kombat", "Nick J","11/10/2020","11:00", R.drawable.kombat0, kombatImages, "Description for Kombat", "60kCal", "50 min", "3F");
    Gym gym4 = new Gym("Zumba", "Marisol","15/10/2020","07:00", R.drawable.zumba0, zumbaImages, "Description zumba clases", "90kCal", "45 min", "22");
    Gym gym5 = new Gym("Fitness", "Mario B","19/10/2020","10:30", R.drawable.fitness0, fitnessImages, "Description fitness", "200kCal", "60 min", "1G");
    Gym gym6 = new Gym("Spartan", "Jhon K","10/10/2020","07:00", R.drawable.spartan0, spartanImages, "Description Spartan", "200kCal", "60 min", "21");
    Gym gym7 = new Gym("Kombat", "Nick J","11/10/2020","11:00", R.drawable.kombat0, kombatImages, "Description for Kombat", "60kCal", "50 min", "3F");
    ArrayList<Gym> gyms = new ArrayList<>();

    CustomAdapter customAdapter = new CustomAdapter(this, gyms);

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose an option: ");
        menu.add(0, 1, 1, "Reserve");
        menu.add(0, 2, 2, "Info");
        menu.add(0, 3, 3, "Share");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Reserve", Toast.LENGTH_SHORT).show();
                reserve(info.position);
                return true;
            case 2:
                Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void reserve(int position) {

        Intent i = new Intent(getApplicationContext(), BookActivity.class);
        i.putExtra(EXTRA_TEXT_TITLE,gyms.get(position).getClassType());
        i.putExtra(EXTRA_TEXT_TRAINER,gyms.get(position).getTrainer());
        i.putExtra(EXTRA_TEXT_DATE,gyms.get(position).getDate());
        i.putExtra(EXTRA_TEXT_TIME,gyms.get(position).getTime());
        i.putExtra(EXTRA_TEXT_DESC,gyms.get(position).getDescription());
        i.putExtra(EXTRA_IMAGE, gyms.get(position).getImage0());
        i.putExtra(EXTRA_IMAGES, gyms.get(position).getImages());
        i.putExtra(EXTRA_KCAL, gyms.get(position).getkCal());
        i.putExtra(EXTRA_DURATION, gyms.get(position).getDuration());
        i.putExtra(EXTRA_ROOM, gyms.get(position).getRoom());
        startActivity(i);
    }

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
        setContentView(R.layout.activity_main);

        //hook

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);

        gyms.add(gym1);
        gyms.add(gym2);
        gyms.add(gym3);
        gyms.add(gym4);
        gyms.add(gym5);
        gyms.add(gym6);
        gyms.add(gym7);



    }



    private class CustomAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Gym> gyms;

        public CustomAdapter(Context context, ArrayList<Gym> gyms) {
            this.context = context;
            this.gyms = gyms;
        }

        @Override
        public int getCount() {
            return gyms.size();
        }

        @Override
        public Object getItem(int position) {
            return gyms.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Inflar menú row
            View view = getLayoutInflater().inflate(R.layout.row_data, null);

            //Declarar las variables
            TextView textRow = view.findViewById(R.id.textRow);
            ImageView imageRow = view.findViewById(R.id.imageRow);
            TextView trainerText = view.findViewById(R.id.trainerText);
            TextView date = view.findViewById(R.id.date);
            TextView time = view.findViewById(R.id.time);

            ObjectAnimator objectAnimator;

            if(position%2 == 0){

                objectAnimator = ObjectAnimator.ofFloat(view, "x", 1000f, 0f);

                objectAnimator.setDuration(1000);
                objectAnimator.start();

            } else {
                objectAnimator = ObjectAnimator.ofFloat(view, "x", -1000f, 0f);

                objectAnimator.setDuration(1000);
                objectAnimator.start();
            }

            //Setters
            textRow.setText(gyms.get(position).getClassType());
            trainerText.setText(gyms.get(position).getTrainer());
            date.setText(gyms.get(position).getDate());
            time.setText(gyms.get(position).getTime());
            imageRow.setImageResource(gyms.get(position).getImage0());

            return view;
        }
    }
}