package com.guercifzone.example4_rssfeed;

import com.guercifzone.example4_rssfeed.Models.NewsHeadlines;

import java.util.List;

public interface OnfetchDataListener<NewsApiResponse> {
    void onfetchdata(List<NewsHeadlines> list,String message);
    void onError(String message);
}
