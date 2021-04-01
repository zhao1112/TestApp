package com.test.testapp.ui;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityMainBinding;
import com.test.testapp.utils.StatusBarUtil;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private long mExitTime;       //实现“再按一次退出”的记录时间变量

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(MainViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        StatusBarUtil.setStatusBar(this, false, R.color.color_FFFFFF, true);
    }

    @Override //再按一次退出程序
    public void onBackPressed() {
        if (System.currentTimeMillis() - mExitTime < 2000) {
            super.onBackPressed();
        } else {
            mExitTime = System.currentTimeMillis();
            ToastUtils.showShort("再按一次返回键退出应用");
        }
    }
}
