package com.guercifzone.quickrss;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.webkit.WebView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.quickrss.Suport.InternetTools;

public class NewsReadActivity extends AppCompatActivity {

    private String CLASS_NAME = "NewsReadActivity";

    private Context thisContext = this;
    private InternetTools internetTools = new InternetTools(thisContext);

    private WebView browser;

    private String activityTitle;
    private String newsUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_read);

        fragmentStart();
    }

    // actions when loading a fragment
    private void fragmentStart(){

        if(internetTools.isInternetAvailable()) {
            getIntentData();
            elementsInit();
        } else
            showAlertDialog();

    }

    // initializing view elements and loading the page
    public void elementsInit(){

        browser = findViewById(R.id.wvBrowser);

        this.setTitle(activityTitle);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(newsUrl);
    }

    // receiving data transferred from MainActivity
    private void getIntentData(){

        Intent intent = getIntent();
        activityTitle = intent.getStringExtra("TITLE");
        newsUrl = intent.getStringExtra("URL");
    }

    // display a message about the lack of Internet
    protected void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(thisContext);
        builder.setMessage(R.string.dialog_no_internet_connection)
                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.dialog_retry, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        fragmentStart();
                    }
                })
                .setNegativeButton(R.string.dialog_back, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        onBackPressed();
                    }
                });

        builder.create().show();
    }

}
