package com.coding25.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
//        button1 Toast
        Button button1 = (Button) findViewById(R.id.button1);
//        button2 finish
        Button button2 = (Button) findViewById(R.id.button2);
//        button4 firstToSecond
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked button1",
                        Toast.LENGTH_LONG).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity!";//传数据
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data",data);//传数据
                startActivity(intent);

            }
        });
//        隐式intent
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.coding25.activitytest.ACTION_START");
                startActivity(intent);

            }
        });
//        自定义category
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.coding25.activitytest.ACTION_START");
                intent.addCategory("com.coding25.activitytest.My_CATEGORY");
                startActivity(intent);

            }
        });
//        更多隐式intent--进入浏览器页面
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.freekeer.com"));
                startActivity(intent);

            }
        });
//        更多隐式intent--进入拨号页面
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10010"));
                startActivity(intent);

            }
        });
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you clicked add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you clicked remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //button9 -FtoS- back
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("ThirdActivity",returnedData);
                }
                break;
            default:
        }
    }
}
