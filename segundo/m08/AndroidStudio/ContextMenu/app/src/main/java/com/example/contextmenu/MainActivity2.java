package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;

    private Integer[] imageIDs = {
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
            R.drawable.plane,
    };

    String[] imageText = {"Plane 1", "Plane 2","Plane 3","Plane 4","Plane 5","Plane 6","Plane 7","Plane 8","Plane 9","Plane 10"};

    CustomAdapter customAdapter = new CustomAdapter();

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose an option: ");
        menu.add(0, 1, 1, "Plane 1");
        menu.add(0, 2, 2, "Plane 2");
        menu.add(0, 3, 3, "Plane 3");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Plane 1", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "Plane 2", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Plane 3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //hook
        listView = findViewById(R.id.listView);
    }

    private class CustomAdapter  extends BaseAdapter {


        @Override
        public int getCount() {
            return imageIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return imageIDs[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_data2, null);

            //Hooks
            TextView textRow = view.findViewById(R.id.textRow);
            ImageView imageRow = view.findViewById(R.id.imageRow);

            textRow.setText(imageText[position]);
            imageRow.setImageResource(imageIDs[position]);

            return view;
        }
    }
}