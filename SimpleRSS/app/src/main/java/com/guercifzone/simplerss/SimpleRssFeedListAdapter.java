package com.guercifzone.simplerss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SimpleRssFeedListAdapter extends RecyclerView.Adapter<SimpleRssFeedListAdapter.FeedModelViewHolder> {
    private List<SimpleRssFeedModel> mRssFeedModels;
    private static Context context;
    public SimpleRssFeedListAdapter(Context context, List<SimpleRssFeedModel> mRssFeedModels){
        this.context = context;
        this.mRssFeedModels = mRssFeedModels;
    }
    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        private View rssFeedView;

        public FeedModelViewHolder(View v) {
            super(v);
            rssFeedView = v;
        }
    }
    public SimpleRssFeedListAdapter(List<SimpleRssFeedModel> rssFeedModels) {
        mRssFeedModels = rssFeedModels;
    }
    @NonNull
    @NotNull
    @Override
    public SimpleRssFeedListAdapter.FeedModelViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int type) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_rss_feed, viewGroup, false);
        FeedModelViewHolder holder = new FeedModelViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SimpleRssFeedListAdapter.FeedModelViewHolder feedModelViewHolder, int position) {
        final SimpleRssFeedModel rssFeedModel = mRssFeedModels.get(position);


        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.titleText)).setText(rssFeedModel.nyaaTitle);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.linkText)).setText(rssFeedModel.nyaaLink);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.gideText)).setText(rssFeedModel.nyaaGuid);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.pubdateText)).setText(rssFeedModel.nyaaPubDate);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.infohashText)).setText(rssFeedModel.nyaaInfoHash);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.categorieText)).setText(rssFeedModel.nyaaCateGory);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.sizeText)).setText(rssFeedModel.nyaaSize);
        ((TextView)feedModelViewHolder.rssFeedView.findViewById(R.id.descriptionText)).setText(rssFeedModel.nyaaDescription);
    }

    @Override
    public int getItemCount() {
        return mRssFeedModels.size();
    }
}
