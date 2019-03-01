package com.example.lenovo.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.Activity.detailActivity;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.RecyclerView_adapter;
import com.example.lenovo.myapplication.util.gson1.Subjects;
import com.example.lenovo.myapplication.util.http.OKHttp;
import com.example.lenovo.myapplication.util.http.handleResponse;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class firstFragment extends Fragment {
    private static final String TAG = "firstFragment";
    private ArrayList<Subjects> subjectsList;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;
    private RecyclerView_adapter recyclerViewAdapter;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfragment_layout, container, false);
        swipeRefreshLayout = view.findViewById(R.id.refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.lightGreen);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/in_theaters?city=重庆&start=0&count=20", new Callback() {
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
                                recyclerViewAdapter.notifyDataSetChanged();
                                Toast.makeText(myApplication.getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });
            }
        });
        progressBar = view.findViewById(R.id.progress_Bar);
        textView = view.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        subjectsList = new ArrayList<>();
        Log.d(TAG, String.valueOf(subjectsList.size()));
        recyclerView = view.findViewById(R.id.Rec);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/in_theaters?city=重庆&start=0&count=20", new Callback() {
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
                        recyclerViewAdapter.setOnItemClickListener(new RecyclerView_adapter.OnItemClickListener() {
                            @Override
                            public void onClick(int position) {
                                Subjects subjects = subjectsList.get(position);
                                String movieId = subjects.getId();
                                String tiltle = subjects.getTitle();
                                String imgUrl = subjects.getImages().getSmall();
                                double pinfen = subjects.getRating().getAverage();
                                Intent intent = new Intent(getActivity(), detailActivity.class);
                                intent.putExtra("movieID", movieId);
                                intent.putExtra("tiltle", tiltle);
                                intent.putExtra("url", imgUrl);
                                intent.putExtra("pinFen", pinfen);
                                startActivity(intent);
                                Log.d(TAG, movieId);
                            }

                            @Override
                            public void onLongClick(int position) {
Toast.makeText(myApplication.getContext(),"哈哈哈长点是一个彩蛋恭喜你找到了",Toast.LENGTH_LONG);
                            }
                        });

                    }
                });

            }
        });


        Log.d(TAG, "onCreateView: notifyDataSetChanged");
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

