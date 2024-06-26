package com.guercifzone.winnmoney.Models;

import java.util.ArrayList;

public class MyItem {

        public String title;
        public String pubDate;
        public String link;
        public String guid;
        public String author;
        public String thumbnail;
        public String description;
        public String content;
        public Enclosure enclosure;
        public ArrayList<String> categories;

        public MyItem(){

        }
        public MyItem(String title, String pubDate, String link, String guid, String author, String thumbnail, String description, String content, Enclosure enclosure, ArrayList<String> categories) {
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

        public Enclosure getEnclosure() {
                return enclosure;
        }

        public void setEnclosure(Enclosure enclosure) {
                this.enclosure = enclosure;
        }

        public ArrayList<String> getCategories() {
                return categories;
        }

        public void setCategories(ArrayList<String> categories) {
                this.categories = categories;
        }
}

