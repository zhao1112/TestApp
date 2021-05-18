package com.test.testapp.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.test.testapp.data.AppRepository;
import com.test.testapp.ui.setting.SexSelectionActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/5
 * Time: 11:20
 */
public class RegisterViewModel extends BaseViewModel<AppRepository> {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //注册
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
        //获取验证码
        public SingleLiveEvent<String> obtainCode = new SingleLiveEvent<>();
    }

    public RegisterViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }

    //注册
    public BindingCommand register = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pSwitchEvent.setValue(true);
        }
    });

    //获取验证码
    public BindingCommand obtaincode = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.obtainCode.setValue("0000");
        }
    });

    public void getRegister(String phone, String code) {
//        try {
//            EMClient.getInstance().createAccount(phone, code);//同步方法
//        } catch (HyphenateException e) {
//            e.printStackTrace();
//        }
        startActivity(SexSelectionActivity.class);
        finish();
    }
}
