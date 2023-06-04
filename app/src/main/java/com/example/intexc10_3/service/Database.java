package com.example.intexc10_3.service;

import androidx.room.RoomDatabase;

import com.example.intexc10_3.model.Excursion;

@androidx.room.Database(entities = {Excursion.class}, version = 2)
public abstract class Database extends RoomDatabase {
    public abstract ExcursionDao excursionDao();
}
