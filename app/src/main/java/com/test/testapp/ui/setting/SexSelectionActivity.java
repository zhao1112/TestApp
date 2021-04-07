package com.test.testapp.ui.setting;

import android.Manifest;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivitySexselectionBinding;
import com.test.testapp.utils.MmkvUtils;
import com.test.testapp.utils.StatusBarUtil;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/5
 * Time: 11:47
 */
public class SexSelectionActivity extends BaseActivity<ActivitySexselectionBinding, SexSelectionViewModel> {

    private String[] Permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private int sex = -1;
    public boolean SexSelect = false;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_sexselection;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusBarUtil.setStatusBar(this, false, R.color.color_181522, false);
    }

    @Override
    public SexSelectionViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(SexSelectionViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();

        binding.sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        sex = 0;
                        getRxPermissions();
                        break;
                    case R.id.gender:
                        sex = 1;
                        getRxPermissions();
                        break;
                }
            }
        });
    }

    public void getRxPermissions() {
        RxPermissions rxPermissions = new RxPermissions(SexSelectionActivity.this);
        rxPermissions.request(Permissions)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            if (sex == 0) {
                                MmkvUtils.getInstance().encode("SEX", 0);
                                SexSelect = true;
                            } else {
                                MmkvUtils.getInstance().encode("SEX", 1);
                                SexSelect = true;
                            }
                        }
                    }
                });
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.pSwitchEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (SexSelect) {
                    startActivity(ProfileActivity.class);
                } else {
                    ToastUtils.showShort("请选择您的性别");
                }
            }
        });
    }
}
