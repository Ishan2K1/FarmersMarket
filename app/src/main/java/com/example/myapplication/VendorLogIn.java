package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VendorLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 引用您的布局文件
        setContentView(R.layout.vendor_login);

        Button log_in_button = findViewById(R.id.log_in_button);

        log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorLogIn.this, AddEvent.class);
                startActivity(intent);
            }
        });

    }
}

