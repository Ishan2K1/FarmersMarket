package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MarketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 引用您的布局文件
        setContentView(R.layout.activity_marketdetail);

        Button new_market_button = findViewById(R.id.addNewMarketButton);

        new_market_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketDetailActivity.this, VendorLogIn.class);
                startActivity(intent);
            }
        });
    }
}

