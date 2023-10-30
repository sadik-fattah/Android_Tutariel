package com.guercifzone.ui_controls_android.Webviews;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.guercifzone.ui_controls_android.R;
import com.guercifzone.ui_controls_android.Webviews.injected.WebviewController;

public class Activity_WebView_InjectElement extends AppCompatActivity  {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_inject_element);


            WebView mywebview;

            mywebview = (WebView) findViewById(R.id.web_blogger);
            mywebview.getSettings().setJavaScriptEnabled(true);
            mywebview.loadUrl("https://guercifzone-ar.blogspot.com/search/label/Blogger?&max-results=9");
            mywebview.setWebViewClient(new WebviewController());

    }
}