package com.capinfo.fragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.capinfo.fragmenttest.loadmode.FriendFragment;

/**
 * fragment和activity通信
 */
public class FragmentToActivity extends AppCompatActivity implements
        FragmentOne.OneBtnClickListener, FragmentTwo.TwoBtnClickListener {

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FriendFragment friendFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to);

        // 防止屏幕旋转造成多次创建
        if (savedInstanceState == null) {
            fragmentOne = new FragmentOne();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.flContent, fragmentOne, "ONE");
            transaction.commit();
        }
    }

    @Override
    public void onOneBtnClick() {
        if (fragmentTwo == null) {
            fragmentTwo = new FragmentTwo();
            fragmentTwo.setTwoBtnClickListener(this);
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.flContent, fragmentTwo, "TWO");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onTwoBtnClick() {
        if (friendFragment == null) {
            friendFragment = new FriendFragment();
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(fragmentTwo);
        transaction.add(R.id.flContent, friendFragment, "FRIEND");
//        transaction.replace(R.id.flContent, friendFragment, "FRIEND");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
