package com.guercifzone.adapters.Example.BaseAdapter.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.guercifzone.adapters.R;

public class Base_Adapter_Gridview  extends BaseAdapter {
Context context;
int flags[];
LayoutInflater inflater;
public Base_Adapter_Gridview(Context applicationContext,int[] flags){
    this.context = applicationContext;
    this.flags = flags;
    inflater = (LayoutInflater.from(applicationContext));
}

    @Override
    public int getCount() {
        return flags.length;
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
       convertView = inflater.inflate(R.layout.data_for_gridview,null);
       ImageView icon  = (ImageView) convertView.findViewById(R.id.icon);
       icon.setImageResource(flags[position]);
        return convertView;
    }
}
