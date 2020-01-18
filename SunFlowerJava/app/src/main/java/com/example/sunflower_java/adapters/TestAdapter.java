package com.example.sunflower_java.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunflower_java.R;
import com.example.sunflower_java.data.PlantAndGardenPlantings;
import com.example.sunflower_java.databinding.ListItemGardenPlantingBinding;
import com.example.sunflower_java.viewmodels.PlantAndGardenPlantingsViewModel;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Time:2020/1/18 20:17
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class TestAdapter extends ListAdapter<PlantAndGardenPlantings, TestAdapter.ViewHolder> {

    public TestAdapter() {
        super(new GardenPlantDiffUtilCallbak());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_garden_planting, parent, false),
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_garden_planting, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ListItemGardenPlantingBinding binding;
        public ViewHolder(@NonNull View itemView, ListItemGardenPlantingBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(PlantAndGardenPlantings data) {
            binding.setViewModel(new PlantAndGardenPlantingsViewModel(data));
            binding.executePendingBindings();
        }
    }

    static class GardenPlantDiffUtilCallbak extends DiffUtil.ItemCallback<PlantAndGardenPlantings> {

        @Override
        public boolean areItemsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
            return oldItem.getPlant().getPlantId().equals(newItem.getPlant().getPlantId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
            return newItem.getPlant() == oldItem.getPlant();
        }
    }
}
