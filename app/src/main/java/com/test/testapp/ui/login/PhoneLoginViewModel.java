package com.test.testapp.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;
import com.test.testapp.ui.main.MainActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/1
 * Time: 15:16
 */
public class PhoneLoginViewModel extends BaseViewModel<AppRepository> {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //登录
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
        //获取验证码
        public SingleLiveEvent<String> obtainCode = new SingleLiveEvent<>();
    }

    public PhoneLoginViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }

    //登录
    public BindingCommand login = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pSwitchEvent.setValue(true);
        }
    });

    //获取验证码
    public BindingCommand obtaincode = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.obtainCode.setValue("1997");
        }
    });

    //密码登录
    public BindingCommand pwslogin = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(PasswordLoginActivity.class);
            finish();
        }
    });

    //注册
    public BindingCommand register = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(RegisterActivity.class);
            finish();
        }
    });

    public void getLogin(String phone, String code) {
        startActivity(MainActivity.class);
        finish();
    }
}
