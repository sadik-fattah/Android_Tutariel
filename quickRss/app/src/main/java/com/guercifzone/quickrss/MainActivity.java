package com.guercifzone.quickrss;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.quickrss.API.APILiga;
import com.guercifzone.quickrss.Adapters.RSSListAdapter;
import com.guercifzone.quickrss.Models.RSSItem;
import com.guercifzone.quickrss.Suport.InternetTools;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.provider.MediaStore.MediaColumns.TITLE;

public class MainActivity extends AppCompatActivity {

    private Context thisContext = this;
    private String CLASS_NAME = "MainActivity";

    private int ITEMS_IN_LIST = 3;
    private int ITEMS_COUNT;
    private int PAGES_COUNT;

    private APILiga api;
    private InternetTools internetTools = new InternetTools(thisContext);

    private Button[] paginationButtons;
    private ArrayList<RSSItem> items;
    private ArrayList<RSSItem> sortedItems;

    ListView FeedList;
    LinearLayout paginationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentStart();
    }

    // actions when loading a fragment
    public void fragmentStart(){

        elementsInit();
        setListeners();
        reload();
    }


    public void reload(){

        if(internetTools.isInternetAvailable())
            showElements();
        else
            showAlertDialog();
    }

    // setting event handlers
    public void setListeners(){

        FeedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openNewsItem(
                        sortedItems.get(position).getLink(),
                        sortedItems.get(position).getTitle()
                );
            }
        });
    }

    // initialization of view elements
    public void elementsInit(){
        FeedList = findViewById(R.id.lvRSSList);
    }

    // setting the adapter for the list
    public void showElements(){

        api = new APILiga();
        items = new ArrayList<>(api.getItems());
        ITEMS_COUNT = items.size();
        if( ITEMS_COUNT > 0 ) { //checking for news existence

            /*
                output without paninating

                RSSListAdapter listAdapter = new RSSListAdapter(this, items);
                FeedList.setAdapter(listAdapter);
            */

            /*
                output with pagination
            */

            pagination();
            loadNewsList(0);
            setActivePage(0);

        }else {

            Log.v(CLASS_NAME + " showElements ", "elements not found");
            Toast.makeText(this, getString(R.string.rss_empty), Toast.LENGTH_SHORT).show();
        }
    }

    // display a message about the lack of Internet
    protected void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(thisContext);
        builder.setMessage(R.string.dialog_no_internet_connection)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_retry, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        reload();
                    }
                })
                .setNegativeButton(R.string.dialog_exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        onBackPressed();
                    }
                });

        builder.create().show();
    }

    // call a new Activity with full news
    public void openNewsItem(String newsUrl, String newsTitle){

        Intent intent = new Intent(this, NewsReadActivity.class);
        intent.putExtra("URL", newsUrl);
        intent.putExtra("TITLE", newsTitle);
        startActivity(intent);
    }

    // pagination calculation
    private void pagination(){
        int val = ITEMS_COUNT % ITEMS_IN_LIST;
        val = val == 0 ? 0 : 1;
        PAGES_COUNT = ITEMS_COUNT / ITEMS_IN_LIST + val;

        paginationLayout = findViewById(R.id.pagination);

        paginationButtons = new Button[PAGES_COUNT];

        for(int i = 0; i < PAGES_COUNT; i++){
            paginationButtons[i] = new Button(this);
            paginationButtons[i]
                    .setBackgroundColor(getResources()
                            .getColor(android.R.color.transparent));
            paginationButtons[i].setText("" + (i + 1));

            LinearLayout.LayoutParams paginationLayoutParameters = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            paginationLayout.addView(paginationButtons[i], paginationLayoutParameters);

            final int j = i;
            paginationButtons[j].setOnClickListener(new View.OnClickListener(){

                public void onClick(View v){

                    loadNewsList(j);
                    setActivePage(j);
                }
            });
        }

    }

    // selecting the active page
    private void setActivePage(int index){

        this.setTitle(
                getString(R.string.pagination_page)
                        + " " + (index + 1) + " "
                        + getString(R.string.pagination_of)
                        + " " + PAGES_COUNT
        );

        for(int i = 0; i < PAGES_COUNT; i++){
            if(i==index){
                paginationButtons[index]
                        .setBackgroundDrawable(getResources()
                                .getDrawable(R.drawable.ic_launcher_background));
                paginationButtons[i]
                        .setTextColor(getResources()
                                .getColor(android.R.color.white));
            }
            else{
                paginationButtons[i]
                        .setBackgroundColor(getResources()
                                .getColor(android.R.color.transparent));
                paginationButtons[i]
                        .setTextColor(getResources()
                                .getColor(android.R.color.black));
            }
        }

    }

    // loading the list by page
    private void loadNewsList(int number){
        sortedItems = new ArrayList<>();

        int start = number * ITEMS_IN_LIST;

        for(int i = start; i < start + ITEMS_IN_LIST; i++){
            if(i<items.size())
                sortedItems.add(items.get(i));
            else
                break;
        }

        RSSListAdapter sd = new RSSListAdapter(this, sortedItems);
        FeedList.setAdapter(sd);
    }

}
