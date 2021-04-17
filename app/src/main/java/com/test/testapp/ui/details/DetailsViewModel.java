package com.test.testapp.ui.details;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/17
 * Time: 14:40
 */
public class DetailsViewModel extends BaseViewModel<AppRepository> {

    public DetailsViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }
}
