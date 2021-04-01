package com.test.testapp.ui.login;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityPhoneLoginBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/1
 * Time: 15:14
 */
public class PhoneLoginActivity extends BaseActivity<ActivityPhoneLoginBinding, PhoneLoginViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_phone_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public PhoneLoginViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(PhoneLoginViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }

    @Override
    public void initData() {
        super.initData();
    }


}
