package com.example.lenovo.myapplication.util.http;

import com.example.lenovo.myapplication.util.gson.Subjects;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class handleResponse {
    public static List<Subjects> handleSubjectsResponse(String response, List<Subjects> subjectsList) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("subjects");
            for (int i = 0; i < jsonArray.length(); i++) {
                String eachMovieContent = jsonArray.getJSONObject(i).toString();
                Subjects subjects = new Gson().fromJson(eachMovieContent, Subjects.class);
                subjectsList.add(subjects);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return subjectsList;
    }
}