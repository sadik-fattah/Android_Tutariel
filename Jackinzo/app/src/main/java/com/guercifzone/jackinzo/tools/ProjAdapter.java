package com.guercifzone.jackinzo.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.jackinzo.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.BitSet;

public class ProjAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList <RecModel> recModelArrayList;

    public ProjAdapter(Context context, int layout, ArrayList<RecModel> recModelArrayList) {
        this.context = context;
        this.layout = layout;
        this.recModelArrayList = recModelArrayList;
    }
    @Override
    public int getCount() {
        return recModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return recModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    private class RecViewHolder{
        ImageView imageView;
        TextView txtName;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecViewHolder holder = new RecViewHolder();
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
             holder.txtName = (TextView) row.findViewById(R.id.txtName);
             holder.imageView =(ImageView) row.findViewById(R.id.imgrec);
             row.setTag(holder);
        }else {
            holder = (RecViewHolder) row.getTag();
        }
        RecModel recModel = recModelArrayList.get(position);
        holder.txtName.setText(recModel.getName());
        byte[] recImage = recModel.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recImage,0,recImage.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }
}
