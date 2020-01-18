package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.data.GardenPlanting;
import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.data.PlantAndGardenPlantings;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Time:2020/1/14 20:45
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantAndGardenPlantingsViewModel {

    private Plant plant;
    private GardenPlanting gardenPlanting;
    private String waterDateString;
    private int wateringInterval;
    private String imageUrl;
    private String plantName;
    private String plantDateString;
    private String plantId;

    public PlantAndGardenPlantingsViewModel(PlantAndGardenPlantings plantings) {
        this.plant = plantings.getPlant();
        this.gardenPlanting = plantings.getGardenPlantings().get(0);
        this.waterDateString = new SimpleDateFormat("MMM d, yyyy", Locale.US).format(gardenPlanting.getLastWateringDate().getTime());
        this.wateringInterval = plant.getWateringInterval();
        this.imageUrl = plant.getImageUrl();
        this.plantName = plant.getName();
        this.plantDateString = new SimpleDateFormat("MMM d, yyyy", Locale.US).format(gardenPlanting.getPlantDate().getTime());
        this.plantId = plant.getPlantId();
    }

    public Plant getPlant() {
        return plant;
    }

    public GardenPlanting getGardenPlanting() {
        return gardenPlanting;
    }

    public String getWaterDateString() {
        return waterDateString;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPlantDateString() {
        return plantDateString;
    }

    public String getPlantId() {
        return plantId;
    }
}
