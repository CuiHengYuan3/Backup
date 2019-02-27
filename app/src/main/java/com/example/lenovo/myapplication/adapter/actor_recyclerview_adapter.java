package com.example.lenovo.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.Activity.MainActivity;
import com.example.lenovo.myapplication.Fragment.myApplication;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.util.gson2.casts;

import java.util.List;

public class actor_recyclerview_adapter extends RecyclerView.Adapter<actor_recyclerview_adapter.ViewHolder> {
    private List<casts> castsList;

    public actor_recyclerview_adapter(List<casts> castsList) {
        this.castsList = castsList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView actorImage;
        TextView actorText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        actorImage=itemView.findViewById(R.id.Ijuzhao);
        actorText= itemView.findViewById(R.id.shiYan);

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reclayout_item2,viewGroup,false);

    ViewHolder viewHolder=new ViewHolder(view);
    return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        casts casts=castsList.get(i);
viewHolder.actorText.setText(casts.getName());
 String picUrl=casts.avatars.small;
        Glide.with(myApplication.getContext()).load(picUrl).into(viewHolder.actorImage);
    }

    @Override
    public int getItemCount() {
return  castsList.size();
    }
}
