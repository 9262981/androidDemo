package com.coding25.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        //接收数据;
        Intent intent = getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("F-transferdata-to-Second_Activity",data);

    }
}
