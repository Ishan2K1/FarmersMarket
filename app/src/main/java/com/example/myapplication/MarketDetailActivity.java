package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MarketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketdetail);

        // Get market name
        String marketName = getIntent().getStringExtra("MarketName");
        TextView marketNameTextView = findViewById(R.id.marketNameTextView);
        marketNameTextView.setText(marketName);

        // Get vendor info cards
        CardView vendorCard1 = findViewById(R.id.vendorCard1);
        CardView vendorCard2 = findViewById(R.id.vendorCard2);
        CardView vendorCard3 = findViewById(R.id.vendorCard3);
        CardView vendorCard4 = findViewById(R.id.vendorCard4);
        CardView vendorCard5 = findViewById(R.id.vendorCard5);

        // Set up visiblity according to MarketType obtained from MainActivity
        String marketType = getIntent().getStringExtra("MarketType");
        if (marketType.equals("marketCard1")) {
            setCardVisibility(true, vendorCard1, vendorCard2, vendorCard3);
            setCardVisibility(false, vendorCard4, vendorCard5);
        } else if (marketType.equals("marketCard2")) {
            setCardVisibility(false, vendorCard1, vendorCard2, vendorCard3);
            setCardVisibility(true, vendorCard4, vendorCard5);
        }

        // Set up card click listener to vendor cards
        setCardClickListener(vendorCard1, "Luna's Mushroom", R.drawable.mushroom,
                R.array.lunas_mushroom_pop_products, R.array.lunas_mushroom_meats, R.array.lunas_mushroom_dairy, R.array.lunas_mushroom_vegetables);
        setCardClickListener(vendorCard2, "Green Vally Organics", R.drawable.organic,
                R.array.green_valley_organics_pop_products, R.array.green_valley_organics_meats, R.array.green_valley_organics_dairy, R.array.green_valley_organics_vegetables);
        setCardClickListener(vendorCard3, "Sunny Farm Produce", R.drawable.sunny,
                R.array.sunny_farm_produce_pop_products, R.array.sunny_farm_produce_meats, R.array.sunny_farm_produce_dairy, R.array.sunny_farm_produce_vegetables);
        setCardClickListener(vendorCard4, "Bloomfield Flowers", R.drawable.flower,
                R.array.bloomfield_flowers_pop_products, R.array.bloomfield_flowers_meats, R.array.bloomfield_flowers_dairy, R.array.bloomfield_flowers_vegetables);
        setCardClickListener(vendorCard5, "Fresh Dairy", R.drawable.diary,
                R.array.fresh_dairy_pop_products, R.array.fresh_dairy_meats, R.array.fresh_dairy_dairy, R.array.fresh_dairy_vegetables);


        // No add new store anymore
        Button addNewStoreButton = findViewById(R.id.addNewMarketButton);
        addNewStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketDetailActivity.this, NoLoginActivity.class);
                startActivity(intent);
            }
        });



        Button backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

        Button home = findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(MarketDetailActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        });
    }

    private void setCardVisibility(boolean isVisible, CardView... cards) {
        for (CardView card : cards) {
            card.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }
    }

    private void setCardClickListener(CardView card, final String vendorName, final int imageResId, final int popArrayId, final int meatsArrayId, final int dairyArrayId, final int vegetablesArrayId) {
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewVendorDetail(vendorName, imageResId, popArrayId, meatsArrayId, dairyArrayId, vegetablesArrayId);
            }
        });
    }

    private void openNewVendorDetail(String vendorName, int imageResId, int popArrayId, int meatsArrayId, int dairyArrayId, int vegetablesArrayId) {
        Intent intent = new Intent(MarketDetailActivity.this, NewVendorDetailActivity.class);
        intent.putExtra("VendorName", vendorName);
        intent.putExtra("ImageResId", imageResId);
        intent.putExtra("popArrayId", popArrayId);
        intent.putExtra("MeatsArrayId", meatsArrayId);
        intent.putExtra("DairyArrayId", dairyArrayId);
        intent.putExtra("VegetablesArrayId", vegetablesArrayId);
        startActivity(intent);
    }
}