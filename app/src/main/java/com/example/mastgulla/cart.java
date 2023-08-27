package com.example.mastgulla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastgulla.adapters.CartAdapter;
import com.example.mastgulla.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CartModel> list;
    CartAdapter cartAdapter;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.add(new CartModel(R.drawable. food4, "Pizza", "99", "4.5"));
        list.add(new CartModel(R.drawable. food3, "Burger", "50", "4.0"));
        list.add(new CartModel(R.drawable. noodles, "Noodles", "70", "4.1"));
        list.add(new CartModel(R.drawable. milkshake, "Milkshake", "60", "4.3"));
        list.add(new CartModel(R.drawable. momos, "Momos", "60", "4.4"));

        cartAdapter = new CartAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(cartAdapter);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopUpWindow();
            }

            private void openPopUpWindow() {
                Intent popUpWindow = new Intent(cart.this,popUpWindow.class);
                startActivity(popUpWindow);
            }
        });
    }
}