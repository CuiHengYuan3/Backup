package com.example.lenovo.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;

public class secondFragment extends Fragment implements View.OnClickListener {
    //    SearchView searchView;
  private EditText editText;
   private Button sentButton;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.T1:

}
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondfragment_layout, container, false);
sentButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     String kinds= String.valueOf(editText.getText());

    }
});



        //    searchView=view.findViewById(R.id.searchView);
//   // searchView.setImeOptions(0);
//searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//    @Override
//    public boolean onQueryTextSubmit(String s) {
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextChange(String s) {
//        return false;
//    }
//});


        return view;
    }


}