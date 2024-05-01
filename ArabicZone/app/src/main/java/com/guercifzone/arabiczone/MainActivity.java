package com.guercifzone.arabiczone;


import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.guercifzone.arabiczone.RSS.Downloader;


public class MainActivity extends AppCompatActivity {
    final static String urlAddress="https://rss.nytimes.com/services/xml/rss/nyt/World.xml";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       try {
           setSupportActionBar(toolbar);
       }catch (Exception e){
           e.printStackTrace();
       }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final RecyclerView rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new Downloader(MainActivity.this,urlAddress,rv).execute();
                }catch (Exception r){
                    r.printStackTrace();
                }
            }
        });
    }
}