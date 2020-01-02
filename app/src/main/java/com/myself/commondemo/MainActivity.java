package com.myself.commondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.myself.commondemo.contracts.ContractsActivity;
import com.myself.commondemo.phone.CallRecordsActivity;

/**
 * 测试上传更新代码是否成功
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "哎呀,一不小心出现了BUG!", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "哈哈,BUG被修复了!", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.bt_nextactivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });
        findViewById(R.id.bt_threetimesactivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ThreeTimesActivity.class));
            }
        });
        findViewById(R.id.bt_callrecords).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CallRecordsActivity.class));
            }
        });
        findViewById(R.id.bt_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, ContractsActivity.class));
            }
        });
    }
}
