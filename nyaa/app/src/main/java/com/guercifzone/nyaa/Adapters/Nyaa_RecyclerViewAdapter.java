package com.guercifzone.nyaa.Adapters;

import android.annotation.SuppressLint;
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
import com.bumptech.glide.request.RequestOptions;
import com.guercifzone.nyaa.DetailsActivity;
import com.guercifzone.nyaa.MainActivity;
import com.guercifzone.nyaa.Models.Nyaa_Feed;
import com.guercifzone.nyaa.Models.Nyaa_Item;
import com.guercifzone.nyaa.Models.Nyaa_Root;
import com.guercifzone.nyaa.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class Nyaa_RecyclerViewAdapter extends RecyclerView.Adapter<Nyaa_RecyclerViewAdapter.NyaaViewHolder>{
    private Nyaa_Item nyaa_root;
    private Context context;
    RequestOptions options;

    public Nyaa_RecyclerViewAdapter(Nyaa_Item nyaa_root, Context context) {
        this.nyaa_root = nyaa_root;
        this.context = context;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.ca22lp01);
    }

    public Nyaa_RecyclerViewAdapter(MainActivity mainActivity, List<Nyaa_Root> nyaaRoots) {
    }

    @NonNull
    @NotNull
    @Override
    public NyaaViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.rss_item_list_row,viewGroup,false);
        final NyaaViewHolder viewHolder = new NyaaViewHolder(view);
        viewHolder.view_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                /*intent.putExtra("ArabicZone_title",nyaa_root.items.get(viewHolder.getAdapterPosition()).getTitle("title"));
                intent.putExtra("ArabicZone_description",nyaa_root.items.get(viewHolder.getAdapterPosition()).getDescription("description"));
                intent.putExtra("ArabicZone_link",nyaa_root.items.get(viewHolder.getAdapterPosition()).getLink("link"));
                intent.putExtra("ArabicZone_author",nyaa_root.items.get(viewHolder.getAdapterPosition()).getAuthor("author"));
*/
               context.startActivity(intent);
            }
        });

        return  viewHolder;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull NyaaViewHolder holder, int position) {
        holder.ar_name.setText(nyaa_root.getTitle());
        holder.ar_pubdate.setText(nyaa_root.getPubDate());
    }



    public class NyaaViewHolder extends RecyclerView.ViewHolder{
        TextView ar_name;
        TextView ar_pubdate;
        ImageView img_thumbnail;
        LinearLayout view_content;

        public NyaaViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            view_content = itemView.findViewById(R.id.contailner);
            ar_name = itemView.findViewById(R.id.nyaa_title);
            ar_pubdate = itemView.findViewById(R.id.nyaa_pubdate);
            img_thumbnail = itemView.findViewById(R.id.nyaa_img);
        }
    }
   }


