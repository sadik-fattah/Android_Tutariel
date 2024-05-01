package com.guercifzone.linkly;

import android.app.Activity;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] url;
    private final String[] email;
    private final String[] phonenumber;
    private final Integer[] imgid;

    public MyListAdapter(Activity context, String[] url, String[] email, String[] phonenumber, Integer[] imgid) {
        super(context, R.layout.activity_my_list, url);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.url=url;
        this.email=email;
        this.phonenumber=phonenumber;
        this.imgid=imgid;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_my_list, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.url);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.email);
        TextView phonenumberText = (TextView) rowView.findViewById(R.id.phonenumber);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        imageView.setImageResource(imgid[position]);

        titleText.setText(url[position]);
        subtitleText.setText(email[position]);
        phonenumberText.setText(phonenumber[position]);
        Linkify.addLinks(phonenumberText,Linkify.PHONE_NUMBERS);

        return rowView;
    };

}