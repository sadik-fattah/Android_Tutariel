package com.guercifzone.jackinzo;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.jackinzo.tools.ProjAdapter;
import com.guercifzone.jackinzo.tools.RecModel;
import com.guercifzone.jackinzo.tools.SqliteHelper;

import java.util.ArrayList;
import java.util.Currency;



public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<String> recArrayList;
ProjAdapter adapter = null;
SqliteHelper sqliteHelper;
    ImageView empty_imageview;
    TextView no_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recArrayList = new ArrayList<>();
        recyclerView.setAdapter(adapter);
        StoreDataINArray();
        recArrayList.clear();
        adapter.notifyDataSetChanged();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void StoreDataINArray() {
        try {
            Cursor cursor = sqliteHelper.ReadRecordData();
            if (cursor.getCount() == 0){
           empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
            }else {
                while (cursor.moveToNext()){
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String email = cursor.getString(2);
                    String type = cursor.getString(3);
                    String address = cursor.getString(4);
                    String assurance = cursor.getString(5);
                    String date_sing = cursor.getString(6);
                    String date_burn = cursor.getString(7);
                    byte[] image = cursor.getBlob(8);
                    recArrayList.add(new RecModel(id,name,email,type,address,assurance,date_sing,date_burn,image));

                }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
            }
        }catch (SQLiteException e){
            e.fillInStackTrace();
        }

    }
}