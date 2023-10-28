package com.guercifzone.ui_controls_android.Buttons;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

import static android.widget.GridLayout.HORIZONTAL;
import static android.widget.GridLayout.LEFT;

public class Activity_RadioButon_switchcase extends AppCompatActivity implements RadioButton.OnCheckedChangeListener {
    RadioButton hbtn, vbtn;
    RadioGroup radioGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buton_switchcase);
        hbtn = (RadioButton) findViewById(R.id.horizontal);
        vbtn = (RadioButton) findViewById(R.id.vertical);
        radioGroup = (RadioGroup) findViewById(R.id.radio2);
        vbtn.setOnCheckedChangeListener(this);
        hbtn.setOnCheckedChangeListener(this);
    }

    @SuppressLint("NonConstantResourceId")

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (hbtn.isChecked() == true) {

            radioGroup.setOrientation(LinearLayout.HORIZONTAL);

        } else if (vbtn.isChecked() == true) {

            radioGroup.setOrientation(LinearLayout.VERTICAL);
        }
    }
}
