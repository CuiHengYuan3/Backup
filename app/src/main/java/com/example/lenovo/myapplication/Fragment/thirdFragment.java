package com.example.lenovo.myapplication.Fragment;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.RecyclerView_adapter;
import com.example.lenovo.myapplication.util.gson.Subjects;
import com.example.lenovo.myapplication.util.http.OKHttp;
import com.example.lenovo.myapplication.util.http.handleResponse;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class thirdFragment extends Fragment {
    public ArrayList<Subjects> subjectsList;
    public  RecyclerView_adapter recyclerViewAdapter;
    public RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.thirdfragment_layout,container,false);
        progressBar=view.findViewById(R.id.progress_Bar3);
        textView=view.findViewById(R.id.progress3);
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        subjectsList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.Rec3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/top250?start=0&count=250", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responsText = response.body().string();
                 subjectsList = handleResponse.handleSubjectsResponse(responsText);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewAdapter = new RecyclerView_adapter(getActivity(), subjectsList);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        progressBar.setVisibility(View.GONE);
                        textView.setVisibility(View.GONE);

                    }
                });

            }
        });

        return  view;

    }
       }
