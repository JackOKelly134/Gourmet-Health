package com.example.gormethealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private counterpage stepCounter;
    private TextView stepCountTextView;
    //ListView recipes_list;
    //private Build.VERSION_CODES android;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button recipespage = findViewById(R.id.recipespage);
        Button goalspage = findViewById(R.id.goalspage);
        Button discoverpage = findViewById(R.id.discoverpage);
        recipespage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, recipespage.class);
                startActivity(intent);
            }
        });

        goalspage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, goalspage.class);
                startActivity(intent);
            }
        });

        discoverpage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, discoverpage.class);
                startActivity(intent);
            }
        });
    }



}