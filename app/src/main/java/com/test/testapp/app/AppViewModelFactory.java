package com.test.testapp.app;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.test.testapp.data.AppRepository;
import com.test.testapp.ui.login.PasswordLoginViewModel;
import com.test.testapp.ui.login.PhoneLoginViewModel;
import com.test.testapp.ui.login.RegisterViewModel;
import com.test.testapp.ui.main.MainViewModel;
import com.test.testapp.ui.main.dynamic.DynamicViewModel;
import com.test.testapp.ui.main.home.DataViewModel;
import com.test.testapp.ui.main.home.HomeViewModel;
import com.test.testapp.ui.main.my.MyViewModel;
import com.test.testapp.ui.main.news.NewsViewModel;
import com.test.testapp.ui.splash.SplashViewModel;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final AppRepository mRepository;

    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, AppRepository repository) {
        this.mApplication = application;
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            return (T) new SplashViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(PhoneLoginViewModel.class)) {
            return (T) new PhoneLoginViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(DynamicViewModel.class)) {
            return (T) new DynamicViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(NewsViewModel.class)) {
            return (T) new NewsViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(MyViewModel.class)) {
            return (T) new MyViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(DataViewModel.class)) {
            return (T) new DataViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(PasswordLoginViewModel.class)) {
            return (T) new PasswordLoginViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(RegisterViewModel.class)) {
            return (T) new RegisterViewModel(mApplication, mRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
