package com.guercifzone.nyaa;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.guercifzone.nyaa.Adapters.Nyaa_RecyclerViewAdapter;
import com.guercifzone.nyaa.Models.Nyaa_Root;
import com.guercifzone.nyaa.Stuff.HttpDataHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private final String JSON_URL = "https://gist.githubusercontent.com/sadik-fattah/852b157ce576e5eed2f77ac4ff743c85/raw/6abb4631cdcb68c90b3659d458bc27c68c3c44bf/Android";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Nyaa_Root> nyaaRoots;
    RecyclerView recyclerView;
    private final String RSS_link= "https://nyaa.land/?page=rss";
    private final String RSS_toJson_ApI = " https://api.rss2json.com/v1/api.json?rss_url=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nyaaRoots = new ArrayList<>();
        toolbar.setTitle("Nyaa");
        try {
            setSupportActionBar(toolbar);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Nyaa_RecyclerViewAdapter nyaaRecyclerViewAdapter = new Nyaa_RecyclerViewAdapter(this,nyaaRoots);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadRss();
    }
    private void loadRss() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responce) {
                JSONObject jsonObject = null;
                for (int i = 0;i< responce.length();i++){
                    try {
                        jsonObject = responce.getJSONObject(i);
                        Nyaa_Root arzone = new Nyaa_Root();
                        arzone.setItems(jsonObject.getString("title"));
                        arzone.setAuthor(jsonObject.getString("author"));
                        arzone.setDescription(jsonObject.getString("description"));
                        arzone.setImage(jsonObject.getString("thumbnail"));
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
        requestQueue = Volley.newRequestQueue(Android_Activity.this);
        requestQueue.add(request);

        StringBuilder url_get_data = new StringBuilder(RSS_toJson_ApI);
        url_get_data.append(RSS_link);
        loadRssAsync.execute(url_get_data.toString());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh)
            loadRss();

        return false;
    }
}
