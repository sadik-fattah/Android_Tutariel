package com.guercifzone.example1_rssfeed.Models;

import java.util.List;

public class Item {
    public String title ;
    public String pubDate ;
    public String link ;
    public String guid ;
    public String author;
    public String thumbnail;
    public String description ;
    public String content ;

    public List<String> categories ;

    public Item(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content,  List<String> categories) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;

        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }





    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
