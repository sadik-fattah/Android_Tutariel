package com.guercifzone.ui_controls_android.Bars;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Progressbar extends AppCompatActivity {
ProgressBar pbr1,pbr2,pbr3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
     pbr1= (ProgressBar) findViewById(R.id.pb1);
     pbr2 = (ProgressBar)findViewById(R.id.pb2);
     pbr3= (ProgressBar)findViewById(R.id.pb3);
        Button startButton = (Button) findViewById(R.id.startButton);
        // perform click event on button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pbr1.setVisibility(View.VISIBLE);
                pbr2.setVisibility(View.VISIBLE);
                pbr3.setVisibility(View.VISIBLE);
            }
        });
    }
}