package com.example.sunflower_java.adapters;

import android.app.Activity;

import com.example.sunflower_java.GardenFragment;
import com.example.sunflower_java.PlantListFragment;
import com.example.sunflower_java.base.BaseFragment;
import com.example.sunflower_java.config.ViewPagerConfig;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Time:2020/1/16 8:12
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class SunFlowerPagerAdapter extends FragmentStateAdapter {

    public SunFlowerPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case ViewPagerConfig
                    .GARDEN_FRAGMENT_FLAG:
                return GardenFragment.getInstance();
            case ViewPagerConfig.PLANT_LIST_FLAG:
                return PlantListFragment.getInstance();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
