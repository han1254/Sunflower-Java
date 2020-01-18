package com.example.sunflower_java.repository;

import com.example.sunflower_java.App;
import com.example.sunflower_java.data.AppDataBase;
import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.data.PlantDao;

import java.util.List;

import androidx.lifecycle.LiveData;
import kotlin.jvm.Volatile;

/**
 * Time:2020/1/16 20:44
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantRepository {

    private PlantDao plantDao;
    private static final Object sLock = new Object();


    @Volatile
    private static PlantRepository INSTANCE = null;

    public static PlantRepository getInstance(PlantDao dao) {
        if (INSTANCE == null) {
            synchronized (sLock) {
                if (INSTANCE == null) {
                    INSTANCE = new PlantRepository(dao);
                }
            }
        }

        return INSTANCE;
    }


    private PlantRepository(PlantDao plantDao){
        this.plantDao = plantDao;
    }

    public LiveData<List<Plant>> getPlants() {
        return plantDao.getPlants();
    }

    public LiveData<Plant> getPlant(String plantId) {
        return plantDao.getPlant(plantId);
    }

    public LiveData<List<Plant>> getPlantWithGrowZoneNumber(int growZoneNumber) {
        return plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }

    public void upDatePlant(Plant data) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            plantDao.updatePlants(data);
        });
    }


}
