package com.test.testapp.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/1
 * Time: 15:16
 */
public class PhoneLoginViewModel extends BaseViewModel<AppRepository> {
    public PhoneLoginViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }
}
