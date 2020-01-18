package com.example.sunflower_java;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ShareCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunflower_java.base.BaseFragment;
import com.example.sunflower_java.data.Plant;
import com.example.sunflower_java.databinding.FragmentDetailBinding;
import com.example.sunflower_java.util.InjectorUtil;
import com.example.sunflower_java.viewmodels.PlantDetailViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetailFragment extends BaseFragment<FragmentDetailBinding> {

    private String id;
    private PlantDetailViewModel viewModel;
    private boolean isToolbarShown = false;

    @Override
    protected void createView() {
        mDataBinding.setLifecycleOwner(this);
        mDataBinding.setViewModel(viewModel);
        mDataBinding.setCallback(plant -> {
            hideAppBarFab(mDataBinding.fab);
            viewModel.addPlantToGarden();
            plant.setPlanted(true);
            viewModel.updateData(plant);
            Snackbar.make(getView(), R.string.added_plant_to_garden, Snackbar.LENGTH_LONG)
            .show();
        });

        viewModel.getPlant().observe(this, plant -> {
            if (plant.isPlanted()) {
                hideAppBarFab(mDataBinding.fab);
            }
        });

        mDataBinding.plantDetailScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                boolean shouldShowToolBar = scrollY > mDataBinding.toolbar.getHeight();

                if (isToolbarShown != shouldShowToolBar) {
                    isToolbarShown = shouldShowToolBar;

                    mDataBinding.appbar.setActivated(shouldShowToolBar);
                    mDataBinding.toolbarLayout.setTitleEnabled(shouldShowToolBar);
                }
            }
        });

        mDataBinding.toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(v).navigateUp();
        });

        mDataBinding.toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_share) {
                createShareIntent();
                return true;
            }
            return false;
        });

        setHasOptionsMenu(true);

    }

    private void createShareIntent() {
        String shareText = viewModel.getPlant().getValue().getDescription();
        Intent intent = ShareCompat.IntentBuilder.from(getActivity())
                .setText(shareText)
                .setType("text/plain")
                .createChooserIntent()
                .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
                .addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        startActivity(intent);

    }


    private void hideAppBarFab(FloatingActionButton fab) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mDataBinding.fab.getLayoutParams();
        FloatingActionButton.Behavior behavior = (FloatingActionButton.Behavior) params.getBehavior();
        behavior.setAutoHideEnabled(false);
        fab.hide();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public void initDataLoad() {
       id = DetailFragmentArgs.fromBundle(getArguments()).getPlantId();
       viewModel = InjectorUtil.providePlantDetailViewModelFactory(getContext(), id)
               .create(PlantDetailViewModel.class);
    }


    @Override
    public void onViewCreatedDataLoad() {

    }

    public interface Callback {
        void addSth(Plant plant);
    }
}
