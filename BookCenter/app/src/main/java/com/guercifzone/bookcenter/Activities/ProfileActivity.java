package com.guercifzone.bookcenter.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.guercifzone.bookcenter.Classes.GoogleMobileAdsConsentManager;
import com.guercifzone.bookcenter.MainActivity;
import com.guercifzone.bookcenter.R;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.guercifzone.bookcenter.R.id.*;

public class ProfileActivity extends AppCompatActivity {
ImageButton whatsap,twolancer,nsayblik;
    @SuppressLint("MissingInflatedId")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_profil);
        bottomNavigationView.setSelectedItemId(bottom_home);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);

    }

    @SuppressLint("NonConstantResourceId")
    private boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.bottom_home) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        } else if (id == R.id.bottom_search) {
            startActivity(new Intent(getApplicationContext(), BookActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        } else if (id == R.id.bottom_settings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        } else if (id == R.id.bottom_profile) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}