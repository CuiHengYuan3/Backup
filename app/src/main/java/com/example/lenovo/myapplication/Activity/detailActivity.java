package com.example.lenovo.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.Fragment.myApplication;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.actor_recyclerview_adapter;
import com.example.lenovo.myapplication.util.gson2.Countries;
import com.example.lenovo.myapplication.util.gson2.Genres;
import com.example.lenovo.myapplication.util.gson2.detail;
import com.example.lenovo.myapplication.util.http.OKHttp;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class detailActivity extends AppCompatActivity {
    private static final String TAG = "detailActivity";
    public ImageView iv_img;
    public TextView DmovieName;
    public TextView showTime;
    public TextView kinds;
    public TextView movielong;
    public TextView country;
    public TextView kanGuo;
    public TextView xiangKan;
    public TextView pf3;
    public TextView pfNumber;
    public TextView brief;
    public RecyclerView juZhaoa;
    public detail detail;
    public ScrollView scrollView;
    public ProgressBar progressBar;
    public TextView waitText;
    public actor_recyclerview_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        Intent intent = getIntent();
        setContentView(R.layout.activity_detail2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        juZhaoa = findViewById(R.id.juZhaoa);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        juZhaoa.setLayoutManager(linearLayoutManager);
        progressBar = findViewById(R.id.ProgressBar_detail);
        waitText = findViewById(R.id.wait);
        iv_img = findViewById(R.id.iv_img);
        DmovieName = findViewById(R.id.DmovieName);
        showTime = findViewById(R.id.showTime);
        kinds = findViewById(R.id.kinds);
        movielong = findViewById(R.id.movielong);
        country = findViewById(R.id.country);
        kanGuo = findViewById(R.id.kanGuo);
        xiangKan = findViewById(R.id.xiangKan);
        pf3 = findViewById(R.id.pf3);
        pfNumber = findViewById(R.id.pfNumber);
        brief = findViewById(R.id.brief);
        scrollView = findViewById(R.id.scrollView);
        scrollView.setVisibility(View.GONE);
////
        String id = intent.getStringExtra("movieID");
        final String tiltle = intent.getStringExtra("tiltle");
        final String imgUrl = intent.getStringExtra("url");
        final double penFen = intent.getDoubleExtra("pinFen", 0.0);
        Log.d(TAG, "onCreate: 1");
        OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/subject/" + id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(detailActivity.this, "获取信息失败", Toast.LENGTH_SHORT);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: ");
                final String responsText = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(responsText);
                            JSONArray jsonArray = jsonObject.getJSONArray("countries");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                String countryNmae = jsonArray.getString(i);

                                country.setText(country.getText() + countryNmae + "/");
                            }
                            country.setText(country.getText().subSequence(0, country.length() - 1));
                            JSONObject jsonObject2 = new JSONObject(responsText);
                            JSONArray jsonArray2 = jsonObject2.getJSONArray("genres");
                            for (int i = 0; i < jsonArray2.length(); i++) {
                                String movieKind = jsonArray2.getString(i);
                                kinds.setText(kinds.getText() + movieKind + "/");
                            }
                            kinds.setText(kinds.getText().subSequence(0, kinds.length() - 1));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

                Gson gson = new Gson();
                detail = gson.fromJson(responsText, com.example.lenovo.myapplication.util.gson2.detail.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: ");
                        adapter = new actor_recyclerview_adapter(detail.casts);
                        juZhaoa.setAdapter(adapter);
                        Glide.with(detailActivity.this).load(imgUrl).into(iv_img);
                        DmovieName.setText(tiltle);
                        showTime.setText(showTime.getText() + detail.year);
//                   for (Genres genres:detail.genres){
//kinds.setText(kinds.getText()+genres.leiXin+"/");
//                   }
//               kinds.setText(kinds.getText().subSequence(0,kinds.length()-1));
                        movielong.setText(movielong.getText() + "124分钟");
//           for (Countries countries:detail.countries){
//               country.setText(country.getText()+countries.countryName+"/");
//           }
//              country.setText(country.getText().subSequence(0,country.length()-1));
                        kanGuo.setText(kanGuo.getText() + String.valueOf(detail.reviews_count) + "人");
                        xiangKan.setText(xiangKan.getText() + String.valueOf(detail.wish_count) + "人");
                        pf3.setText(pf3.getText() + String.valueOf(penFen));
                        pfNumber.setText(String.valueOf(detail.collect_count) + "人评价");
                        brief.setText(detail.summary);
                        scrollView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        waitText.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

}
