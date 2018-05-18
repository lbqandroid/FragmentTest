package com.capinfo.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment implements View.OnClickListener {

    Button btnOne;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        btnOne = view.findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (getActivity() instanceof OneBtnClickListener) {
            ((OneBtnClickListener) getActivity()).onOneBtnClick();
        }
    }


    public interface OneBtnClickListener {
        void onOneBtnClick();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.main, menu);
    }
}
