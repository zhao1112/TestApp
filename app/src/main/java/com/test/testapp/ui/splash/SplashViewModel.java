package com.test.testapp.ui.splash;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/3/31
 * Time: 16:09
 */
public class SplashViewModel extends BaseViewModel<AppRepository> {

    //使用Observable
    public SingleLiveEvent<Boolean> requestCameraPermissions = new SingleLiveEvent<>();

    public SplashViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);

        requestCameraPermissions.call();
    }
}
