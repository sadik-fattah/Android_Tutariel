package com.guercifzone.adapters.Example.BaseAdapter.ListAdapter;

import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.adapters.Example.BaseAdapter.ListAdapter.Base_Adapter_Gridview;
import com.guercifzone.adapters.R;

public class Activity_Gridview extends AppCompatActivity {
GridView sipleGrid;
int  flags[]={R.drawable.palistain,R.drawable.moritania,R.drawable.morocco,R.drawable.algeria,R.drawable.tunisia,R.drawable.libya,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        sipleGrid = (GridView) findViewById(R.id.simpleGridView);
        Base_Adapter_Gridview baseAdapterGridview = new Base_Adapter_Gridview(getApplicationContext(),flags);
        sipleGrid.setAdapter(baseAdapterGridview);
    }
}