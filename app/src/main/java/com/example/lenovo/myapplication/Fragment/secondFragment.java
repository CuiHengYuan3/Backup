package com.example.lenovo.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.lenovo.myapplication.Activity.detailActivity;
import com.example.lenovo.myapplication.Activity.searchActivity;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.gridview_adapter;

import static android.support.constraint.Constraints.TAG;

public class secondFragment extends Fragment  {

    private GridView gridView;
   private  GridView gridView2;
    private EditText editText;
    private Button button;
    private String[] leixingNames = {"剧情", "爱情", "喜剧", "科幻", "动作", "悬疑", "犯罪", "恐怖", "青春", "励志", "战争", "文艺", "黑色幽默", "传记", "情色", "暴力", "音乐", "家庭"};
   private  String [] placeName={"大陆","美国","香港","台湾","日本","韩国","英国","法国","德国","意大利","印度","泰国","俄罗斯","伊朗","加拿大","澳大利亚","爱尔兰","瑞典","巴西","丹麦"};
    gridview_adapter gridviewAdapter;
gridview_adapter gridviewAdapter2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondfragment_layout, container, false);
     editText=view.findViewById(R.id.editText);
//        editText.setImeOptions(EditorInfo.IME_ACTION_SEND);
        button=view.findViewById(R.id.Ssearch_button);
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String name= String.valueOf(editText.getText());
             goToSearchActivity(name);

         }
     });
  gridView2=view.findViewById(R.id.gridView2);
        gridView = view.findViewById(R.id.gridView);
        gridviewAdapter = new gridview_adapter(myApplication.getContext(), leixingNames);
        gridView.setAdapter(gridviewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = leixingNames[(int) id];
                goToSearchActivity(name);
            }
        });
gridviewAdapter2=new gridview_adapter(myApplication.getContext(),placeName);
gridView2.setAdapter(gridviewAdapter2);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = placeName[(int) id];
                goToSearchActivity(name);
            }
        });





        return view;
    }

    public void goToSearchActivity(String kindName) {
        Intent intent = new Intent(getActivity(), searchActivity.class);
        intent.putExtra("kindNmae", kindName);
        startActivity(intent);

    }


}
