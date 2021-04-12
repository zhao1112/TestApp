package com.test.testapp.ui.main.home;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;
import com.test.testapp.ui.downloadvideo.DownloadVideoActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:09
 */
public class HomeViewModel extends BaseViewModel<AppRepository> {

    public HomeViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }

    public BindingCommand download = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(DownloadVideoActivity.class);
        }
    });
}
