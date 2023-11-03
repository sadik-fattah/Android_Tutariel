package com.guercifzone.ui_controls_android.Bars;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_progressbar_Indeterminate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_indeterminate);
        ProgressBar bar = (ProgressBar)findViewById(R.id.progress_spinner) ;
   Button btn = (Button) findViewById(R.id.toggle);
   btn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
          bar.setVisibility(View.VISIBLE);
       }
   });
    }


}