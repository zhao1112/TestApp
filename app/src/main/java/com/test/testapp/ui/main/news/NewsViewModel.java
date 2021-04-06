package com.test.testapp.ui.main.news;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:43
 */
public class NewsViewModel extends BaseViewModel<AppRepository> {
    public NewsViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }
}
