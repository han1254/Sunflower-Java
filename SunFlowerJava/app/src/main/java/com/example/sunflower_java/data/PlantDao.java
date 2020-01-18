package com.example.sunflower_java.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Time:2020/1/16 19:44
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Dao
public interface PlantDao {

    @Query("SELECT * FROM plants ORDER BY name")
    public LiveData<List<Plant>> getPlants();

    @Query("SELECT * FROM plants WHERE growZoneNumber = :growZoneNumber ORDER BY name")
    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber);

    @Query("SELECT * FROM plants WHERE id = :plantId")
    public LiveData<Plant> getPlant(String plantId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Plant> plants);

    @Update
    public void updatePlants(Plant plant);

}
