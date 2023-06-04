package com.example.intexc10_3.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intexc10_3.service.GetterService;
import com.example.intexc10_3.service.IntexcApplication;
import com.example.intexc10_3.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapActivity extends AppCompatActivity {
    private MapView mapp;
    EditText questone;
    EditText questtwo;
    EditText questthree;
    Button checker;
    GetterService gts;
    String[] info;
    int position;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map_acativity);
        questone = (EditText) findViewById(R.id.Questionone);
        questtwo = (EditText) findViewById(R.id.Questiontwo);
        questthree = (EditText) findViewById(R.id.Questionthree);
        String[] quests;
        Double[] points;



        position = getIntent().getIntExtra("position", 0);

            gts = ((IntexcApplication) getApplication()).getterService;
            quests = gts.getQuestions(position);
            points = gts.getPoints(position);
            info = gts.getInformation(position);



        questone.setText(quests[0]);
        questtwo.setText(quests[1]);
        questthree.setText(quests[2]);
        mapp = (MapView) findViewById(R.id.Map);
        mapp.getMap().move(

                new CameraPosition(new Point(points[0], points[1]), 11.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
                Point mappointone = new Point(points[0], points[1]);
                Point mappointtwo = new Point(points[2], points[3]);
                Point mappointthree = new Point(points[4], points[5]);
                mapp.getMap().getMapObjects().addPlacemark(mappointone);
                mapp.getMap().getMapObjects().addPlacemark(mappointtwo);
                mapp.getMap().getMapObjects().addPlacemark(mappointthree);
                checker = (Button) findViewById(R.id.CHECKER);
                checker.setBackgroundColor(Color.BLACK);
                checker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intt = new Intent(getApplicationContext(), CheckActivity.class);
                        String usansone = questone.getText().toString();
                        String usanstwo = questtwo.getText().toString();
                        String usansthree = questthree.getText().toString();
                        String[] usans = {usansone, usanstwo, usansthree};
                        intt.putExtra("usansone", usansone);
                        intt.putExtra("usanstwo", usanstwo);
                        intt.putExtra("usansthree", usansthree);
                        intt.putExtra("position", position);
                        startActivity(intt);
                    }
                });
    }

    @Override
    protected void onStart() {
        mapp.onStart();
        MapKitFactory.getInstance().onStart();
        super.onStart();

        int res = gts.getRes(position);
        LayoutInflater infl1 = getLayoutInflater();
        View layout1 = infl1.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        TextView text1 = (TextView) layout1.findViewById(R.id.text_on_toast);
        text1.setText("Вы выбрали экскурсию " + "'"+info[0]+"'" + "'"+"." + " " + info[1] + "" +
                "\nСтартовая точка - Станция метро 'Чёрная речка' "+
                "\nВаш предыдущий результат: " + res );
        Toast tst  = new Toast(getApplicationContext());
        tst.setGravity(Gravity.BOTTOM, 0, 0);
        tst.setDuration(Toast.LENGTH_LONG);
        tst.setView(layout1);
        tst.show();

        LayoutInflater infl = getLayoutInflater();
        View layout = infl.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        TextView toasttext = (TextView) layout.findViewById(R.id.text_on_toast);
        toasttext.setText("Желаем приятной экскурсии!)");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    @Override
    protected void onStop() {
        mapp.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }
}