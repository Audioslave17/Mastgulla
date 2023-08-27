package com.example.mastgulla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastgulla.adapters.DetailedDailyAdapter;
import com.example.mastgulla.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends Activity {

    RecyclerView recyclerViewMenu;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView roundedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerViewMenu = findViewById(R.id.detailed_rec);
        roundedImageView = findViewById(R.id.detailed_img);

        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));

        detailedDailyModelList = new ArrayList<>();

        detailedDailyModelList.add(new DetailedDailyModel(R.drawable.food1, "Roll", "description", "4.5", "30", "10:00-7:30"));
        detailedDailyModelList.add(new DetailedDailyModel(R.drawable.food2, "Burger", "description", "4.5", "50", "10:00-7:30"));
        detailedDailyModelList.add(new DetailedDailyModel(R.drawable.food3, "Coffee", "description", "4.5", "40", "10:00-7:30"));
        detailedDailyModelList.add(new DetailedDailyModel(R.drawable.food4, "Pizza", "description", "4.5", "70", "10:00-7:30"));

        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerViewMenu.setAdapter(dailyAdapter);

        findViewById(R.id.GoToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,   cart.class));
            }
        });
    }

    public void to_cart(View view) {
        startActivity(new Intent(MenuActivity.this, cart.class));
    }
}