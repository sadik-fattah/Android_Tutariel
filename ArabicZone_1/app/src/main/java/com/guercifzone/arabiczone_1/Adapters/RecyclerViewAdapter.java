package com.guercifzone.arabiczone_1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.guercifzone.arabiczone_1.Az_Details_Show;
import com.guercifzone.arabiczone_1.Models.Feed;
import com.guercifzone.arabiczone_1.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext ;
    private List<Feed> feedList;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Feed> feedList) {
        this.mContext = mContext;
        this.feedList = feedList;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape);
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
       View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
      view = inflater.inflate(R.layout.arabic_row_item,viewGroup,false);
      final MyViewHolder viewHolder = new MyViewHolder(view);
    viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent  = new Intent(mContext, Az_Details_Show.class);

              intent.putExtra("ArabicZone_title",feedList.get(viewHolder.getAdapterPosition()).getTitle());
              intent.putExtra("ArabicZone_description",feedList.get(viewHolder.getAdapterPosition()).getDescription());
              intent.putExtra("ArabicZone_link",feedList.get(viewHolder.getAdapterPosition()).getLink());
              intent.putExtra("ArabicZone_author",feedList.get(viewHolder.getAdapterPosition()).getAuthor("author"));
              intent.putExtra("ArabicZone_thumbnail",feedList.get(viewHolder.getAdapterPosition()).getImage());
              mContext.startActivity(intent);
          }
      });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i) {
        myViewHolder.ar_name.setText(feedList.get(i).getTitle());
        myViewHolder.ar_author.setText(feedList.get(i).getAuthor(("author")));
       Glide.with(mContext).load(feedList.get(i).getImage()).apply(option).into(myViewHolder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ar_name ;
        TextView ar_author;
        ImageView img_thumbnail;
        LinearLayout view_container;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            ar_name = itemView.findViewById(R.id.arabic_name);
            ar_author = itemView.findViewById(R.id.author);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
