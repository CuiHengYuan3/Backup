package com.example.lenovo.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.RecyclerView_adapter;
import com.example.lenovo.myapplication.util.gson.Subjects;
import com.example.lenovo.myapplication.util.http.OKHttp;
import com.example.lenovo.myapplication.util.http.handleResponse;
import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.lenovo.myapplication.util.http.handleResponse.handleSubjectsResponse;

public class firstFragment extends Fragment {
//public static String textString="{\n" +
//        "    \"count\": 1,\n" +
//        "    \"start\": 0,\n" +
//        "    \"total\": 19,\n" +
//        "    \"subjects\": [\n" +
//        "        {\n" +
//        "            \"rating\": {\n" +
//        "                \"max\": 10,\n" +
//        "                \"average\": 7.9,\n" +
//        "                \"stars\": \"40\",\n" +
//        "                \"min\": 0\n" +
//        "            },\n" +
//        "            \"genres\": [\n" +
//        "                \"科幻\",\n" +
//        "                \"灾难\"\n" +
//        "            ],\n" +
//        "            \"title\": \"流浪地球\",\n" +
//        "            \"casts\": [\n" +
//        "                {\n" +
//        "                    \"alt\": \"https://movie.douban.com/celebrity/1359081/\",\n" +
//        "                    \"avatars\": {\n" +
//        "                        \"small\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1533348792.03.jpg\",\n" +
//        "                        \"large\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1533348792.03.jpg\",\n" +
//        "                        \"medium\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1533348792.03.jpg\"\n" +
//        "                    },\n" +
//        "                    \"name\": \"屈楚萧\",\n" +
//        "                    \"id\": \"1359081\"\n" +
//        "                },\n" +
//        "                {\n" +
//        "                    \"alt\": \"https://movie.douban.com/celebrity/1000525/\",\n" +
//        "                    \"avatars\": {\n" +
//        "                        \"small\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1501738155.24.jpg\",\n" +
//        "                        \"large\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1501738155.24.jpg\",\n" +
//        "                        \"medium\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1501738155.24.jpg\"\n" +
//        "                    },\n" +
//        "                    \"name\": \"吴京\",\n" +
//        "                    \"id\": \"1000525\"\n" +
//        "                },\n" +
//        "                {\n" +
//        "                    \"alt\": \"https://movie.douban.com/celebrity/1275178/\",\n" +
//        "                    \"avatars\": {\n" +
//        "                        \"small\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1540619056.43.jpg\",\n" +
//        "                        \"large\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1540619056.43.jpg\",\n" +
//        "                        \"medium\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1540619056.43.jpg\"\n" +
//        "                    },\n" +
//        "                    \"name\": \"李光洁\",\n" +
//        "                    \"id\": \"1275178\"\n" +
//        "                }\n" +
//        "            ],\n" +
//        "            \"collect_count\": 1089745,\n" +
//        "            \"original_title\": \"流浪地球\",\n" +
//        "            \"subtype\": \"movie\",\n" +
//        "            \"directors\": [\n" +
//        "                {\n" +
//        "                    \"alt\": \"https://movie.douban.com/celebrity/1276086/\",\n" +
//        "                    \"avatars\": {\n" +
//        "                        \"small\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1536678787.83.jpg\",\n" +
//        "                        \"large\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1536678787.83.jpg\",\n" +
//        "                        \"medium\": \"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1536678787.83.jpg\"\n" +
//        "                    },\n" +
//        "                    \"name\": \"郭帆\",\n" +
//        "                    \"id\": \"1276086\"\n" +
//        "                }\n" +
//        "            ],\n" +
//        "            \"year\": \"2019\",\n" +
//        "            \"images\": {\n" +
//        "                \"small\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2545472803.jpg\",\n" +
//        "                \"large\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2545472803.jpg\",\n" +
//        "                \"medium\": \"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2545472803.jpg\"\n" +
//        "            },\n" +
//        "            \"alt\": \"https://movie.douban.com/subject/26266893/\",\n" +
//        "            \"id\": \"26266893\"\n" +
//        "        }\n" +
//        "    ],\n" +
//        "    \"title\": \"正在上映的电影-重庆\"\n" +
//        "}";
    public View view;
public  RecyclerView recyclerView;
public RecyclerView_adapter recyclerViewAdapter;
public List <Subjects> subjectsList1=null;
    public List <Subjects> subjectsList2=null;
@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.firstfragment_layout,container,false);
recyclerView=view.findViewById(R.id.Rec);
//setRequest("重庆");
//    OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/in_theaters?city=重庆"  + "&start=0" + "&count=25", new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//
//                })




    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(myApplication.getContext());
recyclerView.setLayoutManager(linearLayoutManager);
    recyclerViewAdapter=new RecyclerView_adapter(subjectsList2);
recyclerView.setAdapter(recyclerViewAdapter);
        return  view;
    }
//public  void setRequest(String cityName){
//    OKHttp.sendOKHttpcRequest("https://api.douban.com/v2/movie/in_theaters?city=" + cityName + "&start=0" + "&count=25", new Callback() {
//        @Override
//        public void onFailure(Call call, IOException e) {
//            e.printStackTrace();
////怎么回到主线程修改UI？
//        }
//
//        @Override
//        public void onResponse(Call call, Response response) throws IOException {
//final String responseText=response.body().toString();
//     subjectsList2= handleResponse.handleSubjectsResponse(responseText,subjectsList1);
//        }
//    });
//


}
