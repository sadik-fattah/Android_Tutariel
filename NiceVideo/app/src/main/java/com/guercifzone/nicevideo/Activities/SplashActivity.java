package com.guercifzone.nicevideo.Activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.nicevideo.R;

public class SplashActivity extends AppCompatActivity {
Button btnmovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnmovies =(Button)findViewById(R.id.btn_for_6);
       // btnmovies.setVisibility(View.GONE);
        btnmovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        new CountDownTimer(1000,10){
            @Override
            public void onTick(long millisUntilFinished) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFinish() {
               // btnmovies.setVisibility(View.VISIBLE);
            }
        }.start();
    }
}