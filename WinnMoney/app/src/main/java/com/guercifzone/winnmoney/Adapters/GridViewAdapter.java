package com.guercifzone.winnmoney.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.guercifzone.winnmoney.R;

public class GridViewAdapter extends BaseAdapter {
    Context context;
    int logos[];
    LayoutInflater inflater;

    public GridViewAdapter(Context context, int[] logos) {
        this.context = context.getApplicationContext();
        this.logos = logos;
        inflater = (LayoutInflater.from(context.getApplicationContext())) ;
    }

    @Override
    public int getCount() {
        return logos.length;
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
        convertView = inflater.inflate(R.layout.gridview_resource_list,null);
        ImageView icon = (ImageView) convertView.findViewById(R.id.selectedImage);
        icon.setImageResource(logos[position]);
        return convertView;
    }
}
