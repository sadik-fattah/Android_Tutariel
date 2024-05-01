package com.guercifzone.example4_rssfeed;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.example4_rssfeed.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
NewsHeadlines headlines;
TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
ImageView img_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");
        txt_title = (TextView) findViewById(R.id.text_detail_title);
        txt_author  = (TextView) findViewById(R.id.text_detail_author);
        txt_time = (TextView) findViewById(R.id.text_detail_time);
        txt_detail = (TextView) findViewById(R.id.text_detail_detail);
        txt_content = (TextView) findViewById(R.id.text_detail_content);
        img_news = (ImageView) findViewById(R.id.img_detail_news);

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublisheAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());

        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
    }
}