package com.test.testapp.ui.setting;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.donkingliang.imageselector.utils.ImageSelector;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppApplication;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityProfileBinding;
import com.test.testapp.entity.setting.AgeBean;
import com.test.testapp.entity.setting.CitysBean;
import com.test.testapp.entity.login.UsersBean;
import com.test.testapp.ui.main.MainActivity;
import com.test.testapp.utils.DataUtils;
import com.test.testapp.utils.ImageLoad;
import com.test.testapp.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/6
 * Time: 10:19
 */
public class ProfileActivity extends BaseActivity<ActivityProfileBinding, ProfileViewModel> {

    private String[] Permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    /**
     * 城市
     */
    private List<CitysBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    /**
     * 年龄，职业
     */
    private ArrayList<AgeBean> ageBeans;

    private OptionsPickerView pickerView;
    private int type;//选择类型
    private String opt1tx;
    private String opt2tx;
    private String opt3tx;
    private UsersBean usersBean = new UsersBean();


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_profile;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public ProfileViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(ProfileViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusBarUtil.setStatusBar(this, false, R.color.color_181522, false);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        //选择头像
        viewModel.uc.setHeard.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                getRxPermissions();
            }
        });
        //选择
        viewModel.uc.setSelect.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                switch (integer) {
                    case 0:
                        type = 0;
                        ageBeans = DataUtils.getInstance().initAgeData();
                        break;
                    case 1:
                        type = 1;
                        DataUtils.getInstance().initJsonData(ProfileActivity.this, options1Items, options2Items, options3Items);
                        break;
                    case 2:
                        type = 2;
                        ageBeans = DataUtils.getInstance().initOccupationData();
                        break;
                    case 3:
                        type = 3;
                        ageBeans = DataUtils.getInstance().initCMData();
                        break;
                    case 4:
                        type = 4;
                        ageBeans = DataUtils.getInstance().initWeightData();
                        break;
                }
                showPickerView();
            }
        });
        //存储数据
        viewModel.uc.liveEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                storageData();
            }
        });
    }

    public void getRxPermissions() {
        RxPermissions rxPermissions = new RxPermissions(ProfileActivity.this);
        rxPermissions.request(Permissions)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            chooseImage();
                        } else {
                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

    // 去选择图片
    private void chooseImage() {
        ImageSelector.builder()
                .useCamera(true)
                .setCrop(true)
                .setCropRatio(1.0f)
                .canPreview(true)
                .start(this, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> images = data.getStringArrayListExtra(ImageSelector.SELECT_RESULT);
                ImageLoad.DisplayCircle(this, images.get(0), binding.heard);
                usersBean.setUsersHeard(images.get(0));
            }
        }
    }

    private void showPickerView() {// 弹出选择器
        pickerView = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                switch (type) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                        opt1tx = ageBeans.size() > 0 ? ageBeans.get(options1).getPickerViewText() : "";
                        break;
                    case 1:
                        opt1tx = options1Items.size() > 0 ? options1Items.get(options1).getPickerViewText() : "";
                        opt2tx = options2Items.size() > 0 && options2Items.get(options1).size() > 0 ? options2Items.get(options1).get(options2) : "";
                        opt3tx = options2Items.size() > 0 && options3Items.get(options1).size() > 0 && options3Items.get(options1).get(options2).size() > 0 ? options3Items.get(options1).get(options2).get(options3) : "";
                        break;
                }
                switch (type) {
                    case 0:
                        binding.tvAge.setText(opt1tx);
                        break;
                    case 1:
                        binding.tvCity.setText(opt1tx + opt2tx + opt3tx);
                        break;
                    case 2:
                        binding.tvOccupation.setText(opt1tx);
                        break;
                    case 3:
                        binding.tvCm.setText(opt1tx);
                        break;
                    case 4:
                        binding.tvWeight.setText(opt1tx);
                        break;
                }
            }
        }).setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
            @Override
            public void customLayout(View v) {
                final TextView tvSubmit = v.findViewById(R.id.tv_finish);
                final TextView tvAdd = v.findViewById(R.id.iv_cancel);
                tvSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pickerView.returnData();
                        pickerView.dismiss();
                    }
                });
                tvAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setdata();
                    }
                });
            }
        })
                .setTextColorCenter(ProfileActivity.this.getResources().getColor(R.color.color_9A7CFE))
                .setTextColorOut(ProfileActivity.this.getResources().getColor(R.color.color_767B89))
                .setDividerColor(ProfileActivity.this.getResources().getColor(R.color.color_9A7CFE))
                .setContentTextSize(20)
                .setOutSideCancelable(false)
                .build();
        setdata();
        pickerView.show();
    }

    public void setdata() {
        switch (type) {
            case 0:
            case 2:
            case 3:
            case 4:
                pickerView.setPicker(ageBeans);//添加数据
                break;
            case 1:
                pickerView.setPicker(options1Items, options2Items, options3Items);//添加数据
                break;
        }
    }

    public void storageData() {
        if (usersBean.getUsersHeard() == null || usersBean.getUsersHeard() == "") {
            ToastUtils.showShort("请选择头像");
            return;
        }
        if (TextUtils.isEmpty(binding.name.getText().toString().trim())) {
            ToastUtils.showShort("请填写名称");
            return;
        }
        if (TextUtils.isEmpty(binding.tvAge.getText().toString().trim())) {
            ToastUtils.showShort("请选择年龄");
            return;
        }
        if (TextUtils.isEmpty(binding.tvCity.getText().toString().trim())) {
            ToastUtils.showShort("请选择城市");
            return;
        }
        if (TextUtils.isEmpty(binding.tvOccupation.getText().toString().trim())) {
            ToastUtils.showShort("请选择身份");
            return;
        }
        if (TextUtils.isEmpty(binding.tvCm.getText().toString().trim())) {
            ToastUtils.showShort("请选择身高");
            return;
        }
        if (TextUtils.isEmpty(binding.tvWeight.getText().toString().trim())) {
            ToastUtils.showShort("请选择体重");
            return;
        }
        if (TextUtils.isEmpty(binding.weixin.getText().toString().trim())) {
            ToastUtils.showShort("请填写微信");
            return;
        }
        if (TextUtils.isEmpty(binding.etQq.getText().toString().trim())) {
            ToastUtils.showShort("请填写QQ");
            return;
        }

        usersBean.setUsersName(binding.name.getText().toString().trim());
        usersBean.setAge(binding.tvAge.getText().toString().trim());
        usersBean.setCity(binding.tvCity.getText().toString().trim());
        usersBean.setOccupation(binding.tvOccupation.getText().toString().trim());
        usersBean.setCm(binding.tvCm.getText().toString().trim());
        usersBean.setUsersWeight(binding.tvWeight.getText().toString().trim());
        usersBean.setWeixin(binding.weixin.getText().toString().trim());
        usersBean.setQq(binding.etQq.getText().toString().trim());

        AppApplication.getInstance().setUser(usersBean);

        startActivity(MainActivity.class);
        finish();
    }
}
