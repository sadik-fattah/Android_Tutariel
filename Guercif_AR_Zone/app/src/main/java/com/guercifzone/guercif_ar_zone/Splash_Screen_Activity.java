package com.guercifzone.guercif_ar_zone;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread =new Thread(){
            public  void  run(){
                try {
                    sleep(3000);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(Splash_Screen_Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}