package com.capinfo.fragmenttest.loadmode;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.capinfo.fragmenttest.R;

/**
 * 标题fragment
 */
public class TitleFragment extends Fragment {

    private Button btnBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);

        btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("点击返回");
            }
        });

        return view;
    }

    private void showToast(String tip) {
        Toast.makeText(getActivity(), tip, Toast.LENGTH_SHORT).show();
    }
}
