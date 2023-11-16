package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MarketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketdetail);

        // 获取并设置市场名称
        String marketName = getIntent().getStringExtra("MarketName");
        TextView marketNameTextView = findViewById(R.id.marketNameTextView);
        marketNameTextView.setText(marketName);

        // 获取供应商卡片视图
        CardView vendorCard1 = findViewById(R.id.vendorCard1);
        CardView vendorCard2 = findViewById(R.id.vendorCard2);
        CardView vendorCard3 = findViewById(R.id.vendorCard3);
        CardView vendorCard4 = findViewById(R.id.vendorCard4);
        CardView vendorCard5 = findViewById(R.id.vendorCard5);

        // 根据从 MainActivity 传递过来的 MarketType 来显示或隐藏供应商卡片
        String marketType = getIntent().getStringExtra("MarketType");
        if (marketType.equals("marketCard1")) {
            setCardVisibility(true, vendorCard1, vendorCard2, vendorCard3);
            setCardVisibility(false, vendorCard4, vendorCard5);
        } else if (marketType.equals("marketCard2")) {
            setCardVisibility(false, vendorCard1, vendorCard2, vendorCard3);
            setCardVisibility(true, vendorCard4, vendorCard5);
        }

        // 为供应商卡片设置点击监听器
        setCardClickListener(vendorCard1, "Luna's Mushroom", R.drawable.mushroom,
                R.array.lunas_mushroom_meats, R.array.lunas_mushroom_dairy, R.array.lunas_mushroom_vegetables);
        setCardClickListener(vendorCard2, "Green Vally Organics", R.drawable.organic,
                R.array.green_valley_organics_meats, R.array.green_valley_organics_dairy, R.array.green_valley_organics_vegetables);
        setCardClickListener(vendorCard3, "Sunny Farm Produce", R.drawable.sunny,
                R.array.sunny_farm_produce_meats, R.array.sunny_farm_produce_dairy, R.array.sunny_farm_produce_vegetables);
        setCardClickListener(vendorCard4, "Bloomfield Flowers", R.drawable.flower,
                R.array.bloomfield_flowers_meats, R.array.bloomfield_flowers_dairy, R.array.bloomfield_flowers_vegetables);
        setCardClickListener(vendorCard5, "Fresh Dairy", R.drawable.diary,
                R.array.fresh_dairy_meats, R.array.fresh_dairy_dairy, R.array.fresh_dairy_vegetables);
    }

    private void setCardVisibility(boolean isVisible, CardView... cards) {
        for (CardView card : cards) {
            card.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }
    }

    private void setCardClickListener(CardView card, final String vendorName, final int imageResId, final int meatsArrayId, final int dairyArrayId, final int vegetablesArrayId) {
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVendorOne(vendorName, imageResId, meatsArrayId, dairyArrayId, vegetablesArrayId);
            }
        });
    }

    private void openVendorOne(String vendorName, int imageResId, int meatsArrayId, int dairyArrayId, int vegetablesArrayId) {
        Intent intent = new Intent(MarketDetailActivity.this, VendorOne.class);
        intent.putExtra("VendorName", vendorName);
        intent.putExtra("ImageResId", imageResId);
        intent.putExtra("MeatsArrayId", meatsArrayId);
        intent.putExtra("DairyArrayId", dairyArrayId);
        intent.putExtra("VegetablesArrayId", vegetablesArrayId);
        startActivity(intent);
    }
}
