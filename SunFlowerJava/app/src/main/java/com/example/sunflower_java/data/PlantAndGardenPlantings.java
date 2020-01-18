package com.example.sunflower_java.data;

import com.example.sunflower_java.base.IDiffUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

/**
 * Time:2020/1/14 20:47
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantAndGardenPlantings implements IDiffUtil<PlantAndGardenPlantings> {
    @Embedded
    private Plant plant;

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    List<GardenPlanting> gardenPlantings = new ArrayList<>();

    public PlantAndGardenPlantings() {}

    public PlantAndGardenPlantings(Plant plant) {
        this.plant = plant;
    }

    public Plant getPlant() {
        return plant;
    }

    public List<GardenPlanting> getGardenPlantings() {
        return gardenPlantings;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public void setGardenPlantings(List<GardenPlanting> gardenPlantings) {
        this.gardenPlantings = gardenPlantings;
    }

    @Ignore
    @Override
    public boolean areItemSame(PlantAndGardenPlantings plantings) {
        return this.getPlant().getPlantId().equals(plantings.getPlant().getPlantId());
    }

    @Ignore
    @Override
    public boolean areContentSame(PlantAndGardenPlantings plantings) {
        return this.getPlant() == plantings.getPlant();
    }
}
