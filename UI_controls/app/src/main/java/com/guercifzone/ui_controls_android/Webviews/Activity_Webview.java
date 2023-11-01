package com.guercifzone.ui_controls_android.Webviews;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Webview extends AppCompatActivity {
WebView webView;
//https://guercifzone-ar.blogspot.com/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
webView = (WebView) findViewById(R.id.webkit);
webView.getSettings().setJavaScriptEnabled(true);
webView.loadUrl("https://guercifzone-ar.blogspot.com/");
webView.setWebViewClient(new WebViewClient());
    }
}