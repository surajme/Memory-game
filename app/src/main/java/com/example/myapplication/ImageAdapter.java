package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    public ImageAdapter(Context context) {
        this.context = context;

    }
    @Override
    public int getCount() {
        return 12 ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        //If convertview is null atm.
        if (convertView == null ) {
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType( ImageView.ScaleType.FIT_XY);

        } else  imageView = (ImageView)convertView;
             imageView.setImageResource( R.drawable.multimedia);

        return imageView;
    }
}
