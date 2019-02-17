package com.example.lenovo.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.RecyclerView_adapter;
import com.example.lenovo.myapplication.util.gson.Subjects;
import com.example.lenovo.myapplication.util.http.OKHttp;
import com.example.lenovo.myapplication.util.http.handleResponse;
import com.example.lenovo.myapplication.util.myApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.lenovo.myapplication.util.http.handleResponse.handleSubjectsResponse;

public class firstFragment extends Fragment {
    private static final String TAG = "firstFragment";
    public ArrayList<Subjects> subjectsList = new ArrayList<>();
    public String responsetext = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ok");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.Rec);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url("https://api.douban.com/v2/movie/in_theaters?city=重庆&start=0&count=20").build();
            Response response=client.newCall(request).execute();
        responsetext=response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Gson gson=new Gson();
            JSONObject jsonObject=new JSONObject(responsetext);
            JSONArray jsonArray=jsonObject.getJSONArray("subjects");
            for (int i = 0; i <jsonArray.length() ; i++) {
                String eachContent=jsonArray.getJSONObject(i).toString();
                Subjects subjects=gson.fromJson(eachContent, new TypeToken<Subjects>() {}.getType());
                subjectsList.add(subjects);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}).start();

        RecyclerView_adapter recyclerViewAdapter = new RecyclerView_adapter(getActivity(), subjectsList);
        recyclerView.setAdapter(recyclerViewAdapter);
        Log.d(TAG, "onCreateView: ok");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated:");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
}
//OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/in_theaters?city=重庆&start=0&count=20", new Callback() {
//    @Override
//    public void onFailure(Call call, IOException e) {
//        e.printStackTrace();
//    }
//
//    @Override
//    public void onResponse(Call call, Response response) throws IOException {
//responsetext=response.body().string();
//        subjectsList = handleResponse.handleSubjectsResponse(responsetext);
//    }
//});




