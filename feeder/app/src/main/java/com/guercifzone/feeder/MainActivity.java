package com.guercifzone.feeder;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<String> rssLinks1 = new ArrayList<>();
    ArrayList<String> rssLinks2 = new ArrayList<>();
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRediff = (Button) findViewById(R.id.btnRediff);
       Button btnCinemaBlend = (Button) findViewById(R.id.btnCinemaBlend);
       btnRediff.setOnClickListener(MainActivity.this);
      btnCinemaBlend.setOnClickListener(MainActivity.this);
      // rssLinks.add("https://nyaa.land/?page=rss");

        Intent intent = new Intent(getApplicationContext(), RSSFeedActivity.class);
btnRediff.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         rssLinks1.add("http://www.cinemablend.com/rss_review.php");
       // rssLinks1.add("https://guercifzone-ar.blogspot.com/feeds/posts/default?alt=rss");
        intent.putExtra("rssLink", rssLinks1.get(0));
        startActivity(intent);
    }
});
btnCinemaBlend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        rssLinks2.add("http://www.rediff.com/rss/moviesreviewsrss.xml");
        intent.putExtra("rssLink", rssLinks2.get(0));
        startActivity(intent);
    }
});
    }

     @Override
   public void onClick(View view)  {
        id = view.getId();
        Intent intent = new Intent(getApplicationContext(), RSSFeedActivity.class);
           switch (id) {
               case 1:
                   rssLinks1.add("http://www.rediff.com/rss/moviesreviewsrss.xml");
                   intent.putExtra("rssLink", rssLinks1.get(0));
                   startActivity(intent);
                    break;
                case 2:
                    rssLinks2.add("http://www.cinemablend.com/rss_review.php");
                    intent.putExtra("rssLink", rssLinks2.get(0));
                    startActivity(intent);
                    break;
            }


        }

    }



