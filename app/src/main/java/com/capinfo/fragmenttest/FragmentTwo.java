package com.capinfo.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment implements View.OnClickListener {

    Button btnTwo;

    TwoBtnClickListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        btnTwo = view.findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onTwoBtnClick();
        }
    }

    public void setTwoBtnClickListener(TwoBtnClickListener listener) {
        this.listener = listener;
    }

    public interface TwoBtnClickListener {
        void onTwoBtnClick();

    }
}
