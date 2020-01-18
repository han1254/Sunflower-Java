package com.example.sunflower_java.util;

import android.content.Context;

import com.example.sunflower_java.data.AppDataBase;
import com.example.sunflower_java.repository.GardenPlantingRepository;
import com.example.sunflower_java.repository.PlantRepository;
import com.example.sunflower_java.viewmodels.GardenPlantingListViewModelFactory;
import com.example.sunflower_java.viewmodels.PlantDetailViewModelFactory;
import com.example.sunflower_java.viewmodels.PlantListViewModelFactory;

/**
 * Time:2020/1/16 21:22
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class InjectorUtil {

    private static PlantRepository getPlantRepository(Context context) {
        return PlantRepository.getInstance(AppDataBase.getInstance(context).getPlantDao());
    }

    private static GardenPlantingRepository gardenPlantingRepository(Context context) {
        return GardenPlantingRepository.getInstance(AppDataBase.getInstance(context).getGardenPlantDao());
    }

    public static PlantListViewModelFactory providePlantListViewModelFactory(Context context) {
        return new PlantListViewModelFactory(getPlantRepository(context));
    }

    public static GardenPlantingListViewModelFactory provideGardenPlantingListViewModel(Context context) {
        return new GardenPlantingListViewModelFactory(gardenPlantingRepository(context));
    }

    public static PlantDetailViewModelFactory providePlantDetailViewModelFactory(Context context, String id) {
        return new PlantDetailViewModelFactory(gardenPlantingRepository(context), getPlantRepository(context), id);
    }

}
