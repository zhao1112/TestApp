package com.test.testapp.ui.setting;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/5
 * Time: 11:49
 */
public class SexSelectionViewModel extends BaseViewModel<AppRepository> {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //性别选择
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
    }

    public SexSelectionViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }

    public BindingCommand back = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    //完成
    public BindingCommand complete = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pSwitchEvent.setValue(true);
        }
    });
}
