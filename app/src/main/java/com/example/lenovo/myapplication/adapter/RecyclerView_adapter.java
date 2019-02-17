package com.example.lenovo.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.Fragment.firstFragment;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.util.gson.Casts;
import com.example.lenovo.myapplication.util.gson.Directors;
import com.example.lenovo.myapplication.util.gson.Subjects;
import com.example.lenovo.myapplication.util.myApplication;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView_adapter.ViewHolder> {
    private static final String TAG = "RecyclerView_adapter";
    public Context context;
    private ArrayList<Subjects> mSubjects;

    public RecyclerView_adapter(Context context, ArrayList<Subjects> mSubjects) {
        this.context = context;
        this.mSubjects = mSubjects;
        Log.d(TAG, "RecyclerView_adapter: 构造");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recview_item_layout, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        return holder;
    
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Subjects subjects = mSubjects.get(i);
        Glide.with(myApplication.getContext()).load(subjects.images.getSmall()).into(viewHolder.moviePic);
        viewHolder.movieName.setText(subjects.title);
        for (Directors directors : subjects.directors) {
            String oldText = (String) viewHolder.director.getText();
            viewHolder.director.setText(oldText + directors.getName() + "/");
        }
        viewHolder.director.setText(viewHolder.director.getText().subSequence(0, viewHolder.director.length() - 1));
        for (Casts casts : subjects.casts) {
            String oldText = (String) viewHolder.actors.getText();
            viewHolder.actors.setText(oldText + casts.getName() + "/");
        }
        viewHolder.actors.setText(viewHolder.actors.getText().subSequence(0, viewHolder.actors.length() - 1));
        double pinFen = subjects.rating.getAverage();
        viewHolder.score.setText("pinFen");
        String scroe = subjects.rating.getStars();
        double a = (double) (Integer.parseInt(scroe)) / 10;
        a--;
        viewHolder.star1.setImageResource(R.drawable.start1);

        a--;
        if (a >= 1.0) {
            viewHolder.star2.setImageResource(R.drawable.start1);
        }else if (a==0.5){
            viewHolder.star2.setImageResource(R.drawable.start1);
            viewHolder.star3.setImageResource(R.drawable.start_half);
        }else if (a==0){
            viewHolder.star2.setImageResource(R.drawable.start1);
        }

        a--;
        if (a >= 1.0) {
            viewHolder.star3.setImageResource(R.drawable.start1);
        }else if (a==0.5){
            viewHolder.star3.setImageResource(R.drawable.start1);
 viewHolder.star4.setImageResource(R.drawable.start_half);
        }else if (a==0){
            viewHolder.star3.setImageResource(R.drawable.start1);
        }
    a--;
        if (a >= 1.0) {
            viewHolder.star4.setImageResource(R.drawable.start1);
viewHolder.star5.setImageResource(R.drawable.start1);
        }else if (a==0.5){
            viewHolder.star4.setImageResource(R.drawable.start1);
            viewHolder.star5.setImageResource(R.drawable.start_half);
        }else if (a==0){
            viewHolder.star4.setImageResource(R.drawable.start1);
        }

        Log.d(TAG, "onBindViewHolder: ");

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: start");
        return  mSubjects.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePic;
        TextView movieName;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        TextView score;
        TextView actors;
        TextView director;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePic = itemView.findViewById(R.id.iv_img);
            movieName = itemView.findViewById(R.id.tv_title);
            score = itemView.findViewById(R.id.score);
            actors = itemView.findViewById(R.id.tv_yanyuang);
            director = itemView.findViewById(R.id.direct);
            star1 = itemView.findViewById(R.id.iv_start1);
            star2 = itemView.findViewById(R.id.iv_start2);
            star3 = itemView.findViewById(R.id.iv_start3);
            star4 = itemView.findViewById(R.id.iv_start4);
            star5 = itemView.findViewById(R.id.iv_start5);
            Log.d(TAG, "ViewHolder: ");
        }
    }
}