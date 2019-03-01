package com.example.lenovo.myapplication.util.gson2;

public class directors {
private String name;

    public String getName() {
        return name;
    }

    public Avatars getAvatars() {
        return avatars;
    }

    public directors(String name, Avatars avatars) {
        this.name = name;
        this.avatars = avatars;
    }

    private   Avatars avatars;
public class   Avatars{
        public   String small;
    }
}
