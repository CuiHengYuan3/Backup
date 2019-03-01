package com.example.lenovo.myapplication.util.gson2;

import java.util.List;

public class detail {
private int reviews_count;
private   int wish_count;

    public int getReviews_count() {
        return reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public String getYear() {
        return year;
    }

    public List<com.example.lenovo.myapplication.util.gson2.casts> getCasts() {
        return casts;
    }

    public String getSummary() {
        return summary;
    }

    public String getCollect_count() {
        return collect_count;
    }

    private   String year;
//public List<Countries> countries;
private   List<casts> casts;
private   String summary;
//public  List<Genres> genres;
private   String collect_count;
}
