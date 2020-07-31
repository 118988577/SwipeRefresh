package com.example.swiperefresh;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class MainActivity extends AppCompatActivity {
    private Button mScanDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fragment管理器
        FragmentManager fm = getSupportFragmentManager();
        //找到一个fragment
        Fragment fragment = fm.findFragmentById(R.id.fragment_container2);
        if (fragment == null){
            fragment = new swiperefreshFragment();
            fm.beginTransaction().add(R.id.fragment_container2,fragment).commit();
        }
    }
}
