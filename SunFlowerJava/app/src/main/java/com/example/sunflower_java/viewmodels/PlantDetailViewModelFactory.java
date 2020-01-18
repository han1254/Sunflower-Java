package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.repository.GardenPlantingRepository;
import com.example.sunflower_java.repository.PlantRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Time:2020/1/17 15:22
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository gardenPlantingRepository;
    private PlantRepository plantRepository;
    private String id;

    public PlantDetailViewModelFactory(GardenPlantingRepository gardenPlantingRepository, PlantRepository plantRepository, String id) {
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantRepository = plantRepository;
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantDetailViewModel(plantRepository, gardenPlantingRepository, id);
    }
}
