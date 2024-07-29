package com.guercifzone.nyaa.Models;

import java.util.ArrayList;

public class Nyaa_Root {
    public String status;
    public Nyaa_Feed feed;
    public ArrayList<Nyaa_Item> items;

    public Nyaa_Root(String status, Nyaa_Feed feed, ArrayList<Nyaa_Item> items) {
        this.status = status;
        this.feed = feed;
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Nyaa_Feed getFeed() {
        return feed;
    }

    public void setFeed(Nyaa_Feed feed) {
        this.feed = feed;
    }

    public ArrayList<Nyaa_Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Nyaa_Item> items) {
        this.items = items;
    }
}
