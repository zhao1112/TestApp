package com.test.testapp.ui.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;
import com.test.testapp.ui.main.MainActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/5
 * Time: 10:11
 */
public class PasswordLoginViewModel extends BaseViewModel<AppRepository> {

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //登录
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
        //查看密码
        public SingleLiveEvent<Boolean> obtainCode = new SingleLiveEvent<>();
        //密码错误提示
        public SingleLiveEvent<Boolean> phonetips = new SingleLiveEvent<>();
    }

    public PasswordLoginViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);
    }

    //登录
    public BindingCommand login = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.pSwitchEvent.setValue(true);
        }
    });

    //查看密码
    public BindingCommand obtainCode = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            uc.obtainCode.setValue(uc.obtainCode.getValue() == null || !uc.obtainCode.getValue());
        }
    });

    public void getLogin(String phone, String code) {
        if (phone.equals("15006237888")&&code.equals("0000")){
            startActivity(MainActivity.class);
            finish();
        }else {
            uc.phonetips.setValue(true);
        }
    }

    //短信登录
    public BindingCommand phonelogin = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(PhoneLoginActivity.class);
            finish();
        }
    });

    //注册
    public BindingCommand register = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(RegisterActivity.class);
        }
    });


}
