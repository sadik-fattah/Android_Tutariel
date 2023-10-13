package com.guercifzone.adapters.Example.BaseAdapter.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.guercifzone.adapters.R;

public class Base_Adapter_ListView extends BaseAdapter {

    Context context;
    String countryList[];
    int flags[];
    LayoutInflater inflter;

    public Base_Adapter_ListView(Context applicationContext, String[] countryList, int[] flags) {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.length;
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
        convertView = inflter.inflate(R.layout.data_for_listview, null);
        TextView country = (TextView) convertView.findViewById(R.id.textView);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        country.setText(countryList[position]);
        icon.setImageResource(flags[position]);
        return convertView;
    }
}
