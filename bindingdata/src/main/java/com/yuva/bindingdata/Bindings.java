package com.yuva.bindingdata;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Yuvaraj on 5/12/2017.
 */

public class Bindings {

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(Fonts.getInstance(textView.getContext()).get(fontName));
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageResource(R.drawable.ic_launcher);
        } else {
            Glide.with(imageView.getContext())
                    .load(url).crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    }

}
