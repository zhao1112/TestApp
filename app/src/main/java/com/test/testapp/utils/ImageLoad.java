package com.test.testapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.test.testapp.R;


/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/1
 * Time: 14:30
 */
public class ImageLoad {

    private static RequestOptions options = new RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop();

    private static RequestOptions requestOptions = new RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .error(R.mipmap.ic_launcher)
            .transform(new CornerTransformUtil(8));

    /**
     * 加载普通图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载普通图片
     *
     * @param context
     * @param src
     * @param imageView
     */
    public static void display(Context context, Integer src, ImageView imageView) {
        Glide.with(context)
                .load(src)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载普通图片 , 有过渡动画
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayTransition(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(imageView);
    }


    /**
     * 加载普通图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayNoPlaceholder(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(imageView);
    }

    /**
     * 加载图片，并切成圆形
     *
     * @param context
     * @param src
     * @param imageView
     */
    public static void DisplayCircle(final Context context, Integer src, final ImageView imageView) {
        DisplayCircle(context, src, null, imageView);
    }

    public static void DisplayCircle(final Context context, String url, final ImageView imageView) {
        DisplayCircle(context, 0, url, imageView);
    }

    public static void DisplayCircle(final Context context, Integer src, String url, final ImageView imageView) {
        Glide.with(context)
                .asBitmap()
                .load(url == null ? src : url)
                .apply(options)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayRoundCorner(final Context context, String url, final ImageView imageView, final int dpCorner) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(options)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        circularBitmapDrawable.setCornerRadius(ConstantUtil.dp2px(context, dpCorner));
                        circularBitmapDrawable.setAntiAlias(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    /**
     * 加载圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayRoundCorner(final Context context, Bitmap url, final ImageView imageView, final int dpCorner) {
        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), url);
        circularBitmapDrawable.setCircular(true);
        circularBitmapDrawable.setCornerRadius(ConstantUtil.dp2px(context, dpCorner));
        circularBitmapDrawable.setAntiAlias(true);
        imageView.setImageDrawable(circularBitmapDrawable);
    }


    /**
     * 加载圆角图片  加载模式根据图片自身xml设定
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayRoundCorners(final Context context, String url, final ImageView imageView, final int dpCorner) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(options)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        circularBitmapDrawable.setCornerRadius(ConstantUtil.dp2px(context, dpCorner));
                        circularBitmapDrawable.setAntiAlias(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }


    /**
     * 加载圆角图片
     *
     * @param context
     * @param src
     * @param imageView
     */
    public static void DisplayRoundCorner(final Context context, Integer src, final ImageView imageView, final int dpCorner) {
        Glide.with(context)
                .asBitmap()
                .load(src)
                .apply(options)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        circularBitmapDrawable.setCornerRadius(ConstantUtil.dp2px(context, dpCorner));
                        circularBitmapDrawable.setAntiAlias(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }


    public static void displayGif(Context context, @DrawableRes int resId, final ImageView imageView) {
        Glide.with(context)
                .asGif()
                .apply(options)
                .load(resId)
                .into(new SimpleTarget<GifDrawable>() {
                    @Override
                    public void onResourceReady(@NonNull GifDrawable resource, @Nullable Transition<? super GifDrawable> transition) {
                        if (resource instanceof GifDrawable) {
                            GifDrawable gifDrawable = (GifDrawable) resource;
                            gifDrawable.setLoopCount(GifDrawable.LOOP_FOREVER);
                            imageView.setImageDrawable(resource);
                            gifDrawable.start();
                        }
                    }
                });
    }

    public static void TopDisplayRoundCorner(final Context context, String url, final ImageView imageView) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }


    /**
     * 清理图片磁盘缓存
     */
    public static void clearImageDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(context).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除图片内存缓存
     */
    public static void clearImageMemoryCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
