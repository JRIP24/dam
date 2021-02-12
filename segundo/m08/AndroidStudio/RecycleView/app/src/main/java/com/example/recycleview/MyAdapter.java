package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String title[];
    private String desc[];
    private int images[];
    private Context context;

    public MyAdapter(String[] title, String[] desc, int[] images, Context context) {
        this.title = title;
        this.desc = desc;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflate Layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Setters

        holder.myTextTitleRow.setText(title[position]);
        holder.myTextDescRow.setText(desc[position]);
        holder.myImageRow.setImageResource(images[position]);

        holder.layoutRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", title[position]);
                intent.putExtra("desc", desc[position]);
                intent.putExtra("images", images[position]);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //Hooks

        TextView myTextTitleRow;
        TextView myTextDescRow;
        ImageView myImageRow;

        //Part 2
        ConstraintLayout layoutRow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myTextTitleRow = itemView.findViewById(R.id.textTitleRow);
            myTextDescRow = itemView.findViewById(R.id.textDescRow);
            myImageRow = itemView.findViewById(R.id.imageRow);

            //part2
            layoutRow = itemView.findViewById(R.id.layoutRow);
        }
    }
}
