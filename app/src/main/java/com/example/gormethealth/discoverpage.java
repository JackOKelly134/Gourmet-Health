package com.example.gormethealth;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class discoverpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discoverpage);

        Button challengepage = findViewById(R.id.challengepage);
        Button counterpage = findViewById(R.id.counterpage);
        Button homebutton = findViewById(R.id.homebutton);


        challengepage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(discoverpage.this, challengepage.class);
                startActivity(intent);
            }
        });



        counterpage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(discoverpage.this, counterpage.class);
                startActivity(intent);
            }
        });



        homebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(discoverpage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}