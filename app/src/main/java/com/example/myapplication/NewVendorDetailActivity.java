package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.adapters.ProductAdapter;
import com.example.myapplication.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NewVendorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_vendor_detail);

        // Get vendor nane, vendor image, and products arrays from MarketDetailActivity
        String vendorName = getIntent().getStringExtra("VendorName");
        int imageResId = getIntent().getIntExtra("ImageResId", 0);
        int popArrayId = getIntent().getIntExtra("popArrayId", 0);
        int meatsArrayId = getIntent().getIntExtra("MeatsArrayId", 0);
        int dairyArrayId = getIntent().getIntExtra("DairyArrayId", 0);
        int vegetablesArrayId = getIntent().getIntExtra("VegetablesArrayId", 0);


        // Set up store name and logo
        TextView vendorNameTextView = findViewById(R.id.vendorNameTextView);
        vendorNameTextView.setText(vendorName);
        ImageView imageView = findViewById(R.id.storeLogo);
        if (imageResId != 0) {
            imageView.setImageResource(imageResId);
        }

        // Set up ViewPager2 and Adaptor
        setupViewPager(R.id.popViewPager, popArrayId);
        setupViewPager(R.id.meatsViewPager, meatsArrayId);
        setupViewPager(R.id.dairyViewPager, dairyArrayId);
        setupViewPager(R.id.vegetablesViewPager, vegetablesArrayId);

        ImageButton imageButton = findViewById(R.id.moreinfo);
        Dialog dialog = new Dialog(this);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.popup);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        });

        Button backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
        FloatingActionButton home = findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override             public void onClick(View view) {
                Intent intentHome = new Intent(NewVendorDetailActivity.this, MainActivity.class);
                startActivity(intentHome);
            }
        });

    }

    private void setupViewPager(int viewPagerId, int arrayResId) {
        ViewPager2 viewPager = findViewById(viewPagerId);
        String[] array = getResources().getStringArray(arrayResId);
        ProductAdapter adapter = new ProductAdapter(createProductListFromResource(array));
        viewPager.setAdapter(adapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        int horizontalMargin = 1;
        viewPager.addItemDecoration(new MarginItemDecoration(horizontalMargin));
    }

    private List<Product> createProductListFromResource(String[] productArray) {
        List<Product> productList = new ArrayList<>();
        for (String item : productArray) {
            String[] parts = item.split("\\|");
            if (parts.length == 4) {

                String name = parts[0].trim();
                String price = parts[1].trim();
                int imageResId = getResources().getIdentifier(parts[2].trim(), "drawable", getPackageName());
                String description = parts[3].trim();
                productList.add(new Product(name, price, imageResId, description));

                Log.d("name", name);
                Log.d("price", price);
                Log.d("imageResId", String.valueOf(imageResId));
                Log.d("desc", description);

            }
        }
        return productList;
    }
}
