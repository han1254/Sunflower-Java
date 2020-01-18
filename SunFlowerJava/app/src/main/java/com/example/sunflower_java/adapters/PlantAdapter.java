package com.example.sunflower_java.adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunflower_java.R;
import com.example.sunflower_java.ViewPagerFragmentDirections;
import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.databinding.ListItemPlantBinding;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Time:2020/1/16 21:26
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.PlantViewHolder> {
    public PlantAdapter() {
        super(new PlantDiffCallback());
    }

    @NonNull
    @Override
    public PlantAdapter.PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_plant, parent, false);
        return new PlantViewHolder(view, ListItemPlantBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter.PlantViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class PlantViewHolder extends RecyclerView.ViewHolder {
        private ListItemPlantBinding binding;
        PlantViewHolder(@NonNull View itemView, ListItemPlantBinding binding) {
            super(itemView);
            this.binding = binding;
            binding.setClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToPlant(binding.getPlant().getPlantId(), view);
                }
            });
        }

        private void navigateToPlant(String id, View view) {
            Bundle bundle = new Bundle();
            bundle.putString("plantId", id);
            Navigation.findNavController(view).navigate(R.id.action_viewPagerFragment_to_detailFragment, bundle);
        }

        public void bind(Plant plant) {
            binding.setPlant(plant);
        }
    }

    static class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {

        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.getPlantId().equals(newItem.getPlantId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem == newItem;
        }
    }
}
