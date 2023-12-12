package com.example.gormethealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lunchrecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunchrecipes);

        Button dinnerpage = findViewById(R.id.dinnerpage);
        //Button backbutton = findViewById(R.id.backbutton);

        dinnerpage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lunchrecipes.this, dinnerpage.class);
                startActivity(intent);
            }
        });
/*
        backbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lunchrecipes.this, recipespage.class);
                startActivity(intent);
            }
        });
*/

    }
}