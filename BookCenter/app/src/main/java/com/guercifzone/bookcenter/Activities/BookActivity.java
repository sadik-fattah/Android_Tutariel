package com.guercifzone.bookcenter.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.guercifzone.bookcenter.Adapters.RecyclerViewAdapter;
import com.guercifzone.bookcenter.Classes.GoogleMobileAdsConsentManager;
import com.guercifzone.bookcenter.MainActivity;
import com.guercifzone.bookcenter.Models.Books;
import com.guercifzone.bookcenter.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.guercifzone.bookcenter.R.id.*;

public class BookActivity extends AppCompatActivity {
    public static final String TEST_DEVICE_HASHED_ID = "ABCDEF012345";
    private static final String AD_UNIT_ID = "ca-app-pub-6657811059645259/7257912297";
    private static final String TAG = "MyActivity";
    private final AtomicBoolean isMobileAdsInitializeCalled = new AtomicBoolean(false);
    private GoogleMobileAdsConsentManager googleMobileAdsConsentManager;
    private AdView adView;
    private FrameLayout adContainerView;
    private final AtomicBoolean initialLayoutComplete = new AtomicBoolean(false);

    private final String JSON_URL ="https://raw.githubusercontent.com/sadik-fattah/SimpleDataBase/main/BooksSitmap.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Books> lsArzone;
    RecyclerView recyclerView;
    RecyclerViewAdapter myadapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        lsArzone = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewtools);
        searchView = (SearchView)findViewById(R.id.searchview);
        searchView.clearFocus();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_search);
        bottomNavigationView.setSelectedItemId(bottom_home);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
        addmob();
        Jsonrequest();
        editableSearch();
    }

    private void editableSearch() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });
    }
    private void filterList(String text){
        List<Books> filteredList = new ArrayList<>();
        for (Books item : lsArzone){
            if (item.getBook_name().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            } else if (item.getBook_type().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }

        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "لا يوجد في  قائمة الكتب", Toast.LENGTH_SHORT).show();
        }else {
            myadapter.setFilteredList(filteredList);
        }
    }
    private void Jsonrequest() {
        request = new JsonArrayRequest(JSON_URL.toString().trim(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responce) {
                JSONObject jsonObject = null;
                for (int i = 0;i< responce.length();i++){
                    try {
                        jsonObject = responce.getJSONObject(i);
                        Books arzone = new Books();
                        arzone.setBook_image(jsonObject.getString("books_image"));
                        arzone.setBook_type(jsonObject.getString("books_type"));
                        arzone.setBook_name(jsonObject.getString("Books_name").replace("_"," ").replace("tutorial"," "));
                        arzone.setBook_link(jsonObject.getString("Books_link").substring(0,20)+"...");
                        lsArzone.add(arzone);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(lsArzone);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });
        requestQueue = Volley.newRequestQueue(BookActivity.this);
        requestQueue.add(request);
    }
    private void setuprecyclerview(List<Books> lsArzone) {
        myadapter = new RecyclerViewAdapter(this,lsArzone);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(myadapter);
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
    public void addmob() {
        adContainerView = findViewById(ad_view_container_serch);
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
}