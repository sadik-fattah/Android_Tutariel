package com.guercifzone.arabiczone.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.arabiczone.DataObject.Article;
import com.guercifzone.arabiczone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Article> articles;

    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Article article=articles.get(position);

        String title=article.getTitle();
        String desc=article.getDescription();
        String date=article.getDate();
       // String imageUrl=article.getImageUrl().replace("localhost","10.0.2.2");

        holder.titleTxt.setText(title);
        holder.desctxt.setText(desc.substring(0,130));
        holder.dateTxt.setText(date);
       // PicassoClient.downloadImage(c,imageUrl,holder.img);


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}

