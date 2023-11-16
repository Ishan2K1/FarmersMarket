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
                startActivity(intentHome);
            }
        });
        Button profile_button = (Button) findViewById(R.id.profileBtn);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(VendorLogIn.this, VendorLogIn.class);
                startActivity(intentHome);
            }
        });
        Button back_button = (Button) findViewById(R.id.backBtn);
    }
}