 package com.example.intexc10_3.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.intexc10_3.R;

 public class MainActivity extends AppCompatActivity {
    Button btnstrt;
    Button btnfaq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstrt = (Button) findViewById(R.id.btn);
        btnfaq = (Button) findViewById(R.id.btntwo);
        btnstrt.setOnClickListener((v) ->{
            Intent intt = new Intent(this, ChooseExc.class);
            startActivity(intt);
        });
        btnfaq.setOnClickListener((v)->{
            Intent intt = new Intent(this, InfoActivity.class);
            startActivity(intt);
        });
    }
}