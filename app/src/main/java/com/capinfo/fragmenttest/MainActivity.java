package com.capinfo.fragmenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.capinfo.fragmenttest.loadmode.DynamicActivity;
import com.capinfo.fragmenttest.loadmode.StaticActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStatic, btnDynamic, btnFtoA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStatic = findViewById(R.id.btnStatic);
        btnDynamic = findViewById(R.id.btnDynamic);
        btnFtoA = findViewById(R.id.btnFtoA);

        btnStatic.setOnClickListener(this);
        btnDynamic.setOnClickListener(this);
        btnFtoA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStatic:
                intent(StaticActivity.class);
                break;
            case R.id.btnDynamic:
                intent(DynamicActivity.class);
                break;
            case R.id.btnFtoA:
                intent(FragmentToActivity.class);
                break;
        }
    }

    private void intent(Class c) {
        Intent intent = new Intent(MainActivity.this, c);
        startActivity(intent);
    }
}
