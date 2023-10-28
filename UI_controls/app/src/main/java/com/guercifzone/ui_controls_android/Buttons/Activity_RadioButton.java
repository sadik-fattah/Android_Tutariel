package com.guercifzone.ui_controls_android.Buttons;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_RadioButton extends AppCompatActivity implements View.OnClickListener   {
    RadioButton johnCena, randyOrton, goldBerg, romanReigns, sheamus;
    String selectedSuperStar;
    Button submit,clear;
    private RadioGroup  radioGroup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        clear =(Button)findViewById(R.id.clearbtn);
        radioGroup= (RadioGroup)findViewById(R.id.mygroup);
        johnCena = (RadioButton) findViewById(R.id.johnCena);
        randyOrton = (RadioButton) findViewById(R.id.randyOrton);
        goldBerg = (RadioButton) findViewById(R.id.goldBerg);
        romanReigns = (RadioButton) findViewById(R.id.romanReigns);
        sheamus = (RadioButton) findViewById(R.id.sheamus);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randyOrton.isChecked()) {
                    selectedSuperStar = randyOrton.getText().toString();
                } else if (sheamus.isChecked()) {
                    selectedSuperStar = sheamus.getText().toString();
                } else if (johnCena.isChecked()) {
                    selectedSuperStar = johnCena.getText().toString();
                } else if (romanReigns.isChecked()) {
                    selectedSuperStar = romanReigns.getText().toString();
                } else if (goldBerg.isChecked()) {
                    selectedSuperStar = goldBerg.getText().toString();
                }
                Toast.makeText(getApplicationContext(), selectedSuperStar, Toast.LENGTH_LONG).show(); // print the value of selected super star
            }
        });
        clear.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
radioGroup.clearCheck();
    }
}