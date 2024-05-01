package com.guercifzone.oldnyaa;

import android.annotation.SuppressLint;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 ListView lvRss;
 ArrayList<String>titles;
    ArrayList<String>gids;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvRss = (ListView) findViewById(R.id.lvRss);
        titles = new ArrayList<String>();
        gids = new ArrayList<String>();
       lvRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


             Uri uri = Uri.parse(gids.get(position));
               Intent intent = new Intent(Intent.ACTION_VIEW,uri);
               startActivity(intent);
           }
       });
       new MainActivity.ProcessInBackground().execute();
    }
public InputStream  getInputStream(URL url){
    try {
        return  url.openConnection().getInputStream();
    }catch (IOException e) {
        return null;
    }
}
public class ProcessInBackground extends AsyncTask<Integer,Void,Exception>{
ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
Exception exception = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("wait  to  show ....");
        progressDialog.show();
    }

    @Override
    protected Exception doInBackground(Integer... integers) {
        try {
            URL url = new URL("https://nyaa.land/?page=rss");
               // URL url = new URL("https://feeds.capi24.com/v1/Search/articles/fin24/tech/rss");
         // URL url = new URL("https://guercifzone-ar.blogspot.com/feeds/posts/default?alt=rss");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(getInputStream(url), "UTF_8");
            boolean insideitem = false;
            int eventype = xmlPullParser.getEventType();
            while (eventype != XmlPullParser.END_DOCUMENT){
                if (eventype == XmlPullParser.START_TAG){
                    if (xmlPullParser.getName().equalsIgnoreCase("item")){
                        insideitem = true;
                    } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {
                        if (insideitem){
                            titles.add(xmlPullParser.nextText());
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("guid")) {
                        if (insideitem){
                            gids.add(xmlPullParser.nextText());
                        }
                    }
                } else if (eventype == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {
                    insideitem = false;
                }
                eventype = xmlPullParser.next();
            }
        }catch (MalformedURLException e){
            exception = e;
        }catch (XmlPullParserException e){
            exception = e;
        }catch (IOException e){
            exception = e;
        }
        return exception;
    }
    @Override
    protected void onPostExecute(Exception e) {
        super.onPostExecute(e);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,titles);
        lvRss.setAdapter(adapter);
        progressDialog.dismiss();
    }
}

}