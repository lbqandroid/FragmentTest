package com.capinfo.fragmenttest.loadmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.capinfo.fragmenttest.R;

/**
 * 静态加载fragment
 */
public class StaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);
    }
}
