package com.example.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunflower_java.adapters.GardenPlantingAdapter;
import com.example.sunflower_java.adapters.TestAdapter;
import com.example.sunflower_java.base.BaseDiffUtil;
import com.example.sunflower_java.base.BaseFragment;
import com.example.sunflower_java.base.ViewPagerInstanceFlag;
import com.example.sunflower_java.data.GardenPlanting;
import com.example.sunflower_java.data.PlantAndGardenPlantings;
import com.example.sunflower_java.databinding.FragmentGardenBinding;
import com.example.sunflower_java.util.InjectorUtil;
import com.example.sunflower_java.viewmodels.GardenPlantingListViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

/**
 * Time:2020/1/14 21:57
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class GardenFragment extends BaseFragment<FragmentGardenBinding> {

    private GardenPlantingListViewModel viewModel;
    private GardenPlantingAdapter adapter;

    public static GardenFragment getInstance() {
        return new GardenFragment();
    }

    @Override
    protected void createView() {
        mDataBinding.setLifecycleOwner(this);
        mDataBinding.gardenList.setAdapter(adapter);
        viewModel.getPlantAndGardenPlantings().observe(this, plantAndGardenPlantings -> {
            mDataBinding.setHasPlantings(!(plantAndGardenPlantings == null) && plantAndGardenPlantings.size() != 0);
            adapter.submitList(plantAndGardenPlantings);
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_garden;
    }

    @Override
    public void initDataLoad() {
        viewModel = InjectorUtil.provideGardenPlantingListViewModel(getContext()).create(GardenPlantingListViewModel.class);
        adapter = new GardenPlantingAdapter(new BaseDiffUtil<>());
    }

    @Override
    public void onViewCreatedDataLoad() {

    }

}
