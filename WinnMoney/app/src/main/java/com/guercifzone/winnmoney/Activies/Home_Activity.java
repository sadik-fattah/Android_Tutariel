package com.guercifzone.winnmoney.Activies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.guercifzone.winnmoney.Adapters.RecyclerViewAdapter;
import com.guercifzone.winnmoney.Models.Feed;
import com.guercifzone.winnmoney.R;
import com.squareup.picasso.Downloader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home_Activity extends AppCompatActivity {
    private final String JSON_URL = "https://gist.githubusercontent.com/sadik-fattah/6f63569c340f426bd410ab433fae81be/raw/2946f86ed9b89a63d9f59e1f7cdf8d44dedc5e2e/home";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Feed> lsArzone;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lsArzone = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewtools);

        Jsonrequest();
    }

    private void Jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responce) {
                JSONObject jsonObject = null;
                for (int i = 0;i< responce.length();i++){
                    try {
                        jsonObject = responce.getJSONObject(i);
                        Feed arzone = new Feed();
                        arzone.setTitle(jsonObject.getString("title"));
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
        requestQueue = Volley.newRequestQueue(Home_Activity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Feed> lsArzone) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lsArzone);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}