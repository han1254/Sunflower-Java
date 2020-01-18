package com.example.sunflower_java;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.sunflower_java.adapters.SunFlowerPagerAdapter;
import com.example.sunflower_java.base.BaseFragment;
import com.example.sunflower_java.config.ViewPagerConfig;
import com.example.sunflower_java.databinding.FragmentViewPagerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewPagerFragment extends BaseFragment<FragmentViewPagerBinding> {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private SunFlowerPagerAdapter adapter;

    @Override
    protected void createView() {
        mTabLayout = mDataBinding.tabs;
        mViewPager= mDataBinding.viewPager;
        assert getFragmentManager() != null;
        adapter = new SunFlowerPagerAdapter(getChildFragmentManager(), getLifecycle());
        mViewPager.setAdapter(adapter);
        new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.OnConfigureTabCallback() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(getTabIcon(position));
                tab.setText(geTabTitle(position));
            }
        }).attach();
    }

    private String geTabTitle(int position) {
        switch (position) {
            case ViewPagerConfig
                    .GARDEN_FRAGMENT_FLAG:
                return "MyGarden";
            case ViewPagerConfig.PLANT_LIST_FLAG:
                return "PlantList";
            default:
                throw new IndexOutOfBoundsException("超出界限");
        }

    }

    private int getTabIcon(int position) {
        switch (position) {
            case ViewPagerConfig
                    .GARDEN_FRAGMENT_FLAG:
                return R.drawable.garden_tab_selector;
            case ViewPagerConfig.PLANT_LIST_FLAG:
                return R.drawable.plant_list_tab_selector;
            default:
                throw new IndexOutOfBoundsException("超出界限");
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_view_pager;
    }

    @Override
    public void initDataLoad() {

    }

    @Override
    public void onViewCreatedDataLoad() {

    }
}
