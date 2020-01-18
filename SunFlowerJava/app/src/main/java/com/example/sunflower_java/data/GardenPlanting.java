package com.example.sunflower_java.data;

import java.util.Calendar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * Time:2020/1/14 20:57
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
@Entity(
        tableName = "garden_plantings",
        foreignKeys = {@ForeignKey(
                entity = Plant.class,
                childColumns = {"plant_id"},
                parentColumns = {"id"}
        )},
        indices = {@Index({"plant_id"})}
)
public class GardenPlanting {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long gardenPlantingId;

    @ColumnInfo(name = "plant_id")
    private String plantId;

    @ColumnInfo(name = "plant_date")
    private Calendar plantDate;

    @ColumnInfo(name = "last_watering_date")
    private Calendar lastWateringDate;

    public GardenPlanting(String plantId, Calendar plantDate, Calendar lastWateringDate) {
        this.plantId = plantId;
        this.plantDate = plantDate;
        this.lastWateringDate = lastWateringDate;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public void setPlantDate(Calendar plantDate) {
        this.plantDate = plantDate;
    }

    public void setLastWateringDate(Calendar lastWateringDate) {
        this.lastWateringDate = lastWateringDate;
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public String getPlantId() {
        return plantId;
    }

    public Calendar getPlantDate() {
        return plantDate;
    }

    public Calendar getLastWateringDate() {
        return lastWateringDate;
    }
}
