package cn.pencilso.verification.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by Pencilso on 2017/3/4.
 */

public class ImageLoader {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext()).load(url).centerCrop().dontAnimate().into(imageView);
    }
    public static void loadImage(int resourId, ImageView imageView) {
        Glide.with(imageView.getContext()).load(resourId).centerCrop().dontAnimate().into(imageView);
    }
    public static void loadImage(File file, ImageView imageView) {
        Glide.with(imageView.getContext()).load(file).centerCrop().dontAnimate().into(imageView);
    }
}
