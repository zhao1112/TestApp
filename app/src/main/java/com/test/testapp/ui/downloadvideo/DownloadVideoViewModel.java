package com.test.testapp.ui.downloadvideo;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/12
 * Time: 17:40
 */
public class DownloadVideoViewModel extends BaseViewModel<AppRepository> {


    public DownloadVideoViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }


}
