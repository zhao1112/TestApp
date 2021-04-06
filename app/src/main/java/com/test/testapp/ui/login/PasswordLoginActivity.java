package com.test.testapp.ui.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityPasswordloginBinding;
import com.test.testapp.utils.RegularUtils;
import com.test.testapp.utils.StatusBarUtil;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/5
 * Time: 10:10
 */
public class PasswordLoginActivity extends BaseActivity<ActivityPasswordloginBinding, PasswordLoginViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_passwordlogin;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public PasswordLoginViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(PasswordLoginViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusBarUtil.setStatusBar(this, true, R.color.color_FFFFFF, false);
    }

    @Override
    public void initData() {
        super.initData();
        binding.phone.addTextChangedListener(new MyTextWatcher());
        binding.code.addTextChangedListener(new MyTextWatcher());
    }

    public class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (binding.phone.length() == 11) {
                if (!RegularUtils.isPhoneNumber(binding.phone.getText().toString().trim())) {
                    binding.phoneTips.setVisibility(View.VISIBLE);
                }
            } else {
                binding.phoneTips.setVisibility(View.GONE);
            }

            binding.pwstips.setVisibility(View.GONE);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        //登录
        viewModel.uc.pSwitchEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (TextUtils.isEmpty(binding.phone.getText().toString().trim())) {
                    ToastUtils.showShort("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(binding.code.getText().toString().trim())) {
                    ToastUtils.showShort("请输入密码");
                    return;
                }
                if (!binding.privacy.isChecked()) {
                    ToastUtils.showShort("登录前请阅读隐私协议并同意");
                    return;
                }
                viewModel.getLogin(binding.phone.getText().toString().trim(), binding.code.getText().toString().trim());
            }
        });
        //账号密码错误提示
        viewModel.uc.phonetips.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.pwstips.setVisibility(View.VISIBLE);
            }
        });
        //查看密码
        viewModel.uc.obtainCode.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (viewModel.uc.obtainCode.getValue()) {
                    binding.seepws.setImageResource(R.mipmap.icon_show);
                    binding.code.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    binding.seepws.setImageResource(R.mipmap.icon_hide);
                    binding.code.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

}
