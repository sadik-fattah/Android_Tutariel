package com.guercifzone.example4_rssfeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.example4_rssfeed.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines,SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.headline_list_items,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomViewHolder hoder, @SuppressLint("RecyclerView") int position) {
        hoder.text_title.setText(headlines.get(position).getTitle());
        hoder.text_source.setText(headlines.get(position).getSource().getName());
            if (headlines.get(position).getUrlToImage()!=null){
                Picasso.get().load(headlines.get(position).getUrlToImage()).into(hoder.img_headline);
            }
            hoder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnNewsClicked(headlines.get(position));
                }
            });
                }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
