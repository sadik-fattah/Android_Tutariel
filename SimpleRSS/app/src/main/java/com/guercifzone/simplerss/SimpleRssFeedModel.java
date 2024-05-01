package com.guercifzone.simplerss;

public class SimpleRssFeedModel {
    public String nyaaTitle;
    public String nyaaLink;
    public String nyaaGuid;
    public String nyaaPubDate;
    public String nyaaInfoHash;
    public String nyaaCateGory;
    public String nyaaSize;
    public String nyaaDescription;

    public SimpleRssFeedModel(String nyaaTitle, String nyaaLink, String nyaaGuid, String nyaaPubDate, String nyaaInfoHash, String nyaaCateGory, String nyaaSize, String nyaaDescription) {
        this.nyaaTitle = nyaaTitle;
        this.nyaaLink = nyaaLink;
        this.nyaaGuid = nyaaGuid;
        this.nyaaPubDate = nyaaPubDate;
        this.nyaaInfoHash = nyaaInfoHash;
        this.nyaaCateGory = nyaaCateGory;
        this.nyaaSize = nyaaSize;
        this.nyaaDescription = nyaaDescription;
    }
}
