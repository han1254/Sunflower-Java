package com.example.sunflower_java.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * Time:2020/1/15 20:37
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public abstract class BaseFragment<D extends ViewDataBinding> extends Fragment {

    protected D mDataBinding;
    protected View mRootView;
    protected Bundle mBundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mRootView = view;
        mDataBinding = DataBindingUtil.bind(view);
        initDataLoad();
        createView();
        return view;
    }

    protected abstract void createView();

    public abstract int getLayoutId();

    public abstract void initDataLoad();

    public abstract void onViewCreatedDataLoad();

    protected D getmDataBinding() {
        return mDataBinding;
    }

}
