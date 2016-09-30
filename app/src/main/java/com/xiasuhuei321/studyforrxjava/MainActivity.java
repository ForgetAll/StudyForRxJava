package com.xiasuhuei321.studyforrxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TestView {

    private Button btTest;
    private TestPresenter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = new TestPresenter(this);
        btTest = (Button) findViewById(R.id.bt_test);
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.getMessage();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                MainActivity.this.finish();
            }
        });
    }

    @Override
    public void getMessage() {
        Toast.makeText(MainActivity.this, "内存泄露了？？？", Toast.LENGTH_SHORT).show();
    }
}
