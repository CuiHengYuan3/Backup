package com.example.lenovo.myapplication.util.http;

import com.example.lenovo.myapplication.util.gson1.Subjects;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class handleResponse {
    public static ArrayList<Subjects> handleSubjectsResponse(String response) {
        ArrayList<Subjects> subjectsList=new ArrayList<>();

        JsonObject jsonObject1=new JsonParser().parse(response).getAsJsonObject();

        JsonArray jsonArray=jsonObject1.getAsJsonArray("subjects");
        Gson gson=new Gson();
        for (JsonElement user:jsonArray) {
              Subjects subjects = gson.fromJson(user, new TypeToken<Subjects>() {}.getType());
              subjectsList.add(subjects);
          }
        return subjectsList;
    }
}