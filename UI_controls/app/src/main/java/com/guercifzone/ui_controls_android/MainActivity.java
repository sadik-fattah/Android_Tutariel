package com.guercifzone.ui_controls_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_FillData_ArrayAdapter;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_SelectionListener;

public class MainActivity extends AppCompatActivity {
Button sp3,sp4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp3 = (Button) findViewById(R.id.spnner3);
        sp4 = (Button) findViewById(R.id.spnner4);

        sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Sp_FillData_ArrayAdapter.class));
            }
        });
        sp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Sp_SelectionListener.class));
            }
        });
    }

}