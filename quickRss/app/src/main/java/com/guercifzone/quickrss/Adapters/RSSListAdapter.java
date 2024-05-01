package com.guercifzone.quickrss.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.guercifzone.quickrss.Models.RSSItem;
import com.guercifzone.quickrss.R;

import java.io.InputStream;
import java.util.ArrayList;

public class RSSListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<RSSItem> listItems;
    private LayoutInflater layout;

    public RSSListAdapter(Context newContext, ArrayList<RSSItem> items){
        context = newContext;
        listItems = new ArrayList<>(items);
        layout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // form the future list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layout.inflate(R.layout.feed_item, parent, false);
        }

        RSSItem rssItem = (RSSItem) getItem(position);

        ((TextView) view.findViewById(R.id.tvFeedItemTitle)).setText(rssItem.getTitle());
        ((TextView) view.findViewById(R.id.tvFeedItemDate)).setText(rssItem.getDate());
        ((TextView) view.findViewById(R.id.tvFeedItemDescription)).setText(rssItem.getDescription());
        new DownloadImageTask((ImageView) view.findViewById(R.id.imgvRssItemImage))
                .execute(rssItem.getImage().toString());

        return view;
    }

    /* loading an image in a stream */
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private String CLASS_NAME = "DownloadImageTask";
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception otherException) {
                Log.e(CLASS_NAME, otherException.getMessage());
                otherException.printStackTrace();
            }
            return mIcon11;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

