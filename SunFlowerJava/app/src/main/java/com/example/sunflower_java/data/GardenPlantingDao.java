package com.example.sunflower_java.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

/**
 * Time:2020/1/16 19:30
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Dao
public interface GardenPlantingDao {

    @Query("SELECT * FROM garden_plantings")
    public LiveData<List<GardenPlanting>> getGardenPlanting();

    @Query("SELECT EXISTS(SELECT * FROM garden_plantings WHERE plant_id = :plantId LIMIT 1)")
    public LiveData<Boolean> isPlanted(String plantId);

    @Transaction
    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
    public  LiveData<List<PlantAndGardenPlantings>> getPlantedGardens();


    @Insert
    public Long insertGardenPlanting(GardenPlanting gardenPlanting);

    @Delete
    public void deleteGardenPlanting(GardenPlanting gardenPlanting);

}
