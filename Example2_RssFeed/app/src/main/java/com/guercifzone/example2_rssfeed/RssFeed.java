package com.guercifzone.example2_rssfeed;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;

public class RssFeed {
    private String title , description,pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return "title: " +getTitle();//+"\nPubData: " +getPubDate()+"\nDescription: "+getDescription();
    }
}
