package com.test.testapp.ui.main.home;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 17:10
 */
public class DataViewModel extends BaseViewModel<AppRepository> {
    public DataViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }
}
