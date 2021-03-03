package com.example.recyclerviewclass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<String> mImagesUrl;

    public ImageAdapter(Context mContext, ArrayList<String> mImagesUrl) {
        this.mContext = mContext;
        this.mImagesUrl = mImagesUrl;
    }

    @Override
    public int getCount() {
        return mImagesUrl.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        /*ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mImagesUrl.get(position));*/

        PhotoView photoView = new PhotoView(mContext);
        photoView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Picasso.get().load(mImagesUrl.get(position))
                .fit()
                .centerCrop()
                .into(photoView);

        container.addView(photoView, 0);

        return photoView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((ImageView)object);
    }
}
