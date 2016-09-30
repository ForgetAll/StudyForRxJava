package com.xiasuhuei321.studyforrxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public class SecondActivity extends AppCompatActivity implements TestView {

    private TestPresenter p;
    private Button btTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = new TestPresenter(this);
        btTest = (Button) findViewById(R.id.bt_test);
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.getMessage();
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
                SecondActivity.this.finish();
            }
        });
    }

    @Override
    public void getMessage() {
        Toast.makeText(SecondActivity.this, "内存泄露了？？？", Toast.LENGTH_SHORT).show();
    }
}
