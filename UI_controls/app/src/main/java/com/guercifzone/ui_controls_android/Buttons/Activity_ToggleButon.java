package com.guercifzone.ui_controls_android.Buttons;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_ToggleButon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_buton);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
    if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED){
        toggle.setChecked(true);
    }else {
        toggle.setChecked(false);
    }
    toggle.setOnCheckedChangeListener(listener);
    }
    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int current = getResources().getConfiguration().orientation;
            if (isChecked){
              switch (current) {
                  case Configuration.ORIENTATION_LANDSCAPE:
                      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            break;
                  case Configuration.ORIENTATION_PORTRAIT:
                      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                      break;
                  default:
                      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
              }
            }else {
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            }
        }
    };
    }
