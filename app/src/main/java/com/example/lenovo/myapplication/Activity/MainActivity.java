package com.example.lenovo.myapplication.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.myapplication.Fragment.firstFragment;
import com.example.lenovo.myapplication.Fragment.secondFragment;
import com.example.lenovo.myapplication.Fragment.thirdFragment;
import com.example.lenovo.myapplication.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private LinearLayout linearLayout_first;
    private LinearLayout linearLayout_second;
    private LinearLayout linearLayout_third;
    private ImageView imageView_first;
    private ImageView imageView_second;
    private ImageView imageView_third;
    private TextView textView_first;
    private TextView textView_second;
    private TextView textView_third;
    private FragmentManager fragmentManager;
    private static String currentTAG = null;
    private static final String firstTAG = "firstTAG";
    private static final String secondTAG = "secondTAG";
    private static final String thirdTAG = "thirdTAG";
    private static final String  myTextTAG = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //////////////////////////////////////////////////////////
        Log.d("data", "onCreate:1 ");
        initView();
        Log.d("data", "onCreate:2 ");
        currentTAG=firstTAG;
        Log.d("data", "onCreate:3 ");
        changeOrInitFragment(new firstFragment());
        Log.d("data", "onCreate:4 ");

    }

    public void initView() {
        linearLayout_first =  findViewById(R.id.L正在热映);
        linearLayout_second = findViewById(R.id.L查找);
        linearLayout_third = findViewById(R.id.LTop250);
        imageView_first = findViewById(R.id.I正在上映);
        imageView_second = findViewById(R.id.I查找影片);
        imageView_third = findViewById(R.id.ITop250);
        textView_first = findViewById(R.id.T正在热映);
        textView_second = findViewById(R.id.T查找影片);
        textView_third = findViewById(R.id.TTop250);
 linearLayout_first.setOnClickListener(this);
    linearLayout_second.setOnClickListener(this);
    linearLayout_third.setOnClickListener(this);
imageView_first.setImageResource(R.drawable.shangyinselected);
    textView_first.setTextColor(getResources().getColor(R.color.red));//???????????
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.L正在热映:
                ChangeFragentByTAG(firstTAG);
                break;
            case R.id.L查找:
                imageView_second.setImageResource(R.drawable.searchselected);
                textView_first.setTextColor(getResources().getColor(R.color.red));
                ChangeFragentByTAG(secondTAG);
                break;
            case R.id.LTop250:
                imageView_first.setImageResource(R.drawable.shangyinselected);
                textView_first.setTextColor(getResources().getColor(R.color.red));
                ChangeFragentByTAG(thirdTAG);
                break;
            default:
                break;
        }
    }
public void setDefault(){
        imageView_first.setImageResource(R.drawable.shangyindefault);
textView_first.setTextColor(getResources().getColor(R.color.black));
    imageView_second.setImageResource(R.drawable.searchdefault);
    textView_second.setTextColor(getResources().getColor(R.color.black));
    imageView_third.setImageResource(R.drawable.topdefault);
    textView_third.setTextColor(getResources().getColor(R.color.black));


    }

    public void ChangeFragentByTAG(String TAG) {

         if (TAG == currentTAG) {
            //什么也不做
        } else if (TAG == firstTAG) {
            currentTAG=firstTAG;
           setDefault();
             imageView_first.setImageResource(R.drawable.shangyinselected);
             textView_first.setTextColor(getResources().getColor(R.color.red));
           Fragment fragment = new firstFragment();
             changeOrInitFragment(fragment);
        } else if (TAG == secondTAG) {
            currentTAG=secondTAG;
             setDefault();
             imageView_second.setImageResource(R.drawable.searchselected);
             textView_second.setTextColor(getResources().getColor(R.color.red));

             Fragment fragment = new secondFragment();
             changeOrInitFragment(fragment);
        } else if (TAG == thirdTAG) {
           currentTAG=thirdTAG;
             setDefault();
             imageView_third.setImageResource(R.drawable.topselected);
             textView_third.setTextColor(getResources().getColor(R.color.red));

             Fragment fragment = new thirdFragment();
            changeOrInitFragment(fragment);

         }
    }

    private void changeOrInitFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.beReplaced, fragment);
        fragmentTransaction.commit();
    }


    //    currentTAG=firstTAG;
//FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
//fragmentTransaction.replace(R.id.first_fragment,)


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
