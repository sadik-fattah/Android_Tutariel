package com.guercifzone.adapters.ArrayAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.adapters.R;

import java.util.ArrayList;

public class Activity_ArrayAdapter extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;

    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        spinner = (Spinner) findViewById(R.id.simplespinner);
        spinner.setOnItemSelectedListener(this);
        arrayList = new ArrayList<>();
        arrayList.add("ithem1");
        arrayList.add("ithem2");
        arrayList.add("ithem3");
        arrayList.add("ithem4");
        arrayList.add("ithem5");
        adapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayList);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
Toast.makeText(getApplicationContext(),arrayList.get(position),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}