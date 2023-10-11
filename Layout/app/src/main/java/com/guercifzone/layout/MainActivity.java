package com.guercifzone.layout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.layout.tut.Activity_Absoloutlayout;
import com.guercifzone.layout.tut.Activity_LinearLayout;
import com.guercifzone.layout.tut.Activity_RelativeLayout;
import com.guercifzone.layout.tut.Activity_framelayout;

public class MainActivity extends AppCompatActivity {
Button btnLinearLayout,btnRelativeLayout,btnTableLayout,btnFrameLayout,btnAbsoloutlayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btnLinearLayout = (Button) findViewById(R.id.btnlinearlayout);
btnRelativeLayout = (Button) findViewById(R.id.relativelayout);
btnTableLayout = (Button) findViewById(R.id.tableLayout);
btnFrameLayout =(Button)findViewById(R.id.frameLayout) ;
btnAbsoloutlayout = (Button) findViewById(R.id.absoloutlayout);

btnAbsoloutlayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "frame layout",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Activity_Absoloutlayout.class));

    }
});
btnFrameLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "frame layout",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Activity_framelayout.class));

    }
});
btnTableLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "guercif zone",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Activity_RelativeLayout.class));
    }
});
btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, Activity_RelativeLayout.class));
    }
});
btnLinearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
startActivity(new Intent(MainActivity.this,Activity_LinearLayout.class));
    }
});

    }
}