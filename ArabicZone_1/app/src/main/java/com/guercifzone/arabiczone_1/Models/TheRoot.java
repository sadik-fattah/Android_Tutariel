package com.guercifzone.arabiczone_1.Models;

import java.util.ArrayList;

public class TheRoot {
    public String status;
    public Feed feed;
    public ArrayList<TheItem> items;

    public TheRoot(String status, Feed feed, ArrayList<TheItem> items) {
        this.status = status;
        this.feed = feed;
        this.items = items;
    }
    public TheRoot(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public ArrayList<TheItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<TheItem> items) {
        this.items = items;
    }
}

