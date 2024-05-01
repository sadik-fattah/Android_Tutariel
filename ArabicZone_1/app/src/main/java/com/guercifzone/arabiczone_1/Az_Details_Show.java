package com.guercifzone.arabiczone_1;

import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.guercifzone.arabiczone_1.Classes.GlideImageGetter;

import java.util.Objects;

public class Az_Details_Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.az_details_show);
        //getSupportActionBar().hide();
            Objects.requireNonNull(getSupportActionBar()).hide();

            String image_url = getIntent().getExtras().getString("ArabicZone_thumbnail");
            String title = getIntent().getExtras().getString("ArabicZone_title");
            String description = getIntent().getExtras().getString("ArabicZone_description");
            String link = getIntent().getExtras().getString("ArabicZone_link");
            String author = getIntent().getExtras().getString("ArabicZone_author");



            CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
            collapsingToolbarLayout.setTitleEnabled(true);

            TextView tv_title = findViewById(R.id.arabiczoneTitle);
            TextView tv_link = findViewById(R.id.arabiczoneLink);
            TextView tv_author = findViewById(R.id.arabiczoneAuthor);
            TextView tv_description = findViewById(R.id.arabiczoneDescription);
            ImageView img = findViewById(R.id.arabiczoneThumbnail);

            tv_title.setText(title);
            tv_link.setText(link);
        tv_author.setText(author);
            tv_description.setText(description);
        Spanned htmlspane= null;
        GlideImageGetter glideImageGetter = new GlideImageGetter(this,tv_description);

        htmlspane = Html.fromHtml(description,glideImageGetter,null );
        tv_description.setText(htmlspane);

        collapsingToolbarLayout.setTitle(title);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ca22lp01).error(R.drawable.ca22lp01);
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }

    }











