package com.example.mastgulla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        button = findViewById(R.id.registerbutton);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(RegistrationActivity.this, "Registered", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}