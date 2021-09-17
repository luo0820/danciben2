package com.example.danciben2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
        Button dan,ciku,xinwen,cha;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dan=findViewById(R.id.dan);
        ciku=findViewById(R.id.ciku);
        xinwen=findViewById(R.id.xinwen);
        cha=findViewById(R.id.cha);
        dan.setOnClickListener(this::onclick);
        ciku.setOnClickListener(this::onclick);
        cha.setOnClickListener(this::onclick);
        xinwen.setOnClickListener(this::onclick);


    }

    private void onclick(View view) {
        switch (view.getId()){
            case R.id.dan:
                refram(new BlankFragment());
                break;
            case  R.id.ciku:
                refram(new ItemFragment());
                break;
        }

    }
//动态切换
    public void refram(Fragment blankFragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fl1,blankFragment);
        transaction.commit();

    }
}