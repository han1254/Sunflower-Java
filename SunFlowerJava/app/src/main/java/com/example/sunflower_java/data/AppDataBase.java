package com.example.sunflower_java.data;

import android.content.Context;
import android.content.IntentFilter;

import com.example.sunflower_java.repository.DataInitManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Time:2020/1/16 19:48
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Database(entities = {GardenPlanting.class, Plant.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;
    private static final Object sLock = new Object();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract GardenPlantingDao getGardenPlantDao();

    public abstract PlantDao getPlantDao();

    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "sunflower-db")
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    DataInitManager.initPlantData();
                                }
                            })
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
