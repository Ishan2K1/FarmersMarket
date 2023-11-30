package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    RecyclerView marketList;
    Spinner distanceSpinner, timeSpinner;
    List<MarketModel> marketArray = new ArrayList<>(), filteredMarketArray = new ArrayList<>();
    ListAdapter listAdapter;
    GoogleMap map;

    int distance = 100, time = 100;

    public void updateMap() {
        if (map == null) {
            return;
        }
        map.clear();
        List<MarketModel> markets = listAdapter.getFilteredList();
        for(MarketModel marketModel: markets) {
            LatLng loc = new LatLng(marketModel.getLatitude(), marketModel.getLongitude());
            map.addMarker(new MarkerOptions().position(loc).title(marketModel.getName()));
            map.moveCamera(CameraUpdateFactory.newLatLng(loc));
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            AssetManager am = this.getAssets();
            InputStream is = am.open("MarketData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_test);

        // marshall data into list
        Gson gson = new Gson();
        marketArray = gson.fromJson(loadJSONFromAsset(), new TypeToken<List<MarketModel>>() {}.getType());
        Log.d("listsize", String.valueOf(marketArray.size()));
        filteredMarketArray.addAll(marketArray);

        // display in recycler view
        marketList = findViewById(R.id.marketlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        marketList.setLayoutManager(linearLayoutManager);

        listAdapter = new ListAdapter(this, filteredMarketArray);
        marketList.setAdapter(listAdapter);

        // update based on distance filter
        distanceSpinner = findViewById(R.id.distanceSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.distances,
                android.R.layout.simple_spinner_item
        );

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        distanceSpinner.setAdapter(adapter);
        distanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                distance = Integer.valueOf((String) parent.getItemAtPosition(position));
                listAdapter.getFilter().filter((CharSequence) parent.getItemAtPosition(position)+","+time);
                updateMap();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // update based on time filter
        timeSpinner = findViewById(R.id.timeSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.distances,
                android.R.layout.simple_spinner_item
        );

        // Specify the layout to use when the list of choices appears.
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        timeSpinner.setAdapter(adapter2);
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = Integer.valueOf((String) parent.getItemAtPosition(position));
                listAdapter.getFilter().filter(distance + "," + (CharSequence) parent.getItemAtPosition(position));
                updateMap();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        distanceSpinner.setSelection(7); // hard coded to 100
        timeSpinner.setSelection(7); // hard coded to 100

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
    }
}
