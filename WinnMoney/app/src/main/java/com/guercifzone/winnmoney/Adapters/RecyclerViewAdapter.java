package com.guercifzone.winnmoney.Adapters;

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
import com.guercifzone.winnmoney.Ar_Details_Activity;
import com.guercifzone.winnmoney.Models.Feed;
import com.guercifzone.winnmoney.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
private Context mcontext;
private List<Feed> feedList;
RequestOptions options;

    public RecyclerViewAdapter(Context context, List<Feed> feedList) {
        this.mcontext = context;
        this.feedList = feedList;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.ca22lp01);
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        view = inflater.inflate(R.layout.recyclerview_resource_list,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
      viewHolder.view_content.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(mcontext, Ar_Details_Activity.class);
              intent.putExtra("ArabicZone_title",feedList.get(viewHolder.getAdapterPosition()).getTitle("title"));
              intent.putExtra("ArabicZone_description",feedList.get(viewHolder.getAdapterPosition()).getDescription("description"));
              intent.putExtra("ArabicZone_link",feedList.get(viewHolder.getAdapterPosition()).getLink("link"));
              intent.putExtra("ArabicZone_author",feedList.get(viewHolder.getAdapterPosition()).getAuthor("author"));
              intent.putExtra("ArabicZone_thumbnail",feedList.get(viewHolder.getAdapterPosition()).getImage("thumbnail"));
              mcontext.startActivity(intent);
          }
      });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i) {
myViewHolder.ar_name.setText(feedList.get(i).getTitle("title"));
        myViewHolder.ar_author.setText(feedList.get(i).getTitle("author"));
        Glide.with(mcontext).load(feedList.get(i).getImage("thumnail")).apply(options).into(myViewHolder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
TextView ar_name;
TextView ar_author;
ImageView img_thumbnail;
LinearLayout view_content;

       public MyViewHolder(@NonNull @NotNull View itemView) {
                 super(itemView);
                 view_content = itemView.findViewById(R.id.contailner);
           ar_name = itemView.findViewById(R.id.arabic_name);
           ar_author = itemView.findViewById(R.id.arabic_author);
           img_thumbnail = itemView.findViewById(R.id.thumbnail);
       }
   }
}
