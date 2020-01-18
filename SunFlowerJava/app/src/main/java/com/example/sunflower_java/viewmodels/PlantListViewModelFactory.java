package com.example.sunflower_java.viewmodels;

import com.example.sunflower_java.repository.PlantRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Time:2020/1/16 21:17
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private PlantRepository repository;

    public PlantListViewModelFactory(PlantRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new PlantListViewModel(repository);
    }
}
