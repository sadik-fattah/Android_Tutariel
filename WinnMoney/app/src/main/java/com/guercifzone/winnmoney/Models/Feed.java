package com.guercifzone.winnmoney.Models;

public class Feed {
    public String url;
    public String title;
    public String link;
    public String author;
    public String description;
    public String image;

    public Feed(){

    }
    public Feed(String url, String title, String link, String author, String description, String image) {
        this.url = url;
        this.title = title;
        this.link = link;
        this.author = author;
        this.description = description;
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle(String title) {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink(String link) {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor(String author) {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription(String description) {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage(String thumbnail) {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
