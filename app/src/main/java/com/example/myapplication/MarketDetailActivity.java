package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MarketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketdetail);

        CardView vendorCard1 = findViewById(R.id.vendorCard1);
        CardView vendorCard2 = findViewById(R.id.vendorCard2);
        CardView vendorCard3 = findViewById(R.id.vendorCard3);
        CardView vendorCard4 = findViewById(R.id.vendorCard4);
        CardView vendorCard5 = findViewById(R.id.vendorCard5);

        String marketType = getIntent().getStringExtra("MarketType");
        if (marketType.equals("marketCard1")) {
            setCardVisibility(true, vendorCard1, vendorCard2, vendorCard3);
            setCardVisibility(false, vendorCard4, vendorCard5);
        } else if (marketType.equals("marketCard2")) {
            setCardVisibility(false, vendorCard1, vendorCard2, vendorCard3);
            setCardVisibility(true, vendorCard4, vendorCard5);
        }

        // 设置所有 vendor cards 的点击监听器
        setCardClickListener(vendorCard1);
        setCardClickListener(vendorCard2);
        setCardClickListener(vendorCard3);
        setCardClickListener(vendorCard4);
        setCardClickListener(vendorCard5);
    }

    private void setCardVisibility(boolean isVisible, CardView... cards) {
        for (CardView card : cards) {
            card.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }
    }

    private void setCardClickListener(CardView card) {
        card.setOnClickListener(v -> openVendorOne());
    }

    private void openVendorOne() {
        Intent intent = new Intent(MarketDetailActivity.this, VendorOne.class);
        startActivity(intent);
    }
}
