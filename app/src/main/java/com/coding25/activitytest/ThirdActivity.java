package com.coding25.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //根据FL-button9点击进入SL-back 返回数据;
        Button button3=(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.putExtra("data_return","HELLO First_Activity!");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("data_return","HelloBackButton");
        setResult(RESULT_OK,intent);
        finish();
    }
}
