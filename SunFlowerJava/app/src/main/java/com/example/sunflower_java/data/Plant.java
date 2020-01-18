package com.example.sunflower_java.data;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Time:2020/1/14 20:48
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Entity(tableName = "plants")
public class Plant {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String plantId;
    private String name;
    private String description;
    private int growZoneNumber;
    private int wateringInterval = 7;
    private String imageUrl = "";
    private boolean isPlanted;

    public void setPlanted(boolean planted) {
        isPlanted = planted;
    }

    public boolean isPlanted() {
        return isPlanted;
    }

    public Plant(String plantId, String name, String description, int growZoneNumber, int wateringInterval, String imageUrl) {
        this.plantId = plantId;
        this.name = name;
        this.description = description;
        this.growZoneNumber = growZoneNumber;
        this.wateringInterval = wateringInterval;
        this.imageUrl = imageUrl;
    }

    public String getPlantId() {
        return plantId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getGrowZoneNumber() {
        return growZoneNumber;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGrowZoneNumber(int growZoneNumber) {
        this.growZoneNumber = growZoneNumber;
    }

    public void setWateringInterval(int wateringInterval) {
        this.wateringInterval = wateringInterval;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean shouldBeWatered(Calendar since, Calendar lastWateringDate) {
       lastWateringDate.add(Calendar.DAY_OF_YEAR, this.wateringInterval);
       return since.compareTo(lastWateringDate) > 0;
    }
}
