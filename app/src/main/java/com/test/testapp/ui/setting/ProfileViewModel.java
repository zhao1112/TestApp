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
 * Date: 2021/2/6
 * Time: 10:29
 */
public class ProfileViewModel extends BaseViewModel<AppRepository> {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //性别选择
        public SingleLiveEvent<Boolean> setHeard = new SingleLiveEvent<>();
        //城市
        public SingleLiveEvent<Integer> setSelect = new SingleLiveEvent<>();

        public SingleLiveEvent<Boolean> liveEvent = new SingleLiveEvent();
    }

    public ProfileViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }

    public BindingCommand back = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });

    //确定
    public BindingCommand complete = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.liveEvent.setValue(true);
        }
    });

    //保存
    public BindingCommand preservation = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.liveEvent.setValue(true);
        }
    });

    //头像
    public BindingCommand heard = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.setHeard.setValue(true);
        }
    });


    // 年龄选择
    public BindingCommand age = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.setSelect.setValue(0);
        }
    });

    //城市选择
    public BindingCommand city = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.setSelect.setValue(1);
        }
    });

    //职业
    public BindingCommand occupation = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.setSelect.setValue(2);
        }
    });

    //身高
    public BindingCommand cm = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.setSelect.setValue(3);
        }
    });

    //体重
    public BindingCommand weight = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.setSelect.setValue(4);
        }
    });


}
