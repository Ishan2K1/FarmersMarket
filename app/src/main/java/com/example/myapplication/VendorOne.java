package com.example.farmersmarket;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;


import androidx.appcompat.app.AppCompatActivity;

public class VendorOne extends AppCompatActivity {
    boolean click = true;
    private ImageButton fbBtn;
    private ImageButton instBtn;
    private ImageButton twitBtn;
    private ImageButton emBtn;
    private ImageButton gaBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_one);

        ImageView imageView = (ImageView) findViewById(R.id.myImageView);
        ImageButton descriptionBtn = (ImageButton) findViewById(R.id.description);


//        PopupWindow popUp = new PopupWindow(this);
//        LinearLayout layout = new LinearLayout(this);
//        LinearLayout mainLayout = new LinearLayout(this);
//        TextView tv = new TextView(this);
//        Button but = new Button(this);
//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (click) {
//                    popUp.showAtLocation(layout, Gravity.CENTER, 0, 0);
//                    popUp.update(50, 50, 300, 80);
//                    click = false;
//                } else {
//                    popUp.dismiss();
//                    click = true;
//                }
//            }
//        });

//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        tv.setText("Hi this is a sample text for popup window");
//        layout.addView(tv, params);
//        popUp.setContentView(layout);
//        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
//        mainLayout.addView(but, params);
//        setContentView(mainLayout);

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

        Spinner spinner_one = findViewById(R.id.spinner1);
        Spinner spinner_two = findViewById(R.id.spinner2);
        Spinner spinner_three = findViewById(R.id.spinner3);
        Spinner spinner_four = findViewById(R.id.spinner4);
        Spinner spinner_five = findViewById(R.id.spinner5);

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
