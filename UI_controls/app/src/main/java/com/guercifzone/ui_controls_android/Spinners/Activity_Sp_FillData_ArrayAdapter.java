package com.guercifzone.ui_controls_android.Spinners;

import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Sp_FillData_ArrayAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_fill_data_array_adapter);
final Spinner spinner = (Spinner) findViewById(R.id.testSpinner);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
        Months);
  adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
spinner.setAdapter(adapter);

final Button changeButton1 = (Button) findViewById(R.id.enableButton);
changeButton1.setOnClickListener(new Button.OnClickListener(){
    @Override
    public void onClick(View v) {
        changeOption1(spinner);
    }
});
final Button changeButton2 = (Button) findViewById(R.id.backgroundColorButton);
changeButton2.setOnClickListener(new Button.OnClickListener(){
    @Override
    public void onClick(View v) {
        changeOption2(spinner);
    }
});


    }

    static final String[] Months = new String[] { "محرم", "صفر",
            "ربيع الاول", "ربيع الثاني", "جمادى الاولى", "جمادى الثانية", "رجب", "شعبان", "رمضان",
            "شوال", "ذوالقعدة", "ذوالحجة" };

    public void changeOption1(Spinner spinner){
        if (spinner.isEnabled()){
            spinner.setEnabled(false);

        }else {
            spinner.setEnabled(true);
        }
    }
    public void changeOption2(Spinner spinner){
        spinner.setBackgroundColor(Color.RED);
    }
}