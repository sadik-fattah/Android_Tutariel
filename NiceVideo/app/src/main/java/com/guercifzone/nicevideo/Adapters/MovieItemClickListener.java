package com.guercifzone.nicevideo.Adapters;

import android.widget.ImageView;
import com.guercifzone.nicevideo.Models.Movie;


public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

}
