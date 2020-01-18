package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.data.PlantAndGardenPlantings;
import com.example.sunflower_java.repository.GardenPlantingRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Time:2020/1/17 15:07
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class GardenPlantingListViewModel extends ViewModel {
    private LiveData<List<PlantAndGardenPlantings>> plantAndGardenPlantings = new MutableLiveData<>();

    private GardenPlantingRepository repository;

    public GardenPlantingListViewModel(GardenPlantingRepository repository) {
        this.repository = repository;
        plantAndGardenPlantings = repository.getPlantAndGardens();
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return plantAndGardenPlantings;
    }
}
