package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityListActionContext extends AppCompatActivity {

    private ListView listView;
    ArrayList<String> cursos = new ArrayList<>();
    ArrayAdapter<String> dataAdapter;

    private ActionMode mActionMode;
    CustomAdapterMulti customAdapterMulti;
    private int selectedPosition;
    boolean isActiveActionMode = false;
    ArrayList<String> userSelection = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_action_context);

        listView = (ListView) findViewById(R.id.listView);
        cursos.add("1JSIM");
        cursos.add("2JSIM");
        cursos.add("1HISX");
        cursos.add("2HISX");
        cursos.add("1HISM");
        cursos.add("2HISM");
        cursos.add("1HIAW");
        cursos.add("2HIAW");
        cursos.add("1JISM");
        cursos.add("2JISM");

/*
        dataAdapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                cursos);
        listView.setAdapter(dataAdapter);*/

        customAdapterMulti = new CustomAdapterMulti(this, cursos);
        listView.setAdapter(customAdapterMulti);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {


                if (mActionMode != null) {
                    return false;
                }

                MenuInflater menuInflater = mode.getMenuInflater();
                menuInflater.inflate(R.menu.my_menu, menu);
                mode.setTitle("Choose your option");
                isActiveActionMode = true;
                return true;
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.item1:
                        //delete

                        customAdapterMulti.remove(userSelection);
                        //Toast.makeText(MainActivityListActionContext.this, "Delete " + item + " " + item.getItemId() + " " + selectedPosition, Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;

                    case R.id.item2:
                        Toast.makeText(MainActivityListActionContext.this, "Share " + item + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {
                mActionMode = null;
                isActiveActionMode = false;
                userSelection.clear();
            }
        });


/*
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivityListActionContext.this, "Item: " + position, Toast.LENGTH_SHORT).show();

                if (mActionMode != null) {
                    return false;
                }

                selectedPosition = position;
                mActionMode = startSupportActionMode(mActionModeCallBack);

                return true;
            }
        });*/

    }
/*
    private ActionMode.Callback mActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.my_menu, menu);
            mode.setTitle("Choose your option");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item1:

                    //delete
                    //dataAdapter.remove(dataAdapter.getItem(selectedPosition));
                    dataAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivityListActionContext.this, "Delete " + item + " " + item.getItemId()
                            + " " + selectedPosition, Toast.LENGTH_SHORT).show();
                    //mode.finish();
                    //item.setVisible(false);
                    return true;
                case R.id.item2:
                    Toast.makeText(MainActivityListActionContext.this, "Share " + item + " " + item.getItemId(),
                            Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

            mActionMode = null;

        }
    };*/


    private class CustomAdapterMulti extends BaseAdapter {

        private Context context; //context
        private ArrayList<String> cursos; //data source of the list adapter

        public CustomAdapterMulti(Context context, ArrayList<String> cursos) {
            this.context = context;
            this.cursos = cursos;
        }

        @Override
        public int getCount() {
            return cursos.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_data_multi, null);
            TextView textRow = view.findViewById(R.id.textRow);
            CheckBox checkBox = view.findViewById(R.id.checkBox);
            checkBox.setTag(position);
            //textRow.setText(items.get(position).getItemName());
            textRow.setText(cursos.get(position));


            if (isActiveActionMode) {
                checkBox.setVisibility(View.VISIBLE);
            }

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int position = (int) buttonView.getTag();
                    if (userSelection.contains(cursos.get(position))){
                        userSelection.remove(cursos.get(position));
                    } else {
                        userSelection.add(cursos.get(position));
                    }
                }
            });

            return view;
        }

        public void remove(ArrayList<String> items) {

            for (String item : items){
                cursos.remove(item);
            }

            notifyDataSetChanged();


        }
    }

}