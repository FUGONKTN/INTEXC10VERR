package com.example.intexc10_3.service;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.intexc10_3.model.Excursion;
import com.yandex.mapkit.MapKitFactory;

public class IntexcApplication extends Application {
    public ExcursionDao excursionDao;

    public GetterService getterService;

    @Override
    public void onCreate(){
        super.onCreate();
        MapKitFactory.setApiKey("e59c4197-0ea0-4282-a7c0-2b1fa0df311e");
        new Thread(()->{
            Migration mgr = new Migration(1,2) {
                @Override
                public void migrate(@NonNull SupportSQLiteDatabase database) {}};
            Migration mgr2 = new Migration(2,3) {
                @Override
                public void migrate(@NonNull SupportSQLiteDatabase database) {}};
            Database db = Room.databaseBuilder(getApplicationContext(), Database.class, "Excursions").addMigrations(mgr).allowMainThreadQueries().build();

            getterService = new GetterService(db);

            excursionDao = db.excursionDao();
            Excursion exc1 = new Excursion();
            Excursion exc2 = new Excursion();
            exc1.questionone = "Кто стоит слева от Казанского собора?";
            exc1.questionetwo = "Сколько колонн у Исакиевского собора?";
            exc1.questionethree = "Памятник кому стоит в Летнем саду?";
            exc1.answerone = "Кутузов";
            exc1.answertwo = "112";
            exc1.answerthree = "Крылов";
            exc1.name = "КУЛЬТУРА";
            exc1.info = "Она посвящена красивым историческим местам города :)";
            exc1.latitudeone = 59.9342278;
            exc1.longitudeone = 30.3245944;
            exc1.latitudetwo = 59.9340840;
            exc1.longitudetwo = 30.3061486;
            exc1.latitudethree = 59.944909;
            exc1.longitudethree = 30.335550;
            exc2.questionone = "Какого цвет был первый сервер Яндекса?";
            exc2.questionetwo = "Компания, в доме которой находится офис ВК";
            exc2.questionethree = "Сколько моделей игровых автоматов в МИА?";
            exc2.answerone = "Серый";
            exc2.answertwo = "Зингер";
            exc2.answerthree = "74";
            exc2.info = "Тут вы посетите интересные места для любителей новых и старых технологий";
            exc2.name = "ГИК";
            exc2.latitudeone = 59.93338;
            exc2.longitudeone = 30.34489;
            exc2.latitudetwo = 59.935667;
            exc2.longitudetwo = 30.325917;
            exc2.latitudethree = 59.940154;
            exc2.longitudethree = 30.326073;
            excursionDao.insertExc(exc1, exc2);

        }).start();
    }

}
