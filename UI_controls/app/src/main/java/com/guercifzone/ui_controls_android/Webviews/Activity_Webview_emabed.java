package com.guercifzone.ui_controls_android.Webviews;

import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Webview_emabed extends AppCompatActivity {
    private WebView webfacebook,webyoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_emabed);
        webfacebook = (WebView) findViewById(R.id.facbook);
        webyoutube = (WebView) findViewById(R.id.youtube);

        webfacebook.loadData("<iframe src=\\\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F150553560171094%2F&show_text=false&width=560&t=0\\\" width=\\\"360\\\" height=\\\"260\\\" style=\\\"border:none;overflow:hidden\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen=\\\"true\\\" allow=\\\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\\\" allowFullScreen=\\\"true\\\"></iframe>", "text/html", null);
        webfacebook.getSettings().setJavaScriptEnabled(true);
        webyoutube.loadData("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/NncJj-3o0PQ?si=_n-KY611XzSEt5on\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>", "text/html", null);
        webyoutube.getSettings().setJavaScriptEnabled(true);
    }
}