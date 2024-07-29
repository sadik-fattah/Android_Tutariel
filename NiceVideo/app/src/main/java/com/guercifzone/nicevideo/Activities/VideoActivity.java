package com.guercifzone.nicevideo.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.guercifzone.nicevideo.Classes.FullScreenVideo;
import com.guercifzone.nicevideo.Classes.MyWebViewController;
import com.guercifzone.nicevideo.R;

import java.util.Objects;

public class VideoActivity extends AppCompatActivity {
    //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    // fullScreenVideo.getSettings().setJavaScriptEnabled(true);

    String url,type,name,img,descriotion;
    @SuppressLint({"MissingInflatedId", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        try {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }catch (Exception e){
            e.printStackTrace();
        }


      url = getIntent().getExtras().getString("Video_loc");
      type = getIntent().getExtras().getString("Video_type");
      name = getIntent().getExtras().getString("Video_title");
      img = getIntent().getExtras().getString("Video_image");
      descriotion = getIntent().getExtras().getString("Video_description");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.movies_title);
        TextView tv_type = findViewById(R.id.movies_type) ;
        TextView tv_description = findViewById(R.id.movies_description);
       FullScreenVideo fullScreenVideo   = findViewById(R.id.webview) ;
        ImageView myimg = findViewById(R.id.aa_thumbnail);

        tv_name.setText(name);
        tv_type.setText(type);
        tv_description.setText(descriotion);

        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ca22lp01).error(R.drawable.ca22lp01);
        Glide.with(this).load(img).apply(requestOptions).into(myimg);

        fullScreenVideo.loadUrl(url);
        fullScreenVideo.setWebViewClient(new MyWebViewController());
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(getApplicationContext(), "Video not Existe ", Toast.LENGTH_SHORT).show();
           // finish();
        }

}
}