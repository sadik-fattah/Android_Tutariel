package com.guercifzone.example1_rssfeed.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.example1_rssfeed.Interface.ItemClickListener;
import com.guercifzone.example1_rssfeed.Models.Feed;
import com.guercifzone.example1_rssfeed.Models.Item;
import com.guercifzone.example1_rssfeed.Models.RSSObject;
import com.guercifzone.example1_rssfeed.PicassoClient;
import com.guercifzone.example1_rssfeed.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
public TextView txttitle,txtpubdata,txtcontent;
    ImageView imageView;
private ItemClickListener itemClickListener;
    public FeedViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        txttitle = (TextView) itemView.findViewById(R.id.title);
        txtpubdata = (TextView) itemView.findViewById(R.id.putdata);
        txtcontent = (TextView) itemView.findViewById(R.id.content);
        imageView= (ImageView) itemView.findViewById(R.id.articleImage);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {
    private RSSObject rssObject;
    private Context context;
    private LayoutInflater inflater;
 

    public FeedAdapter(RSSObject rssObject, Context context) {
        this.rssObject = rssObject;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @NotNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.row,viewGroup,false);
        return new FeedViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull FeedViewHolder holder, int position) {


        holder.txttitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtpubdata.setText(rssObject.getItems().get(position).getPubDate());
        holder.txtcontent.setText(rssObject.getItems().get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
