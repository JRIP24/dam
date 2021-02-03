package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
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

public class MainActivity4 extends AppCompatActivity {

    private ListView listView; //With class

    public static String EXTRA_TEXT_TITLE = "com.example.startup.EXTRA_TEXT_TITLE";
    public static String EXTRA_TEXT_DESC = "com.example.startup.EXTRA_TEXT_DESC";
    public static String EXTRA_IMAGE = "com.example.startup.EXTRA_IMAGEESC";

    Item item1 = new Item("Boats", R.drawable.plane, "Description of item 1");
    Item item2 = new Item("Planes", R.drawable.plane, "Description of item 2");
    Item item3 = new Item("Transport", R.drawable.plane, "Description of item 3");
    Item item4 = new Item("Trains", R.drawable.plane, "Description of item 4");
    Item item5 = new Item("Containers", R.drawable.plane, "Description of item 5");
    Item item6 = new Item("Constructions", R.drawable.plane, "Description of item 6");
    Item item7 = new Item("Restaurants", R.drawable.plane, "Description of item 7");
    Item item8 = new Item("Vans", R.drawable.plane, "Description of item 8");
    ArrayList<Item> items = new ArrayList<>();


    CustomAdapter customAdapter = new CustomAdapter(this, items);


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose an option: ");
        menu.add(0, 1, 1, "Details");
        menu.add(0, 2, 2, "Share");
        menu.add(0, 3, 3, "Web");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Details " + item + " " + item.getItemId() + " " + info.position, Toast.LENGTH_SHORT).show();
                displayInfo(info.position);
                return true;
            case 2:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Web", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void displayInfo(int position) {

        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
        i.putExtra(EXTRA_TEXT_TITLE,items.get(position).getItemName());
        i.putExtra(EXTRA_TEXT_DESC,items.get(position).getItemDesc());
        i.putExtra(EXTRA_IMAGE, items.get(position).getImageName());
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //hook
        listView = findViewById(R.id.listView);

        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);


    }

    private class CustomAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Item> items;

        public CustomAdapter(Context context, ArrayList<Item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Inflar menú row
            View view = getLayoutInflater().inflate(R.layout.row_data2, null);

            //Declarar las variables
            TextView textRow = view.findViewById(R.id.textRow);
            ImageView imageRow = view.findViewById(R.id.imageRow);

            //Setters
            textRow.setText(items.get(position).getItemName());
            imageRow.setImageResource(items.get(position).getImageName());

            return view;
        }
    }
}