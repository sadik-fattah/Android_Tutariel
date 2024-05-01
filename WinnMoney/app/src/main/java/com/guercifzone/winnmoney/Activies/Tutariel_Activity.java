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

public class Tutariel_Activity extends AppCompatActivity {

       private final String JSON_URL = "https://gist.githubusercontent.com/sadik-fattah/342f3bc2b7fd4d593eaeeee43b039cf9/raw/2a9931da3c393832aa4e8c4a1ae63523519d1a11/tutariel";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Feed> lsArzone;
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutariel);
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
        requestQueue = Volley.newRequestQueue(Tutariel_Activity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Feed> lsArzone) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lsArzone);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}