package com.example.sunflower_java.adapters;

import android.view.View;

import androidx.databinding.BindingAdapter;

/**
 * Time:2020/1/14 21:42
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class BindingAdapters {
    @BindingAdapter("isGone")
    public static void bindIsGone(View view, boolean isGone) {
        view.setVisibility(isGone ? View.GONE : View.VISIBLE);
    }
}
