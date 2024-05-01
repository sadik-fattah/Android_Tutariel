package com.guercifzone.winnmoney;



import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.winnmoney.Activies.Android_Activity;
import com.guercifzone.winnmoney.Activies.Home_Activity;
import com.guercifzone.winnmoney.Activies.Tutariel_Activity;
import com.guercifzone.winnmoney.Adapters.GridViewAdapter;

public class MainActivity extends AppCompatActivity {
GridView mygridView;
    int logos[] = {R.drawable.ic_baseline_house_24, R.drawable.algorithms_64, R.drawable.csharp,
            R.drawable.baseline_attractions_24, R.drawable.extention, R.drawable.gtk,
            R.drawable.ic_baseline_android_24, R.drawable.ic_baseline_computer_24, R.drawable.ic_baseline_web_24,
            R.drawable.java, R.drawable.programin, R.drawable.tutariel};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mygridView = (GridView) findViewById(R.id.simpleGridview);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getApplicationContext(),logos);
        mygridView.setAdapter(gridViewAdapter);
mygridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(MainActivity.this, Home_Activity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Tutariel_Activity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Android_Activity.class));
                break;
        }
    }
});
    }

}