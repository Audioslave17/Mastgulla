package com.example.mastgulla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastgulla.adapters.AllRestaurantsAdapter;
import com.example.mastgulla.adapters.ExclusiveAdapter;
import com.example.mastgulla.adapters.OffersAdapter;
import com.example.mastgulla.models.AllRestaurantModels;
import com.example.mastgulla.models.ExclusiveModels;
import com.example.mastgulla.models.OffersModels;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView recyclerViewOffers;
    List<OffersModels> offersModels;
    OffersAdapter offersAdapter;

    RecyclerView recyclerViewExclusive;
    List<ExclusiveModels> exclusiveModels;
    ExclusiveAdapter exclusiveAdapter;

    RecyclerView recyclerViewAllRestaurants;
    List<AllRestaurantModels> allRestaurantModels;
    AllRestaurantsAdapter allRestaurantsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        recyclerViewExclusive = findViewById(R.id.rec_exc);
        recyclerViewExclusive.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerViewExclusive.setHasFixedSize(true);

        exclusiveModels = new ArrayList<>();
        exclusiveModels.add(new ExclusiveModels (R.drawable. zaika, "Zaika", "NC-4 Hostel", "4.5"));
        exclusiveModels.add(new ExclusiveModels (R.drawable.punjabirasoi, "Punjabi Rasoi", "Backside Hostels", "4.0"));
        exclusiveModels.add(new ExclusiveModels (R.drawable.rocknroll, "Rock N Roll", "NC-3 Hostel", "4.3"));
        exclusiveModels.add(new ExclusiveModels (R.drawable.instafood, "Insta Food", "Backside Hostels", "4.1"));

        exclusiveAdapter = new ExclusiveAdapter(RestaurantActivity.this, exclusiveModels);
        recyclerViewExclusive.setAdapter(exclusiveAdapter);

        recyclerViewAllRestaurants = findViewById(R.id.rec_all_res);
        recyclerViewAllRestaurants.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerViewAllRestaurants.setHasFixedSize(true);

        allRestaurantModels = new ArrayList<>();
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.creativefoods, "Creative Foods", "10:00-21:00", "4.8"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.samosaexpress, "Samosa Express", "10:00-21:00", "3.9"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.chaitheka, "Chai Theka", "10:00-21:00", "4.2"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.maggihotspot, "Maggi Hotspot", "10:00-21:00", "4.0"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.crunchybite, "Crunchy Bite", "10:00-21:00", "4.0"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.chefonfire, "Chef's On Fire", "10:00-21:00", "3.9"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.nescafe, "Nescafe", "10:00-21:00", "3.8"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.tj, "Tj's", "10:00-21:00", "4.0"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.mynus360, "Mynus 360", "10:00-21:00", "3.5"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.lordsfood, "Lords Food", "10:00-21:00", "3.7"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.buddies, "Buddies Multi Cuisine", "10:00-21:00", "4.1"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.vikas, "Vikas Confectionery", "10:00-21:00", "4.0"));
        allRestaurantModels.add(new AllRestaurantModels (R.drawable.horseshoe, "Horse Shoe Cafe", "10:00-21:00", "4.2"));

        allRestaurantsAdapter = new AllRestaurantsAdapter(RestaurantActivity.this , allRestaurantModels);
        recyclerViewAllRestaurants.setAdapter(allRestaurantsAdapter);

        findViewById(R.id.GoToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantActivity.this,   cart.class));
            }
        });

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestaurantActivity.this,  MainActivity.class));
            }
        });

    }

    public void to_exclusive(View view) {
        startActivity(new Intent(RestaurantActivity.this, PandaMartActivity.class));
    }


}