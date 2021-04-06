package com.test.testapp.ui.main.dynamic;

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
public class DynamicViewModel extends BaseViewModel<AppRepository> {
    public DynamicViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }
}
