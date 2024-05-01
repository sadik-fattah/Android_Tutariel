package com.guercifzone.guercif_ar_zone.ui.java;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.guercifzone.guercif_ar_zone.R;
import com.guercifzone.guercif_ar_zone.WebViewController;


public class JavaFragment extends Fragment {
    WebView mywebview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mywebview = mywebview.findViewById(R.id.web_webview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("https://guercifzone-ar.blogspot.com/search/label/java?&max-results=5");
        mywebview.setWebViewClient(new WebViewController());
        return inflater.inflate(R.layout.fragment_container, container, false);

    }
}