package com.guercifzone.ui_controls_android.Webviews;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Webview_LoadHtmlFile extends AppCompatActivity {

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_webview_load_html_file);
        WebView wv = (WebView) findViewById(R.id.webview1);
        wv.loadUrl("file:///android_asset/index.html");
    }

}
