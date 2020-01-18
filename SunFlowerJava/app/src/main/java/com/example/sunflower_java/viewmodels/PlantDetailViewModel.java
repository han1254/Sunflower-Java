package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.repository.GardenPlantingRepository;
import com.example.sunflower_java.repository.PlantRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Time:2020/1/17 15:16
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantDetailViewModel extends ViewModel {

    private PlantRepository plantRepository;
    private GardenPlantingRepository gardenPlantingRepository;
    private String id;
    private LiveData<Boolean> isPlanted = new MutableLiveData<>();
    private LiveData<Plant> plant = new MutableLiveData<>();

    public PlantDetailViewModel(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository, String id) {
        this.plantRepository = plantRepository;
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.id = id;
        plant = plantRepository.getPlant(id);
        isPlanted = gardenPlantingRepository.isPlanted(id);
//        String url = plant.getValue().getImageUrl();
    }

    public LiveData<Boolean> getIsPlanted() {
        isPlanted = gardenPlantingRepository.isPlanted(id);
        return isPlanted;
    }

    public void updateData(Plant plant) {
        plantRepository.upDatePlant(plant);
    }

    public LiveData<Plant> getPlant() {
        return plant;
    }

    public void addPlantToGarden() {
        gardenPlantingRepository.createGardenPlanting(id);
    }
}
