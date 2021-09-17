package com.example.danciben2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class BlankFragment extends Fragment {

    View root;
    TextView te;
    Button b1;
    SQLiteOpenHelper helper;
    SQLiteDatabase db;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(root==null) {
            root = inflater.inflate(R.layout.fragment_blank, container, false);
        }

        try{
            helper= new Connect(getContext(), "dan_ci_ben",null,1);

        } catch (Exception e){
        }
        b1=root.findViewById(R.id.but1);
        te=root.findViewById(R.id.te1);
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                db= helper.getReadableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("danci","sincere");
//                values.put("fanyi","adj. 真诚的；诚挚的；真实的");
//                values.put("liju","He seemed sincere enough when he said he wanted to help.他表示愿意帮忙，样子很真诚。《牛津词典》 He had a way of sounding so sincere. It made me warm and tingly.他的话听起来如此真诚。这让我觉得温暖而舒心。《柯林斯英汉双解大词典》 " +
//                        "Primo de Rivera himself was a benevolent and sincere paternalist.普里莫&middot;德里韦拉本人是个仁慈而真诚的家长式人物。");
//                db.insert("user", null, values);
//                Toast.makeText(getContext(),"增加单词成功了！！",Toast.LENGTH_LONG).show();
                String sql="select * from user";
               Cursor cursor = db.rawQuery(sql,null);
                String data="";
                while(cursor.moveToNext()) {
                   data = cursor.getString(cursor.getColumnIndex("danci"));
                }
                te.setText(data);
            }
        });


        return root;
    }
}