package com.example.binoy1001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button assignment1, assignment2, assignment3, assignment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignment1 = findViewById(R.id.assignment1_btn);
        assignment2 = findViewById(R.id.assignment2_btn);
        assignment3 = findViewById(R.id.assignment3_btn);
        assignment4 = findViewById(R.id.assignment4_btn);

        // Contains ImageView, Button, Custom Toast
        assignment1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Assignment1Activity.class);
            startActivity(intent);
        });

        // Contains CheckBox and RadioGroup
        assignment2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Assignment2Activity.class);
            startActivity(intent);
        });

        // Contains RatingBar, SeekBar and Switch
        assignment3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Assignment3Activity.class);
            startActivity(intent);
        });
        assignment4.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            startActivity(intent);
        });
    }
}