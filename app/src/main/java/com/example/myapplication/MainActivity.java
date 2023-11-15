package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_test);

        CardView cardView1 = findViewById(R.id.Card1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动新的 Activity
                Intent intent = new Intent(MainActivity.this, MarketDetailActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView2 = findViewById(R.id.Card2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动新的 Activity
                Intent intent = new Intent(MainActivity.this, MarketDetailActivity.class);
                startActivity(intent);
            }
        });

        // 为其他 CardViews 设置监听器...
    }
}
