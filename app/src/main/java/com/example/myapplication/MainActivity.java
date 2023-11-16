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
                intent.putExtra("MarketName", "Champaign Farmer's Market");
                startActivity(intent);
            }
        });

        CardView cardView2 = findViewById(R.id.marketCard2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MarketDetailActivity.class);
                intent.putExtra("MarketType", "marketCard2");
                intent.putExtra("MarketName", "Chicago Farmer's Market");
                intent.putExtra("Activity", "MainActivity");
                startActivity(intent);
            }
        });
        Button home_button = (Button) findViewById(R.id.homeBtn);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(MainActivity.this, MainActivity.class);
                intentHome.putExtra("MarketType", "MainActivity");
                intentHome.putExtra("Activity", "MainActivity");
                startActivity(intentHome);
            }
        });
        Button profile_button = (Button) findViewById(R.id.profileBtn);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(MainActivity.this, VendorLogIn.class);
                intentHome.putExtra("Activity", "MainActivity");
                startActivity(intentHome);
            }
        });
    }
}