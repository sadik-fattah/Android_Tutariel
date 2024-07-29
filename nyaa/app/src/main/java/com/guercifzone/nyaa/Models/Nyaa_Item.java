package com.guercifzone.nyaa.Models;

import java.util.ArrayList;

public class Nyaa_Item {
    public String title;
    public String pubDate;
    public String link;
    public String guid;
    public String author;
    public String thumbnail;
    public String description;
    public String content;
    public Nyaa_Enclosure enclosure;
    public ArrayList<Object> categories;

    public Nyaa_Item(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, Nyaa_Enclosure enclosure, ArrayList<Object> categories) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.enclosure = enclosure;
        this.categories = categories;
    }

    public String getTitle() {
        return this.title;
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

    public String getLink(String link) {
        return this.link;
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

    public String getAuthor(String author) {
        return this.author;
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

    public String getDescription(String description) {
        return this.description;
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

    public Nyaa_Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Nyaa_Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public ArrayList<Object> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Object> categories) {
        this.categories = categories;
    }
}
