package com.guercifzone.example1_rssfeed;

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
import com.google.gson.Gson;
import com.guercifzone.example1_rssfeed.Adapters.FeedAdapter;
import com.guercifzone.example1_rssfeed.Common.HttpDataHandler;
import com.guercifzone.example1_rssfeed.Models.RSSObject;

public class MainActivity extends AppCompatActivity {
  Toolbar toolbar;
  RecyclerView recyclerView;
  RSSObject rssObject;
  private final String RSS_link= "https://guercifzone-ar.blogspot.com/feeds/posts/default?alt=rss";
  private final String RSS_toJson_ApI = " https://api.rss2json.com/v1/api.json?rss_url=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("News");
        try {
            setSupportActionBar(toolbar);
        }catch (Exception e){
            e.printStackTrace();
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
       loadRss();
    }
   private void loadRss() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<String,String,String>loadRssAsync = new AsyncTask<String, String, String>() {
         ProgressDialog mdialog = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {
        mdialog.setMessage("please wait .....");
        mdialog.show();

            }

            @Override
            protected String doInBackground(String... strings) {
                String result;
                HttpDataHandler  http = new HttpDataHandler();
                result = http.GetHttpData(strings[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
               mdialog.dismiss();
               rssObject = new Gson().fromJson(s, RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject,getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        StringBuilder url_get_data = new StringBuilder(RSS_toJson_ApI);
        url_get_data.append(RSS_link);
        loadRssAsync.execute(url_get_data.toString());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

  @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh)
          loadRss();

        return false;
    }
}