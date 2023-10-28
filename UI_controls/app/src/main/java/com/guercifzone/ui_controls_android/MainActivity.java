package com.guercifzone.ui_controls_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.Buttons.*;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_FillData_ArrayAdapter;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_SelectionListener;
import com.guercifzone.ui_controls_android.TextViews.Activity_Autocomplete;

public class MainActivity extends AppCompatActivity {
Button txt1,sp3,sp4;
Button btn1,btn2,btn3,btn4,btn5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sp3 = (Button) findViewById(R.id.spnner3);
        //sp4 = (Button) findViewById(R.id.spnner4);
       // txt1 = (Button)findViewById(R.id.txtview1) ;
btn1 =(Button)findViewById(R.id.example1) ;
btn2 = (Button)findViewById(R.id.example2);
btn3 = (Button)findViewById(R.id.example3);
btn4 = (Button)findViewById(R.id.example4);
btn5 = (Button)findViewById(R.id.example5);
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, Activity_RadioButton.class));
    }
});
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, Activity_ToggleButon.class));
    }
});
btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, Activity_RadioButon_switchcase.class));
    }
});
btn4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, Activity_RadioButton_getdata.class));
    }
});
btn5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, Activity_ImageButton.class));
    }
});
/*     sp3.setOnClickListener(new View.OnClickListener() {
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
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity_Autocomplete.class));
            }
        });*/
    }

}