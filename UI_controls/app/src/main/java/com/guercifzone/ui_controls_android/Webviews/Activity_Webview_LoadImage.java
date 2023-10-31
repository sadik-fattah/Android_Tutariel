package com.guercifzone.ui_controls_android.Webviews;

import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Webview_LoadImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_load_image);
        WebView upperView = (WebView)findViewById(R.id.upperview);

        upperView.getSettings().setBuiltInZoomControls(true);
        upperView.loadUrl("file:///android_asset/phonne.png");

        WebView lowerView = (WebView)findViewById(R.id.lowerview);
        String htmlString =
                "<h1>Header</h1><p>This is HTML text<br /><i>Formatted in italics</i></p>";
        lowerView.loadData(htmlString, "text/html", "utf-8");
    }
}