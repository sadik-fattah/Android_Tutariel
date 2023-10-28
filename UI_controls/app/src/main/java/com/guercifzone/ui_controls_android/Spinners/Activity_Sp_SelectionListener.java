package com.guercifzone.ui_controls_android.Spinners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Sp_SelectionListener extends AppCompatActivity {
String [] presidents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_selection_listener);
presidents = getResources().getStringArray(R.array.presidents_array);
Spinner s1  = (Spinner) findViewById(R.id.spinner1);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,presidents);
 s1.setAdapter(adapter);
 s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
     @Override
     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         int  index  = parent.getSelectedItemPosition();
         Toast.makeText(getBaseContext(),"لقد  اخترت العنصر التالي "+presidents[index],Toast.LENGTH_SHORT).show();
     }

     @Override
     public void onNothingSelected(AdapterView<?> parent) {

     }
 });
    }
}