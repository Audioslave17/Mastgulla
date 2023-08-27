package com.example.mastgulla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastgulla.adapters.PandaAdapter;
import com.example.mastgulla.adapters.SliderAdapter;
import com.example.mastgulla.models.PandaModel;
import com.example.mastgulla.models.SliderData;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class PandaMartActivity extends AppCompatActivity {

    RecyclerView recyclerViewOffers;
    List<PandaModel> pandaModel;
    PandaAdapter pandaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda_mart);

        getSlider();
        getSpecialOffers();

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PandaMartActivity.this,  MainActivity.class));
            }
        });

        findViewById(R.id.GoToCart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PandaMartActivity.this,   cart.class));
            }
        });
    }


    private void getSlider() {

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(R.drawable.noodles1));
        sliderDataArrayList.add(new SliderData(R.drawable.food2));
        sliderDataArrayList.add(new SliderData(R.drawable.food1));
        sliderDataArrayList.add(new SliderData(R.drawable.chaap));
        sliderDataArrayList.add(new SliderData(R.drawable.grilled_sandwich));
        sliderDataArrayList.add(new SliderData(R.drawable.food3));


        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }

    private void getSpecialOffers() {

        recyclerViewOffers = findViewById(R.id.panda_offers);
        recyclerViewOffers.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerViewOffers.setHasFixedSize(true);

        pandaModel = new ArrayList<>();
        pandaModel.add(new PandaModel (R.drawable. food4, "Pizza",  "4.5", "149"));
        pandaModel.add(new PandaModel (R.drawable.food3, "Cheese Burger", "4.0", "80"));
        pandaModel.add(new PandaModel (R.drawable.roll, "Roll",  "4.3", "30"));
        pandaModel.add(new PandaModel (R.drawable.grilled_sandwich, "Sandwich",  "4.1", "80"));
        pandaModel.add(new PandaModel (R.drawable.shake, "Milkshake",  "4.3", "70"));
        pandaModel.add(new PandaModel (R.drawable.momos, "Momos",  "4.2", "60"));
        pandaModel.add(new PandaModel (R.drawable.noodles1, "Noodles",  "4.0", "70"));

        pandaAdapter = new PandaAdapter(PandaMartActivity.this, pandaModel);
        recyclerViewOffers.setAdapter(pandaAdapter);

    }
}