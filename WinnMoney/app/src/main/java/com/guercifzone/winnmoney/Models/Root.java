package com.guercifzone.winnmoney.Models;

import java.util.ArrayList;

public class Root {
        public String status;
        public Feed feed;
        public ArrayList<MyItem> items;

    public Root(String status, Feed feed, ArrayList<MyItem> items) {
        this.status = status;
        this.feed = feed;
        this.items = items;
    }
public Root(){

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

    public ArrayList<MyItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MyItem> items) {
        this.items = items;
    }
}


