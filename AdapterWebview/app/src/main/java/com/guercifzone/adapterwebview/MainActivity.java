package com.guercifzone.adapterwebview;

import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private WebView webvideView;
private ListView listView;
ArrayList<String> videolist;
ArrayAdapter adapter;
    String hizb1 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F150553560171094%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>",
            hizb2 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F416452313042546%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>",
            hizb3 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fhassan.saidi.1999%2Fvideos%2F1044735685964638%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>",
            hizb4 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F1933222893480677%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>",
            hizb5 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F1596835100705556%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>",
            hizb6 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F1368021003397264%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\" allowFullScreen=\"true\"></iframe>",
            hizb7 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=314&href=https%3A%2F%2Fweb.facebook.com%2Fministere.habous%2Fvideos%2F1289799838100597%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none,overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay, clipboard-write, encrypted-media, picture-in-picture, web-share\" allowFullScreen=\"true\"></iframe>",
            hizb8 = "<iframe src=\"https://www.facebook.com/plugins/video.php?height=308&href=https%3A%2F%2Fweb.facebook.com%2Fhassan.saidi.1999%2Fvideos%2F1046314349140105%2F&show_text=false&width=560&t=0\" width=\"360\" height=\"260\" style=\"border:none,overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay, clipboard-write, encrypted-media, picture-in-picture, web-share\" allowFullScreen=\"true\"></iframe>";
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
listView = (ListView) findViewById(R.id.list_view);
webvideView = (WebView) findViewById(R.id.web_vidseo_view);
videolist= new ArrayList<>();
videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
           videolist.add("الفيديو الاول");
adapter = new ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,videolist);
listView.setAdapter(adapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       switch (position){
           case 0:
webvideView.loadData(hizb1,"text/html",null);
webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 1:
               webvideView.loadData(hizb8,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 2:
               webvideView.loadData(hizb2,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 3:
               webvideView.loadData(hizb3,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 4:
               webvideView.loadData(hizb4,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 5:
               webvideView.loadData(hizb5,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 6:
               webvideView.loadData(hizb6,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
           case 7:
               webvideView.loadData(hizb7,"text/html",null);
               webvideView.getSettings().setJavaScriptEnabled(true);
               break;
       }
    }
});
       }
}