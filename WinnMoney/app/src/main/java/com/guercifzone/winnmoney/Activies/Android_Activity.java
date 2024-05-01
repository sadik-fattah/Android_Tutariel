package com.guercifzone.winnmoney.Activies;

import android.annotation.SuppressLint;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Android_Activity extends AppCompatActivity {
    private final String JSON_URL = "https://gist.githubusercontent.com/sadik-fattah/852b157ce576e5eed2f77ac4ff743c85/raw/6abb4631cdcb68c90b3659d458bc27c68c3c44bf/Android";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Feed> lsArzone;
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
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
        requestQueue = Volley.newRequestQueue(Android_Activity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Feed> lsArzone) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lsArzone);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}