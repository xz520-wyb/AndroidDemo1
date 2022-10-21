package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment fragment1,fragment2,fragment3,fragment4;

    private FragmentManager manager;
    FragmentTransaction  transaction;

    private LinearLayout tab_wx,tab_frd,tab_discovery,tab_me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab_wx=findViewById(R.id.tab_vx);
        tab_frd=findViewById(R.id.tab_frd);
        tab_discovery=findViewById(R.id.tab_contact);
        tab_me=findViewById(R.id.tab_user);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        manager=getSupportFragmentManager();
        initFragment();


        hideFragment();
        initEvent();
    }

    private void initFragment(){
        transaction=manager.beginTransaction()
                .add(R.id.id_content,fragment1)
                .add(R.id.id_content,fragment2)
                .add(R.id.id_content,fragment3)
                .add(R.id.id_content,fragment4);
        transaction.commit();
    }

    private void selectFragment(int i) {
        hideFragment();
        switch(i){
            case 0:
                transaction.show(fragment1);
                break;
            case 1:
                transaction.show(fragment2);
                break;
            case 2:
                transaction.show(fragment3);
                break;
            case 3:
                transaction.show(fragment4);
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.tab_vx:
                selectFragment(0);
                break;
            case R.id.tab_frd:
                selectFragment(1);
                break;
            case R.id.tab_contact:
                selectFragment(2);
                break;
            case R.id.tab_user:
                selectFragment(3);
                break;
            default:
                break;
        }
    }

    private void hideFragment() {
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();
    }


    private void initEvent() {
        tab_wx.setOnClickListener(this);
        tab_frd.setOnClickListener(this);
        tab_discovery.setOnClickListener(this);
        tab_me.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cjy","这是MainActivity生命周期:onStart...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cjy","这是MainActivity生命周期:onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cjy","这是MainActivity生命周期:onStop...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("cjy","这是MainActivity生命周期:onRestart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cjy","这是MainActivity生命周期:onResume...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cjy","这是MainActivity生命周期:onDestroy...");
    }
}