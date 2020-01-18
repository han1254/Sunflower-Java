package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.repository.PlantRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Time:2020/1/16 9:45
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantListViewModel extends ViewModel {

    private PlantRepository plantRepository;
    private MutableLiveData<Integer> growZoneNumber = new MutableLiveData<>(NO_GROW_ZONE);
    private static final int NO_GROW_ZONE = -1;
    private LiveData<List<Plant>> plants;
    public PlantListViewModel(PlantRepository repository) {
        this.plantRepository = repository;
        plants = growZoneNumber.getValue() == NO_GROW_ZONE ? plantRepository.getPlants()
                : plantRepository.getPlantWithGrowZoneNumber(growZoneNumber.getValue());
    }

    public LiveData<List<Plant>> getPlants() {
        return plants;
    }


    public void setGrowZoneNumber(int num) {
        growZoneNumber.setValue(num);
    }

    public void clearGrowZoneNumber() {
        growZoneNumber.setValue(NO_GROW_ZONE);
    }

    public boolean isFiltered() {
        return growZoneNumber.getValue() != NO_GROW_ZONE;
    }

}
