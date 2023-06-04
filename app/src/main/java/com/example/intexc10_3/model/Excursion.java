package com.example.intexc10_3.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Excursion {
    @PrimaryKey(autoGenerate = true)
    public int ExcId;
    @ColumnInfo(name = "Longitude1")
    public double longitudeone;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "info")
    public String info;
    @ColumnInfo(name = "result")
    public int result;
    @ColumnInfo(name = "Latitude1")
    public double latitudeone;
    @ColumnInfo(name = "Longitude2")
    public double longitudetwo;
    @ColumnInfo(name = "Latitude2")
    public double latitudetwo;
    @ColumnInfo(name = "Longitude3")
    public double longitudethree;
    @ColumnInfo(name = "Latitude3")
    public double latitudethree;
    @ColumnInfo(name = "Questione1")
    public String questionone;
    @ColumnInfo(name = "Questione2")
    public String questionetwo;
    @ColumnInfo(name = "Questione3")
    public String questionethree;
    @ColumnInfo(name = "Answer1")
    public String answerone;
    @ColumnInfo(name = "Answer2")
    public String answertwo;
    @ColumnInfo(name = "Answer3")
    public String answerthree;
}
