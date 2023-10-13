package com.guercifzone.adapters.Example.BaseAdapter.ListAdapter;

import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.adapters.Example.BaseAdapter.ListAdapter.Base_Adapter_Gridview;
import com.guercifzone.adapters.R;

public class Activity_Gridview extends AppCompatActivity {
    GridView simpleGrid;
    int flags [] = {R.drawable.palistain, R.drawable.morocco, R.drawable.libya, R.drawable.moritania, R.drawable.algeria, R.drawable.libya, R.drawable.tunisia,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        Base_Adapter_Gridview customAdapter = new Base_Adapter_Gridview(getApplicationContext(), flags);
        simpleGrid.setAdapter(customAdapter);
    }
}