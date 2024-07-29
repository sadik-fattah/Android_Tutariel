package com.guercifzone.nicevideo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
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
import com.guercifzone.nicevideo.Activities.VideoActivity;
import com.guercifzone.nicevideo.Models.Video;
import com.guercifzone.nicevideo.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mcontext;
    private List<Video> feedList;
    RequestOptions options;

    public RecyclerViewAdapter(Context mcontext, List<Video> feedList) {
        this.mcontext = mcontext;
        this.feedList = feedList;
         options = new RequestOptions().centerCrop().placeholder(R.drawable.ca22lp01);
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        view = inflater.inflate(R.layout.sourcelist,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, VideoActivity.class);
                intent.putExtra("Video_title",feedList.get(viewHolder.getAdapterPosition()).getMovieName());
                intent.putExtra("Video_loc",feedList.get(viewHolder.getAdapterPosition()).getMovieLink());
               intent.putExtra("Video_type",feedList.get(viewHolder.getAdapterPosition()).getMovieType());
               intent.putExtra("Video_description",feedList.get(viewHolder.getAdapterPosition()).getMoviedescription());
               intent.putExtra("Video_image",feedList.get(viewHolder.getAdapterPosition()).getMovieImage());
                mcontext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i) {
        myViewHolder.game_name.setText(feedList.get(i).getMovieName());
        myViewHolder.game_loc.setText(feedList.get(i).getMovieLink());
        myViewHolder.game_type.setText(feedList.get(i).getMovieType());
        myViewHolder.game_description.setText(feedList.get(i).getMoviedescription());
        Glide.with(mcontext).load(feedList.get(i).getMovieImage()).apply(options).into(myViewHolder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView game_name;
        TextView game_type;
        TextView game_loc;
        TextView game_description;
        ImageView img_thumbnail;
        LinearLayout view_content;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            view_content = itemView.findViewById(R.id.contailner);
            game_name = itemView.findViewById(R.id.videotv_name);
            game_type = itemView.findViewById(R.id.videotv_type);
           game_loc = itemView.findViewById(R.id.videotv_link);
           game_description = itemView.findViewById(R.id.videotv_description);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
public void setFilteredList(List<Video> filteredList){
        this.feedList = filteredList;
        notifyDataSetChanged();
}

}
