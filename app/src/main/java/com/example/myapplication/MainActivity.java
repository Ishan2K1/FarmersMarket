package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_test);

        CardView cardView1 = findViewById(R.id.marketCard1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketDetailActivity.class);
                intent.putExtra("MarketType", "marketCard1");
                intent.putExtra("MarketName", "Champaign Farmer Market");
                startActivity(intent);
            }
        });

        CardView cardView2 = findViewById(R.id.marketCard2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketDetailActivity.class);
                intent.putExtra("MarketType", "marketCard2");
                intent.putExtra("MarketName", "Chicago Farmer Market");
                startActivity(intent);
            }
        });

        // 获取 "Add a New Market" 按钮
        Button addNewStoreButton = findViewById(R.id.addnewmarketbut);
        addNewStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建跳转到 LoginActivity 的 Intent
                Intent intent = new Intent(MainActivity.this, VendorLogin.class);
                startActivity(intent);
            }
        });
        Button home = findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        });
    }
}