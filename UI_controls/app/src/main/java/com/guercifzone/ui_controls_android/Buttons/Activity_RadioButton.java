package com.guercifzone.ui_controls_android.Buttons;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_RadioButton extends AppCompatActivity implements  View.OnClickListener {
    RadioButton khalid, omar, salah, tarik, kods;
    String selectedSuperStar;
    Button submit,clear;
    private RadioGroup  radioGroup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        clear = (Button) findViewById(R.id.clearbtn);
        radioGroup = (RadioGroup) findViewById(R.id.mygroup);
        khalid = (RadioButton) findViewById(R.id.khalid);
        omar = (RadioButton) findViewById(R.id.omar);
        salah = (RadioButton) findViewById(R.id.salah);
        tarik = (RadioButton) findViewById(R.id.tarik);
        kods = (RadioButton) findViewById(R.id.palistain);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (khalid.isChecked()){
                    selectedSuperStar = khalid.getText().toString();
                } else if (omar.isChecked()) {
                    selectedSuperStar = omar.getText().toString();
                } else if (salah.isChecked()) {
                    selectedSuperStar = salah.getText().toString();
                } else if (kods.isChecked() ){
                    selectedSuperStar = kods.getText().toString();
                } else if (tarik.isChecked()) {
                    selectedSuperStar = tarik.getText().toString();
                }
                Toast.makeText(getApplicationContext(),
                        selectedSuperStar,
                        Toast.LENGTH_LONG).show();
            }
        });
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
radioGroup.clearCheck();
    }
}