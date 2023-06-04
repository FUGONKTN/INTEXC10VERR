package com.example.intexc10_3.controller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.intexc10_3.service.ExcursionDao;
import com.example.intexc10_3.service.IntexcApplication;

public class ChooseExc extends ListActivity {
    ExcursionDao excursionDao;
    String[] names = {"ВЫБЕРИТЕ ЭКСКУРСИЮ!", "КУЛЬТУРА", "ГИК"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        excursionDao = ((IntexcApplication) getApplication()).excursionDao;
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adptr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        setListAdapter(adptr);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if(position == 0){
            Toast.makeText(this, "Выбирай)", Toast.LENGTH_SHORT).show();
        }else {
            Intent intt = new Intent(this, MapActivity.class);
            intt.putExtra("position", position);
            startActivity(intt);
        }
    }
}