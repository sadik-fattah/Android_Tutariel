package com.guercifzone.ui_controls_android.Webviews;

import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_Webview_emabed extends AppCompatActivity {
    //<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fwww.facebook.com%2Fsadik.fattah.7%2Fvideos%2F516710646175706%2F&show_text=false&width=560&t=0\" width=\"560\" height=\"314\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>
  //<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/NncJj-3o0PQ?si=_n-KY611XzSEt5on\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>
private WebView webfacebook,webyoutube;
String fbvideo = "<iframe src=\\\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fwww.facebook.com%2Fsadik.fattah.7%2Fvideos%2F516710646175706%2F&show_text=false&width=560&t=0\\\" width=\\\"560\\\" height=\\\"314\\\" style=\\\"border:none;overflow:hidden\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen=\\\"true\\\" allow=\\\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\\\" allowFullScreen=\\\"true\\\"></iframe>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_emabed);
webfacebook = (WebView) findViewById(R.id.facbook);
webyoutube = (WebView) findViewById(R.id.youtube);

webfacebook.loadData(fbvideo,"text/html",null);
webfacebook.getSettings().setJavaScriptEnabled(true);

webyoutube.loadData("<iframe width=\\\"560\\\" height=\\\"315\\\" src=\\\"https://www.youtube.com/embed/NncJj-3o0PQ?si=_n-KY611XzSEt5on\\\" title=\\\"YouTube video player\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\\\" allowfullscreen></iframe>","text/html",null);
  webyoutube.getSettings().setJavaScriptEnabled(true);
    }
}