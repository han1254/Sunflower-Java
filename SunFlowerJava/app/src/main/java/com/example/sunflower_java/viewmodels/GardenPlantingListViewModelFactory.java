package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.repository.GardenPlantingRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Time:2020/1/17 15:12
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class GardenPlantingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository repository;

    public GardenPlantingListViewModelFactory(GardenPlantingRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GardenPlantingListViewModel(repository);
    }
}
