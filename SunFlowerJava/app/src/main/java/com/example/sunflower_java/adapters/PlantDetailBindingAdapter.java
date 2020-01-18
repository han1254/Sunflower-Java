package com.example.sunflower_java.adapters;

import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.sunflower_java.R;

import androidx.core.text.HtmlCompat;
import androidx.databinding.BindingAdapter;

/**
 * Time:2020/1/14 21:31
 * Author: han1254
 * Email: 1254763408@qq.com
 * Function:
 */
public class PlantDetailBindingAdapter {

    //list_item_garden_planting
    @BindingAdapter(value = {"imageFromUrl"}, requireAll = false)
    public static void bindImageFromUrl(ImageView view, String imgUrl) {
        if (!"".equals(imgUrl)) {
            Glide.with(view.getContext())
                    .load(imgUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view);
        }
    }

    //detail_fragment
    @BindingAdapter(value = {"renderHtml"}, requireAll = false)
    public static void bindRenderHtml(TextView textView, String description) {
        if (description != null) {
            textView.setText(HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setText("");
        }
    }

    //detail_fragment
    @BindingAdapter(value = {"wateringText"}, requireAll = false)
    public static void bindWateringText(TextView textView, int wateringInterVal) {
        String content = textView.getContext().getResources().getQuantityString(R.plurals.watering_needs_suffix, wateringInterVal, wateringInterVal);
        textView.setText(content);
    }

}
