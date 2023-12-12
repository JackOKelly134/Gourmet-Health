package com.example.gormethealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class goalspage extends AppCompatActivity {

    public static void setOnClickListener(View.OnClickListener onClickListener) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goalspage);

        Button backbutton = findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(goalspage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}