package com.example.lenovo.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

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

public class searchActivity extends AppCompatActivity {
    String TAG="searchActivity";
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView_adapter recyclerViewAdapter;
    private ArrayList<Subjects> subjectsArrayList;
private  int start=0;
  private  int count=15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_search);
        toolbar=findViewById(R.id.search_toolBar);
        toolbar.setTitle("          此类型的电影");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final TextView textView=findViewById(R.id.wait_search);
        final ProgressBar progressBar=findViewById(R.id.ProgressBar_search);
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        recyclerView=findViewById(R.id.rec_search);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Intent intent = getIntent();
        String kindName = intent.getStringExtra("kindNmae");
        OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/search?tag=" + kindName + "&start="+start+"&count="+count, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responsText = response.body().string();
                subjectsArrayList = handleResponse.handleSubjectsResponse(responsText);
                Log.d(TAG, "onResponse: ");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewAdapter = new RecyclerView_adapter(searchActivity.this, subjectsArrayList);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        Log.d(TAG, "run: ");
                        progressBar.setVisibility(View.GONE);
                        textView.setVisibility(View.GONE);
                        recyclerViewAdapter.setOnItemClickListener(new RecyclerView_adapter.OnItemClickListener() {
                            @Override
                            public void onClick(int position) {
                                Subjects subjects = subjectsArrayList.get(position);
                                String movieId = subjects.getId();
                                String tiltle = subjects.getTitle();
                                String imgUrl = subjects.getImages().getSmall();
                                double pinfen = subjects.getRating().average;
                                Intent intent = new Intent(searchActivity.this, detailActivity.class);
                                intent.putExtra("movieID", movieId);
                                intent.putExtra("tiltle", tiltle);
                                intent.putExtra("url", imgUrl);
                                intent.putExtra("pinFen", pinfen);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongClick(int position) {

                            }
                        });

                    }
                });
            }
        });
        if (!recyclerView.canScrollVertically(1)) {
            start = count;
            count += 30;
            OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/top250?start=" + String.valueOf(start) + "&count=" + String.valueOf(count), new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responsText = response.body().string();

                    ArrayList<Subjects> subjectsArrayList2 = new ArrayList<>();
                    subjectsArrayList2 = handleResponse.handleSubjectsResponse(responsText);
                    subjectsArrayList.addAll(subjectsArrayList2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerViewAdapter.notifyDataSetChanged();
                        }
                    });
                }

            });



        }
    }
}