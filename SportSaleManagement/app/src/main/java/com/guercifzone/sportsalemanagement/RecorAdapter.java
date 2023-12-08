package com.guercifzone.sportsalemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecorAdapter extends RecyclerView.Adapter<RecorAdapter.RecordViewHolder> {
    private Context context;
    private ArrayList<ModelRecord> modelRecords;

    public RecorAdapter(Context context, ArrayList<ModelRecord> modelRecords) {
        this.context = context;
        this.modelRecords = modelRecords;
    }

    @NonNull
    @NotNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecordViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RecordViewHolder extends RecyclerView.ViewHolder{
        TextView fullname, email, phone;
        ImageView myimageView;
        ImageButton imageButton;
        public RecordViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
