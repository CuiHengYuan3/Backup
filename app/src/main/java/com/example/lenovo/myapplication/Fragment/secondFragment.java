package com.example.lenovo.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lenovo.myapplication.Activity.detailActivity;
import com.example.lenovo.myapplication.Activity.searchActivity;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.gridview_adapter;

public class secondFragment extends Fragment {
 GridView gridView;
    private String[] leixingNames = {"剧情","爱情","喜剧","科幻","动作","悬疑","犯罪","恐怖","青春","励志","战争","文艺","黑色幽默","传记","情色","暴力","音乐","家庭"};
  gridview_adapter gridviewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondfragment_layout, container, false);
 gridView=view.findViewById(R.id.gridView);
gridviewAdapter=new gridview_adapter(myApplication.getContext(),leixingNames);
gridView.setAdapter(gridviewAdapter);
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = leixingNames[(int)id];
goToSearchActivity(name);
    }
});

    return  view;
    }
public  void goToSearchActivity(String kindName){
    Intent intent=new Intent(getActivity(),searchActivity.class);
intent.putExtra("kindNmae",kindName);
startActivity(intent);

    }

}
