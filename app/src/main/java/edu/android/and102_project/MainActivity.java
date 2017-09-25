package edu.android.and102_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements EmoticonFragment.EmoticonListener, FilterFragment.FilterListener { // 인터페이스 구현

    private FrameLayout frameLayout;
    private FragmentManager fm;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.container);
        frameLayout.setVisibility(View.GONE);

  /*      // EmoticonFragment를 FrameLayout에 끼워넣기
        fm = getSupportFragmentManager();
        // EmoticonFragment를 찾음
        fragment = fm.findFragmentById(R.id.container);
        if (fragment == null) {
            // Fragment에 attach시킬 프래그먼트 클래스 인스턴스 생성
            fragment = new EmoticonFragment();
        }


        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();*/

    } // end onCreate


    // 이모티콘 콜백리스너 메소드
    @Override
    public void onTabItemClicked(int tab, int posotion) {
        ImageView iv = (ImageView) findViewById(R.id.imageView);

        iv.setImageResource(EmoticonFragment.IMAGE_EMOTICONS[tab][posotion]);

    }


    // 이벤트핸들러
    public void showEmoticon(View view) {
        // EmoticonFragment를 FrameLayout에 끼워넣기
        fm = getSupportFragmentManager();
        // EmoticonFragment를 찾음
        fragment = fm.findFragmentById(R.id.container);
        if (fragment == null) {
            // Fragment에 attach시킬 프래그먼트 클래스 인스턴스 생성
            fragment = new EmoticonFragment();
        } else {
            fragment = new EmoticonFragment();
            FragmentRepalce(fragment);
        }
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();

       frameLayout.setVisibility(View.VISIBLE);
    }


    // 필터 콜백리스너 메소드
    @Override
    public void onButtonClicked(int id) {
        FragmentManager fm = getSupportFragmentManager();
        FilterFragment fragment = (FilterFragment) fm.findFragmentById(R.id.container);
        fragment.getArguments();
    }


    // 이벤트핸들러
    public void showFilter(View view) {
        // EmoticonFragment를 FrameLayout에 끼워넣기

        fm = getSupportFragmentManager();
        // EmoticonFragment를 찾음
        fragment = fm.findFragmentById(R.id.container);
        if (fragment == null) {
            // Fragment에 attach시킬 프래그먼트 클래스 인스턴스 생성

            fragment = new FilterFragment();
        } else {
            fragment = new FilterFragment();
            FragmentRepalce(fragment);
        }
      //  frameLayout.removeAllViews(); // 프레임 레이아웃의 뷰를 모두 지움

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();

        frameLayout.setVisibility(View.VISIBLE);
    }


    public void FragmentRepalce(Fragment f) {
        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.container);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container, f).commit();

    }




}
