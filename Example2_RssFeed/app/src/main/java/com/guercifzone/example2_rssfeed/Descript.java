package com.guercifzone.example2_rssfeed;

import android.os.Build;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Descript extends AppCompatActivity {
 TextView title;
 TextView summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descript);
        title= (TextView) findViewById(R.id.header);
        summary=(TextView) findViewById(R.id.summary);

        Bundle getdata = getIntent().getExtras();
        String header = getdata.getString("head");
        String dec = getdata.getString("sum");

        title.setText(header);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            summary.setText(Html.fromHtml(dec,Html.FROM_HTML_MODE_LEGACY));
        }else {
            summary.setText(Html.fromHtml(dec));
        }
        summary.setMovementMethod(new ScrollingMovementMethod());
    }
}