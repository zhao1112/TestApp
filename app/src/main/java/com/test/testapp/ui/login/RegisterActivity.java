package com.test.testapp.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityRegisterBinding;
import com.test.testapp.utils.RegularUtils;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

import static com.test.testapp.utils.StatusBarUtil.setStatusBar;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/5
 * Time: 11:19
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> {

    public CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            binding.obtaincode.setText(millisUntilFinished / 1000 + "S重试");
        }

        @Override
        public void onFinish() {
            binding.obtaincode.setText("获取验证码");
            binding.obtaincode.setEnabled(true);
        }
    };

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_register;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public RegisterViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(RegisterViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStatusBar(this, true, 0, false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer = null;
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

            if (binding.code.length() == 4) {
                if (!binding.code.getText().toString().trim().equals("1234")) {
                    binding.codeTips.setVisibility(View.VISIBLE);
                }
            } else {
                binding.codeTips.setVisibility(View.GONE);
            }
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
                if (binding.phone.getText().toString().trim().length() < 11) {
                    binding.phoneTips.setVisibility(View.VISIBLE);
                    return;
                }
                if (TextUtils.isEmpty(binding.code.getText().toString().trim())) {
                    ToastUtils.showShort("请输入验证码");
                    return;
                }
                if (!binding.privacy.isChecked()) {
                    ToastUtils.showShort("登录前请阅读隐私协议并同意");
                    return;
                }
                viewModel.getRegister(binding.phone.getText().toString().trim(), binding.code.getText().toString().trim());
            }
        });
        //获取验证码
        viewModel.uc.obtainCode.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (TextUtils.isEmpty(binding.phone.getText().toString().trim())) {
                    ToastUtils.showShort("请输入手机号");
                    return;
                }
                timer.start();
                binding.obtaincode.setEnabled(false);
            }
        });
    }
}
