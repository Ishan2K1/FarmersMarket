package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_login);

        Button loginButton = findViewById(R.id.log_in_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建跳转到 AddNewStoreActivity 的 Intent
                Intent intent = new Intent(LoginActivity.this, AddNewStoreActivity.class);
                startActivity(intent);
            }
        });

//        Button home = findViewById(R.id.home_btn);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentHome = new Intent(MarketDetailActivity.this, MainActivity.class);
//                startActivity(intentHome);
//            }
//        });
    }
}
