package com.example.sunflower_java.adapters;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.sunflower_java.R;
import com.example.sunflower_java.ViewPagerFragmentDirections;
import com.example.sunflower_java.base.BaseDataBindingViewHolder;
import com.example.sunflower_java.base.BaseDiffUtil;
import com.example.sunflower_java.base.BaseListAdapter;
import com.example.sunflower_java.data.PlantAndGardenPlantings;
import com.example.sunflower_java.databinding.FragmentGardenBinding;
import com.example.sunflower_java.databinding.ListItemGardenPlantingBinding;
import com.example.sunflower_java.viewmodels.PlantAndGardenPlantingsViewModel;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Time:2020/1/18 15:51
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class GardenPlantingAdapter extends BaseListAdapter<PlantAndGardenPlantings, ListItemGardenPlantingBinding> {

    private PlantAndGardenPlantingsViewModel viewModel;

    public GardenPlantingAdapter(BaseDiffUtil<PlantAndGardenPlantings> baseDiffUtil) {
        super(baseDiffUtil);
    }

    @Override
    protected void setClickCallBack(BaseDataBindingViewHolder<ListItemGardenPlantingBinding> holder, int position) {
        navigateToPlant(holder.getDataBinding().getViewModel().getPlantId(), dataBinding.getRoot());
    }

    private void navigateToPlant(String plantId, View root) {
        ViewPagerFragmentDirections.ActionViewPagerFragmentToDetailFragment action = ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment(plantId);
        Navigation.findNavController(root).navigate(action);
    }

    @Override
    public void bindView(BaseDataBindingViewHolder<ListItemGardenPlantingBinding> holder, PlantAndGardenPlantings data) {
        viewModel = new PlantAndGardenPlantingsViewModel(data);
        holder.getDataBinding().setViewModel(viewModel);
        holder.getDataBinding().executePendingBindings();
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item_garden_planting;
    }

}
