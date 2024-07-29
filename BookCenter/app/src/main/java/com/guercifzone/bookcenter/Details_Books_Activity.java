package com.guercifzone.bookcenter;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Details_Books_Activity extends AppCompatActivity {
    String url;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_books);
        webView = (WebView) findViewById(R.id.pdfView);
        Intent in = getIntent();
        url = in.getStringExtra("Book_loc");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        if (TextUtils.isEmpty(url)){
            Toast.makeText(getApplicationContext(), "url not found", Toast.LENGTH_SHORT).show();
        finish();
        }
    }
}