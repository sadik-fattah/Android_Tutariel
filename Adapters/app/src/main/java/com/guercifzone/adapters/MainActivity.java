package com.guercifzone.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.adapters.ArrayAdapters.Activity_ArrayAdapter;
import com.guercifzone.adapters.Example.BaseAdapter.ListAdapter.Activity_Gridview;
import com.guercifzone.adapters.Example.BaseAdapter.ListAdapter.Activity_ListView;

public class MainActivity extends AppCompatActivity {
Button baseadAdapter_gridview,baseadAdapter_listview,thearrayadapter,
        cursorAdapter,curesorAdapterFilterable,
        nfcAdapter,nfcAdapterForeground,nfcAdapterAction;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
baseadAdapter_gridview = (Button) findViewById(R.id.base_adapter_gridview);
baseadAdapter_listview = (Button) findViewById(R.id.base_adapter_listview);
thearrayadapter = (Button)findViewById(R.id.arrayadapter);
baseadAdapter_gridview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Base Adapter activity gridview ",Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, Activity_Gridview.class));
    }
});
baseadAdapter_listview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Base Adapter activity listview ",Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, Activity_ListView.class));
    }
});
thearrayadapter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"array adapter ",Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, Activity_ArrayAdapter.class));
    }
});

    }

}