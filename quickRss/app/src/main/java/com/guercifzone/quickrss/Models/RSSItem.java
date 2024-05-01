package com.guercifzone.quickrss.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RSSItem {
    private String CLASS_NAME = "RSSItem";

    private String title;
    private Date date;
    private String image;
    private String description;
    private String link;

    public RSSItem( String title, Date date, String image, String description, String link) {
        this.title = title;
        this.date = date;
        this.image = image;
        this.description = description;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}
