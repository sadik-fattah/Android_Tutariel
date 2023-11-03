package com.guercifzone.ui_controls_android.Bars;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Progressbars_widgets extends AppCompatActivity {
Button  button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbars_widgets);
       // requestWindowFeature(Window.FEATURE_PROGRESS);

        setProgressBarVisibility(true);
        ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progress_widget);
        setProgress(progressHorizontal.getProgress() * 100);
        setSecondaryProgress(progressHorizontal.getSecondaryProgress() * 100);

        button1 = (Button) findViewById(R.id.increase);
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementProgressBy(1);
                // Title progress is in range 0..10000
                setProgress(100 * progressHorizontal.getProgress());
            }
        });

        button2 = (Button) findViewById(R.id.decrease);
        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementProgressBy(-1);
                // Title progress is in range 0..10000
                setProgress(100 * progressHorizontal.getProgress());
            }
        });

        button3 = (Button) findViewById(R.id.increase_secondary);
        button3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementSecondaryProgressBy(1);
                // Title progress is in range 0..10000
                setSecondaryProgress(100 * progressHorizontal.getSecondaryProgress());
            }
        });

        button4 = (Button) findViewById(R.id.decrease_secondary);
        button4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementSecondaryProgressBy(-1);
                // Title progress is in range 0..10000
                setSecondaryProgress(100 * progressHorizontal.getSecondaryProgress());
            }
        });
    }
}