package com.guercifzone.bookcenter.Adapters;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.guercifzone.bookcenter.Details_Books_Activity;
import com.guercifzone.bookcenter.Models.Books;
import com.guercifzone.bookcenter.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mcontext;
    private List<Books> feedList;
    RequestOptions options;
    public RecyclerViewAdapter(Context mcontext, List<Books> feedList) {
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
        view = inflater.inflate(R.layout.recycler_view_list,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, Details_Books_Activity.class);
               // intent.putExtra("Book_title",feedList.get(viewHolder.getAdapterPosition()).getBook_name());
                intent.putExtra("Book_loc",feedList.get(viewHolder.getAdapterPosition()).getBook_link());
              //  intent.putExtra("Book_type",feedList.get(viewHolder.getAdapterPosition()).getBook_type());
              //  intent.putExtra("Book_image",feedList.get(viewHolder.getAdapterPosition()).getBook_image());
                mcontext.startActivity(intent);
            }
        });
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i) {
        myViewHolder.book_name.setText(feedList.get(i).getBook_name());
        myViewHolder.book_loc.setText(feedList.get(i).getBook_link());
        myViewHolder.book_type.setText(feedList.get(i).getBook_type());
        Glide.with(mcontext).load(feedList.get(i).getBook_image()).apply(options).into(myViewHolder.img_thumbnail);

    }
    @Override
    public int getItemCount() {
        return feedList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_name;
        TextView book_loc;
        TextView book_type;
        ImageView img_thumbnail;
        ConstraintLayout view_content;

        @SuppressLint("WrongViewCast")
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            view_content = itemView.findViewById(R.id.contailner);
            book_name = itemView.findViewById(R.id.booktv_name);
            book_loc = itemView.findViewById(R.id.booktv_loc);
            book_type = itemView.findViewById(R.id.booktv_type);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
    public void setFilteredList(List<Books> filteredList) {
        this.feedList = filteredList;
        notifyDataSetChanged();
    }
}