package com.capinfo.fragmenttest.loadmode;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.capinfo.fragmenttest.R;

/**
 * 动态加载fragment
 */
public class DynamicActivity extends AppCompatActivity implements View.OnClickListener {

    private ContentFragment contentFragment;
    private FriendFragment friendFragment;

    private TextView tvOne, tvTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        tvOne = findViewById(R.id.tvOne);
        tvTwo = findViewById(R.id.tvTwo);

        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        setDefaultFragment();
    }

    // 设置默认fragment
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        contentFragment = new ContentFragment();
        transaction.replace(R.id.flContent, contentFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId()) {
            case R.id.tvOne:
                if (contentFragment == null) {
                    contentFragment = new ContentFragment();
                }
                transaction.replace(R.id.flContent, contentFragment);
                break;
            case R.id.tvTwo:
                if (friendFragment == null) {
                    friendFragment = new FriendFragment();
                }
                transaction.replace(R.id.flContent, friendFragment);
                break;
        }
        transaction.commit();
    }
}
