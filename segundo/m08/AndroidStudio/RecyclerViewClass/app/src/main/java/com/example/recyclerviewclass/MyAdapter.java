package com.example.recyclerviewclass;

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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Picture> mPictures;
    private Context mContext;

    public MyAdapter(ArrayList<Picture> mPictures, Context mContext) {
        this.mPictures = mPictures;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load(mPictures.get(position).getUrlImage())
                .fit()
                .centerCrop()
                .into(holder.imageView);

        holder.text.setText(mPictures.get(position).getText());

        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("title", mPictures.get(position).getText());
                intent.putExtra("desc", mPictures.get(position).getDesc());
                intent.putExtra("urlImage", mPictures.get(position).getUrlImage());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mPictures.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView text;

        ConstraintLayout rowLayout;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //hook
            imageView = itemView.findViewById(R.id.imageView);
            text = itemView.findViewById(R.id.text);
            rowLayout = itemView.findViewById(R.id.rowLayout);
        }
    }
}
