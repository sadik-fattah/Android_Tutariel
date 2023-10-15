package com.guercifzone.adapters.Example.BaseAdapter.ListAdapter;

import android.widget.GridView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.adapters.Example.BaseAdapter.ListAdapter.Base_Adapter_ListView;
import com.guercifzone.adapters.R;

public class Activity_ListView extends AppCompatActivity {
ListView simpleList;
String countryList[]={"فلسطين","المغرب","الجزائر","ليبيا","تونس","موريطانيا"};
int  flags[]={R.drawable.palistain,R.drawable.morocco,R.drawable.algeria,R.drawable.libya,R.drawable.tunisia,R.drawable.moritania,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        Base_Adapter_ListView baseAdapterListView = new Base_Adapter_ListView(getApplicationContext(),countryList,flags);
        simpleList.setAdapter(baseAdapterListView);
    }
}