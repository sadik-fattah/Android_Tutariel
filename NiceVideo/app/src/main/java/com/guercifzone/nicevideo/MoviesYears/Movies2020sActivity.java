package com.guercifzone.nicevideo.MoviesYears;

import android.annotation.SuppressLint;
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
import com.guercifzone.nicevideo.Adapters.RecyclerViewAdapter;
import com.guercifzone.nicevideo.Models.Video;
import com.guercifzone.nicevideo.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movies2020sActivity extends AppCompatActivity {
    private final String JSON_URL ="https://raw.githubusercontent.com/sadik-fattah/SimpleDataBase/main/movies2020s.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Video> lsArzone;
    RecyclerView recyclerView;
    RecyclerViewAdapter myadapter;
    SearchView searchView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        lsArzone = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        searchView = (SearchView)findViewById(R.id.searchview);
        searchView.clearFocus();
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
                return true;
            }
        });
    }
    private void filterList(String text){
        List<Video> filteredList = new ArrayList<>();
        for (Video item : lsArzone){
            if (item.getMovieName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            } else if (item.getMovieType().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }

        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "لا يوجد في  قائمة الافلام", Toast.LENGTH_SHORT).show();
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
                        Video arzone = new Video();
                        arzone.setMovieLink(jsonObject.getString("movies_link"));
                        arzone.setMovieType(jsonObject.getString("movies_type"));
                        arzone.setMovieName(jsonObject.getString("movies_name").replace("_"," "));
                        arzone.setMoviedescription(jsonObject.getString("movies_description"));
                        arzone.setMovieImage(jsonObject.getString("thumbnail"));
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
        requestQueue = Volley.newRequestQueue(Movies2020sActivity.this);
        requestQueue.add(request);
    }
    private void setuprecyclerview(List<Video> lsArzone) {
        myadapter = new RecyclerViewAdapter(this,lsArzone);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(myadapter);
    }
}