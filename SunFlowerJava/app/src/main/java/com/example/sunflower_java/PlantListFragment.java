package com.example.sunflower_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunflower_java.adapters.PlantAdapter;
import com.example.sunflower_java.base.BaseFragment;
import com.example.sunflower_java.databinding.FragmentPlantListBinding;
import com.example.sunflower_java.util.InjectorUtil;
import com.example.sunflower_java.viewmodels.PlantListViewModel;
import com.example.sunflower_java.viewmodels.PlantListViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Time:2020/1/14 21:56
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantListFragment extends BaseFragment<FragmentPlantListBinding> {

    private PlantAdapter adapter;
    private PlantListViewModel viewModel;

    @Override
    protected void createView() {
        mDataBinding.plantList.setAdapter(adapter);
        viewModel.getPlants().observe(this, list -> {
            adapter.submitList(list);
        });

        setHasOptionsMenu(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_plant_list;
    }

    @Override
    public void initDataLoad() {

        adapter =  new PlantAdapter();

        PlantListViewModelFactory factory = InjectorUtil.providePlantListViewModelFactory(getContext());
        viewModel = factory.create(PlantListViewModel.class);
    }

    @Override
    public void onViewCreatedDataLoad() {

    }

    public static PlantListFragment getInstance() {
        return new PlantListFragment();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_plant_list, menu);
    }
}
