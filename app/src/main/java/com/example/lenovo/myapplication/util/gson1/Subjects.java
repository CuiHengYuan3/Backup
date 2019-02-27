package com.example.lenovo.myapplication.util.gson1;

import java.util.List;

public class Subjects {
private String title;
private String name;
private String id;
private List<Casts> casts;
private List<Directors> directors;
private Images images;
private Rating rating;

    public List<Casts> getCasts() {
        return casts;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public Images getImages() {
        return images;
    }

    public Rating getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
