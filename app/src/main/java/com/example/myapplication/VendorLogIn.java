package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class VendorLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_login);

        Button home_button= findViewById(R.id.home_btn);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(VendorLogIn.this, MainActivity.class);
                intentHome.putExtra("Activity", "VendorLogIn");
                startActivity(intentHome);
            }
        });
        Button profile_button = (Button) findViewById(R.id.profileBtn);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfile = new Intent(VendorLogIn.this, VendorLogIn.class);
                intentProfile.putExtra("Activity", "VendorLogIn");
                startActivity(intentProfile);
            }
        });
        Button back_button = (Button) findViewById(R.id.backBtn);
        String previousActivity = getIntent().getStringExtra("Activity");
        if (previousActivity.equals("MarketDetailActivity")) {
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent back = new Intent(VendorLogIn.this, MarketDetailActivity.class);
                    startActivity(back);
                }
            });
        } else if (previousActivity.equals("VendorLogIn")) {
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent back = new Intent(VendorLogIn.this, VendorLogIn.class);
                    startActivity(back);
                }
            });
        } else if (previousActivity.equals("VendorOne")) {
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent back = new Intent(VendorLogIn.this, VendorOne.class);
                    startActivity(back);
                }
            });
        } else {
            back_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent back = new Intent(VendorLogIn.this, MainActivity.class);
                    startActivity(back);
                }
            });
        }
    }
}