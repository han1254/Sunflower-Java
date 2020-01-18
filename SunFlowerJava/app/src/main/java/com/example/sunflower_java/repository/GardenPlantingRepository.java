package com.example.sunflower_java.repository;

import com.example.sunflower_java.data.AppDataBase;
import com.example.sunflower_java.data.GardenPlanting;
import com.example.sunflower_java.data.GardenPlantingDao;
import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.data.PlantAndGardenPlantings;

import java.util.Calendar;
import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Time:2020/1/17 14:46
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class GardenPlantingRepository {

    private GardenPlantingDao gardenPlantingDao;
    private static final Object object = new Object();
    private static GardenPlantingRepository INSTANCE = null;

    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    public static GardenPlantingRepository getInstance(GardenPlantingDao gardenPlantingDao) {
        if (INSTANCE == null) {
            synchronized (object) {
                if (INSTANCE == null) {
                   INSTANCE = new GardenPlantingRepository(gardenPlantingDao);
                }
            }
        }
        return INSTANCE;
    }

    public void createGardenPlanting(String plantId) {
        GardenPlanting temp = new GardenPlanting(plantId, Calendar.getInstance(),Calendar.getInstance());
        AppDataBase.databaseWriteExecutor.execute(() -> {
            gardenPlantingDao.insertGardenPlanting(temp);
        });
    }

    public LiveData<Boolean> isPlanted(String plantId) {
        return gardenPlantingDao.isPlanted(plantId);
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardens() {
        return gardenPlantingDao.getPlantedGardens();
    }
}
