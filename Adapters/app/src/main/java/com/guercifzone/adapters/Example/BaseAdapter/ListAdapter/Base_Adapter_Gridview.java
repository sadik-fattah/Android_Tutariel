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
    LayoutInflater inflter;
    public Base_Adapter_Gridview(Context applicationContext, int[] flags) {
        this.context = applicationContext;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.data_for_gridview, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(flags[i]);
        return view;
    }
}
