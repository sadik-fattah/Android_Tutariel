package com.guercifzone.adapter_model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import pl.droidsonroids.gif.GifImageView;

import java.util.List;

public class AdapterLetter extends ArrayAdapter<Data> {
    public AdapterLetter(@NonNull Context context,  @NonNull List<Data> data) {
        super(context, 0, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView  = convertView;
        if(listItemView ==null)
            listItemView  = LayoutInflater.from(getContext()).inflate(R.layout.data_for_main,parent,false);

        Data mydata = getItem(position);
        GifImageView consonne = listItemView.findViewById(R.id.letter_conson_gif);
        GifImageView voyelle = listItemView.findViewById(R.id.letter_voyel_gif);
        TextView name = listItemView.findViewById(R.id.letter_base);
        consonne.setImageResource(mydata.getLetter_consonne_ID());
        voyelle.setImageResource(mydata.getLetter_voyelle_ID());
        name.setText(mydata.getName());
        return listItemView;
    }
}
