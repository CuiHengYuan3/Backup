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
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.util.gson1.Casts;
import com.example.lenovo.myapplication.util.gson1.Directors;
import com.example.lenovo.myapplication.util.gson1.Subjects;
import com.example.lenovo.myapplication.Fragment.myApplication;

import java.util.ArrayList;

public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView_adapter.ViewHolder> {
    private static final String TAG = "RecyclerView_adapter";
    private OnItemClickListener mOnItemClickListener;
    private ArrayList<Subjects> mSubjects;

    public RecyclerView_adapter(Context context, ArrayList<Subjects> mSubjects) {
        this.mSubjects = mSubjects;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View outView;//最外层view
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
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePic = itemView.findViewById(R.id.iv_img);
            movieName = itemView.findViewById(R.id.tv_title);
            score = itemView.findViewById(R.id.score);
            actors = itemView.findViewById(R.id.tv_yanyuang);
            director = itemView.findViewById(R.id.tv_daoyan);
            star1 = itemView.findViewById(R.id.iv_start1);
            star2 = itemView.findViewById(R.id.iv_start2);
            star3 = itemView.findViewById(R.id.iv_start3);
            star4 = itemView.findViewById(R.id.iv_start4);
            star5 = itemView.findViewById(R.id.iv_start5);
            view = itemView.findViewById(R.id.line);
            outView = itemView;
            Log.d(TAG, "ViewHolder: ");
        }
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {//??????????final?
        if (mOnItemClickListener != null) {
            viewHolder.outView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(viewHolder.getAdapterPosition());
                }
            });
            viewHolder.outView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(viewHolder.getAdapterPosition());
                    return false;
                }
            });
        }

        Subjects subjects = mSubjects.get(viewHolder.getAdapterPosition());
        Glide.with(myApplication.getContext()).load(subjects.getImages().getSmall()).into(viewHolder.moviePic);
        viewHolder.movieName.setText(subjects.getTitle());
      String DaoYanName="";
        for (Directors directors : subjects.getDirectors()) {
            Log.d(TAG, "onBindViewHolder: 1");
       DaoYanName+=directors.getName() + "/";
        }
        viewHolder.director.setText("导演："+DaoYanName);
        viewHolder.director.setText(viewHolder.director.getText().subSequence(0, viewHolder.director.length() - 1));
     String yanYuanName="";
        for (Casts casts : subjects.getCasts()) {
            Log.d(TAG, "onBindViewHolder: 2");
         yanYuanName+=casts.getName()+"/";
        }
        viewHolder.actors.setText("演员:" + yanYuanName);

        viewHolder.actors.setText(viewHolder.actors.getText().subSequence(0, viewHolder.actors.length() - 1));
        String pinFen = String.valueOf(subjects.getRating().getAverage());
        viewHolder.score.setText(pinFen);
        String scroe = subjects.getRating().getStars();
        double a = (double) (Integer.parseInt(scroe)) / 10;
        a--;
        viewHolder.star1.setImageResource(R.drawable.start1);

        a--;
        if (a >= 1.0) {
            viewHolder.star2.setImageResource(R.drawable.start1);
        } else if (a == 0.5) {
            viewHolder.star2.setImageResource(R.drawable.start1);
            viewHolder.star3.setImageResource(R.drawable.start_half);
        } else if (a == 0) {
            viewHolder.star2.setImageResource(R.drawable.start1);
        }

        a--;
        if (a >= 1.0) {
            viewHolder.star3.setImageResource(R.drawable.start1);
        } else if (a == 0.5) {
            viewHolder.star3.setImageResource(R.drawable.start1);
            viewHolder.star4.setImageResource(R.drawable.start_half);
        } else if (a == 0) {
            viewHolder.star3.setImageResource(R.drawable.start1);
        }
        a--;
        if (a >= 1.0) {
            viewHolder.star4.setImageResource(R.drawable.start1);
            viewHolder.star5.setImageResource(R.drawable.start1);
        } else if (a == 0.5) {
            viewHolder.star4.setImageResource(R.drawable.start1);
            viewHolder.star5.setImageResource(R.drawable.start_half);
        } else if (a == 0) {
            viewHolder.star4.setImageResource(R.drawable.start1);
        }

        Log.d(TAG, "onBindViewHolder: ");

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: start");
        return mSubjects.size();

    }

    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}