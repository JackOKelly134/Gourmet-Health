package com.example.gormethealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class recipespage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipespage);

        Button lunchrecipes = findViewById(R.id.lunchrecipes);

        // Set up an onClickListener for the "lunch" button
        lunchrecipes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(recipespage.this, lunchrecipes.class);
                startActivity(intent);
            }
        });
    }
}