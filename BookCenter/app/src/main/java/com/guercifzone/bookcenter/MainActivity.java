package com.guercifzone.bookcenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.gms.ads.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.guercifzone.bookcenter.Activities.BookActivity;
import com.guercifzone.bookcenter.Activities.ProfileActivity;
import com.guercifzone.bookcenter.Activities.SettingsActivity;
import com.guercifzone.bookcenter.Classes.GoogleMobileAdsConsentManager;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.guercifzone.bookcenter.R.id.*;


public class MainActivity extends AppCompatActivity {
    //
    public static final String TEST_DEVICE_HASHED_ID = "ABCDEF012345";
    private static final String AD_UNIT_ID = "ca-app-pub-6657811059645259/7257912297";
    private static final String TAG = "MyActivity";
    private final AtomicBoolean isMobileAdsInitializeCalled = new AtomicBoolean(false);
    private GoogleMobileAdsConsentManager googleMobileAdsConsentManager;
    private AdView adView;
    private FrameLayout adContainerView;
    private final AtomicBoolean initialLayoutComplete = new AtomicBoolean(false);
    CardView cardyoutube ,cardgithub,cardinstagram,cardwebsite,cardreddite,cardlinkedin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            cardyoutube = findViewById(R.id.youtube);
            cardgithub = findViewById(R.id.gitub);
            cardinstagram= findViewById(R.id.instagram);
            cardwebsite= findViewById(R.id.webview);
            cardreddite= findViewById(R.id.reddit);
            cardlinkedin= findViewById(R.id.linkedin);
        BottomNavigationView bottomNavigationView = findViewById(bottomNavigation_home);
        bottomNavigationView.setSelectedItemId(bottom_home);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
        addmob();
        gifsButton();
    }
    private void gifsButton() {

        cardyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://www.linkedin.com/in/sadik-fattah-a2034a29b/";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"AVADH TUTOR"));
            }
        });
        cardgithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://github.com/sadik-fattah?tab=repositories";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"AVADH TUTOR"));
            }
        });
        cardinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://www.instagram.com/jakinzo_developer/";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"AVADH TUTOR"));
            }
        });
        cardwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://guercifzone-ar.blogspot.com/";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"AVADH TUTOR"));
            }
        });
        cardreddite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://www.reddit.com/u/Jakinzo12/s/e1plvGAr0Q";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"AVADH TUTOR"));
            }
        });
        cardlinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://www.linkedin.com/in/sadik-fattah-a2034a29b/";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"AVADH TUTOR"));
            }
        });
    }
    public void addmob() {
        adContainerView = findViewById(ad_view_container_home);
        Log.d(TAG, "Google Mobile Ads SDK Version: " + MobileAds.getVersion());
        googleMobileAdsConsentManager = GoogleMobileAdsConsentManager.getInstance(getApplicationContext());
        googleMobileAdsConsentManager.gatherConsent(this, consentError -> {
            if (consentError != null) {
                // Consent not obtained in current session.
                Log.w(
                        TAG,
                        String.format("%s: %s", consentError.getErrorCode(), consentError.getMessage()));
            }

            if (googleMobileAdsConsentManager.canRequestAds()) {
                initializeMobileAdsSdk();
            }

            if (googleMobileAdsConsentManager.isPrivacyOptionsRequired()) {
                // Regenerate the options menu to include a privacy setting.
                invalidateOptionsMenu();
            }
        });
        if (googleMobileAdsConsentManager.canRequestAds()) {
            initializeMobileAdsSdk();
        }
        adContainerView
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(
                        () -> {
                            if (!initialLayoutComplete.getAndSet(true)
                                    && googleMobileAdsConsentManager.canRequestAds()) {
                                loadBanner();
                            }
                        });
    }
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }
    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
    private void loadBanner() {
        adView = new AdView(this);
        adView.setAdUnitId(AD_UNIT_ID);
        adView.setAdSize(getAdSize());
        adContainerView.removeAllViews();
        adContainerView.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
    private void initializeMobileAdsSdk() {
        if (isMobileAdsInitializeCalled.getAndSet(true)) {
            return;
        }
        MobileAds.setRequestConfiguration(
                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(TEST_DEVICE_HASHED_ID)).build());

        new Thread(
                () -> {
                    // Initialize the Google Mobile Ads SDK on a background thread.
                    MobileAds.initialize(this, initializationStatus -> {
                    });

                    // Load an ad on the main thread.
                    runOnUiThread(
                            () -> {
                                if (initialLayoutComplete.get()) {
                                    loadBanner();
                                }
                            });
                })
                .start();

    }
    public AdSize getAdSize() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int adWidthPixels = displayMetrics.widthPixels;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowMetrics windowMetrics = this.getWindowManager().getCurrentWindowMetrics();
            adWidthPixels = windowMetrics.getBounds().width();
        }
        float density = displayMetrics.density;
        int adWidth = (int) (adWidthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
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
