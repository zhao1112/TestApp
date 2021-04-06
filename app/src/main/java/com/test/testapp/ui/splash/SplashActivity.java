package com.test.testapp.ui.splash;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivitySplashBinding;
import com.test.testapp.ui.main.MainActivity;
import com.test.testapp.utils.ImageLoad;
import com.test.testapp.utils.StatusBarUtil;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/3/31
 * Time: 16:09
 */
public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> {

    private int timer = 0;
    private String ImageUrl = "https://up.enterdesk.com/edpic/09/1c/e6/091ce634a32396eddad1c4dea231005f.jpg";

    private String[] permissionArray = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA
    };

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SplashViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(SplashViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();
        StatusBarUtil.setStatusBar(this, true, R.color.color_FFFFFF, false);

        ImageLoad.display(this, ImageUrl, binding.ivSplash);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.requestCameraPermissions.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                requestCameraPermissions();
                KLog.e("requestCameraPermissions");
            }
        });
    }

    /**
     * 请求相机权限
     */
    private void requestCameraPermissions() {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions(SplashActivity.this);
        rxPermissions.request(permissionArray)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        handler.sendEmptyMessageDelayed(0, 1000);
                    }
                });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    timer++;
                    if (timer >= 3) {
                        handler.removeMessages(0);
                        startActivity(MainActivity.class);
                        finish();
                    } else {
                        handler.sendEmptyMessageDelayed(0, 1000);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler = null;
    }
}
