package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class VendorOne extends AppCompatActivity {
    boolean click = true;
    private ImageButton fbBtn;
    private ImageButton instBtn;
    private ImageButton twitBtn;
    private ImageButton emBtn;
    private ImageButton gaBtn;

    private void setSpinnerAdapter(int spinnerId, int arrayId, String title) {
        if (arrayId != 0) {
            Spinner spinner = findViewById(spinnerId);
            String[] itemsArray = getResources().getStringArray(arrayId);
            VendorOneSpinner adapter = new VendorOneSpinner(this, android.R.layout.simple_spinner_item, itemsArray, title);
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_one);

        // 获取传递过来的供应商名称和图片资源 ID
        String vendorName = getIntent().getStringExtra("VendorName");
        int imageResId = getIntent().getIntExtra("ImageResId", 0);
        int meatsArrayId = getIntent().getIntExtra("MeatsArrayId", 0);
        int dairyArrayId = getIntent().getIntExtra("DairyArrayId", 0);
        int vegetablesArrayId = getIntent().getIntExtra("VegetablesArrayId", 0);

        // 设置供应商名称
        TextView vendorNameTextView = findViewById(R.id.VendorNameTextView);
        vendorNameTextView.setText(vendorName);

        // 设置图片
        ImageView imageView = findViewById(R.id.myImageView);
        if (imageResId != 0) {
            imageView.setImageResource(imageResId);
        }

        setSpinnerAdapter(R.id.spinner1_meats, meatsArrayId, "Meats");
        setSpinnerAdapter(R.id.spinner2_dairy, dairyArrayId, "Dairy");
        setSpinnerAdapter(R.id.spinner3_vegetables, vegetablesArrayId, "Vegetables");



        fbBtn = (ImageButton) findViewById(R.id.facebook_btn);
        instBtn = (ImageButton) findViewById(R.id.insta_btn);
        twitBtn = (ImageButton) findViewById(R.id.twitter_btn);
        emBtn = (ImageButton) findViewById(R.id.email_btn);
        gaBtn = (ImageButton) findViewById(R.id.gallery_btn);
        fbBtn.setOnClickListener(this::onClick);
        instBtn.setOnClickListener(this::onClick);
        twitBtn.setOnClickListener(this::onClick);
        emBtn.setOnClickListener(this::onClick);
        gaBtn.setOnClickListener(this::onClick);

        Button home_button= findViewById(R.id.home_btn);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(VendorOne.this, MainActivity.class);
                intentHome.putExtra("Activity", "VendorOne");
                startActivity(intentHome);
            }
        });
//        profile_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentHome = new Intent(VendorOne.this, VendorLogin.class);
//                intentHome.putExtra("Activity", "VendorOne");
//                startActivity(intentHome);
//            }
//        });
//        Button back_button = (Button) findViewById(R.id.backBtn);
//        String previousActivity = getIntent().getStringExtra("Activity");
//        if (previousActivity.equals("MarketDetailActivity")) {
//            back_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent back = new Intent(VendorOne.this, MarketDetailActivity.class);
//                    startActivity(back);
//                }
//            });
//        } else if (previousActivity.equals("VendorLogIn")) {
//            back_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent back = new Intent(VendorOne.this, VendorLogin.class);
//                    startActivity(back);
//                }
//            });
//        } else if (previousActivity.equals("VendorOne")) {
//            back_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent back = new Intent(VendorOne.this, VendorOne.class);
//                    startActivity(back);
//                }
//            });
//        } else {
//            back_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent back = new Intent(VendorOne.this, MainActivity.class);
//                    startActivity(back);
//                }
//            });
//        }
        Button backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
        Button home = findViewById(R.id.home_btn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(VendorOne.this, MainActivity.class);
                startActivity(intentHome);
            }
        });
    }



    public void onClick(View v) {
        if (v.getId() == R.id.facebook_btn) {
            Uri fbPage = Uri.parse("https://www.facebook.com/");
            Intent intent1 = new Intent();
            intent1.setAction(Intent.ACTION_VIEW);
            intent1.setData(fbPage);
            Intent chooser1 = Intent.createChooser(intent1, "OPEN WITH");
            startActivity(chooser1);
        } else if (v.getId() == R.id.insta_btn) {
            Uri instPage = Uri.parse("https://www.instagram.com/");
            Intent intent2 = new Intent();
            intent2.setAction(Intent.ACTION_VIEW);
            intent2.setData(instPage);
            Intent chooser2 = Intent.createChooser(intent2, "OPEN WITH");
            startActivity(chooser2);
        } else if (v.getId() == R.id.twitter_btn) {
            Uri twitPage = Uri.parse("https://twitter.com/?lang=en");
            Intent intent3 = new Intent();
            intent3.setAction(Intent.ACTION_VIEW);
            intent3.setData(twitPage);
            Intent chooser3 = Intent.createChooser(intent3, "OPEN WITH");
            startActivity(chooser3);
        }


    }
}
