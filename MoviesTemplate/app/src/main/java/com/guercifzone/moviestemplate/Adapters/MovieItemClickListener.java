package com.guercifzone.moviestemplate.Adapters;

import android.widget.ImageView;
import com.guercifzone.moviestemplate.Models.Movie;


public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

}
