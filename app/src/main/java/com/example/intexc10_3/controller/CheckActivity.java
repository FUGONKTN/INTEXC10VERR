package com.example.intexc10_3.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intexc10_3.service.GetterService;
import com.example.intexc10_3.service.IntexcApplication;
import com.example.intexc10_3.R;

public class CheckActivity extends AppCompatActivity {
    int count;
    TextView rs;
    GetterService gts;
    Button next;
    Button faq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        String usansone = getIntent().getStringExtra("usansone");
        String usanstwo = getIntent().getStringExtra("usanstwo");
        String usansthree = getIntent().getStringExtra("usansthree");
        gts = ((IntexcApplication) getApplication()).getterService;
        int position = getIntent().getIntExtra("position", 0);
        rs = (TextView) findViewById(R.id.ResultString);
        next = (Button) findViewById(R.id.next);
        faq = (Button) findViewById(R.id.faq);
        String[] useranswers = {usansone, usanstwo, usansthree};
        String[] rightanswers = gts.getAnswers(position);
        count = 0;
        for(int i = 0; i<3; i++ ){
            if(useranswers[i].equals(rightanswers[i])){
                count++;
            }
        }
        rs.setText(count+"/3");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gts.updateRes(count, position);
                Intent intt = new Intent(getApplicationContext(), ChooseExc.class);
                startActivity(intt);
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(intt);
            }
        });
    }
}