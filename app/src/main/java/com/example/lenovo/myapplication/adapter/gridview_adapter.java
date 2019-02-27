package com.example.lenovo.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;

public class gridview_adapter extends BaseAdapter {
    private Context mContext;
    private String[] data;

    public gridview_adapter(Context mContext, String[] data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
   return      data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.griditem_layout, null);
            mViewHolder = new ViewHolder();
            mViewHolder.moiveKindsText =  convertView.findViewById(R.id.tv_kind);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.moiveKindsText.setText(data[position]);

        return convertView;


    }
    public static class ViewHolder {
        TextView moiveKindsText;
    }
}
