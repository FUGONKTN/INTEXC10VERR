package com.example.intexc10_3.service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.intexc10_3.model.Excursion;

@Dao
public interface ExcursionDao {
    @Insert
    void insertExc(Excursion...excursions);
    @Update
    void updateExc(Excursion excursion);
    @Delete
    void deleteExc(Excursion exc);

    @Query("SELECT Latitude1 FROM Excursion WHERE ExcId = :id")
    double getLatOne(int id);
    @Query("SELECT Longitude1 FROM Excursion WHERE ExcId = :id")
    double getLongOne(int id);
    @Query("SELECT Latitude2 FROM excursion WHERE ExcId = :id")
    double getLatTwo(int id);
    @Query("SELECT Longitude2 FROM Excursion WHERE ExcId = :id")
    double getLongTwo(int id);
    @Query("SELECT Latitude3 FROM Excursion WHERE ExcId =:id")
    double getLatThree(int id);
    @Query("SELECT Longitude3 FROM Excursion WHERE ExcID = :id")
    double getLongThree(int id);

    @Query("SELECT Questione1 FROM Excursion WHERE ExcId = :id")
    String getQuestioneOne(int id);
    @Query("SELECT Questione2 FROM Excursion WHERE ExcId = :id")
    String getQuestioneTwo(int id);
    @Query("SELECT Questione3 FROM Excursion WHERE ExcId = :id")
    String getQuestioneThree(int id);
    @Query("SELECT Answer1 FROM Excursion WHERE ExcId =:id")
    String getAnsOne(int id);
    @Query("SELECT Answer2 FROM Excursion WHERE ExcId =:id")
    String getAnsTwo(int id);
    @Query("SELECT Answer3 FROM Excursion WHERE ExcId =:id")
    String getAnsThree(int id);

    @Query("SELECT name FROM Excursion WHERE ExcId = :id")
    String getName(int id);
    @Query("SELECT info FROM Excursion WHERE ExcId= :id")
    String getInfo(int id);

    @Query("UPDATE Excursion SET result = :res WHERE ExcId = :id")
    void updateRes(int res, int id);
    @Query("SELECT result FROM Excursion WHERE ExcId = :id")
    int getRes(int id);

}
