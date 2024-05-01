package com.guercifzone.example2_rssfeed;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity {
//String Url = "https://rss.nytimes.com/services/xml/rss/nyt/World.xml";
    private static final String TAG = "MainActivity";
   String Url = "https://guercifzone-ar.blogspot.com/feeds/posts/default?alt=rss";
ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls = (ListView) findViewById(R.id.feedlist);
        downloadUrl(Url);
    }
    public void downloadUrl(String url){
 RssHelper helper = new RssHelper();
 helper.execute(url);
    }

    private class RssHelper extends AsyncTask<String,Void,String>{
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            DataFormatter formatter = new DataFormatter();
            if (formatter.format(s)){
                ArrayAdapter<RssFeed> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.adapterlist,
                        formatter.getfeeDdATA());
                ls.setAdapter(adapter);
                ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Bundle bundle = new Bundle();
                        bundle.putString("head",formatter.getfeeDdATA().get(position).getTitle());
                        bundle.putString("sum",formatter.getfeeDdATA().get(position).getDescription());
                        Intent i = new Intent(MainActivity.this, Descript.class);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                });
            }else {
                Log.d(TAG,"onPostExecute : Formatting  failed");
            }
            progressDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("wait  to  show ....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            return downloadData(strings[0]);
        }
        public String downloadData(String address){
            StringBuilder data = new StringBuilder();
            try {
                URL url = new URL(address);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                Log.d(TAG,"downloaddata : responsecode" + connect.getResponseCode());
                BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null){
                    data.append(line);
                }
                reader.close();
            }catch (Exception e){
                Log.d(TAG,"download"+e);
            }
            return data.toString();
        }
    }
}