package com.guercifzone.nicevideo.Models;

public class Video {
    String movieName;
    String movieLink;
    String movieImage;
    String movieType;
    String moviedescription;

    public Video() {
    }

    public Video(String movieName, String movieLink, String movieImage, String movieType, String moviedescription) {
        this.movieName = movieName;
        this.movieLink = movieLink;
        this.movieImage = movieImage;
        this.movieType = movieType;
        this.moviedescription = moviedescription;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMoviedescription() {
        return moviedescription;
    }

    public void setMoviedescription(String moviedescription) {
        this.moviedescription = moviedescription;
    }
}