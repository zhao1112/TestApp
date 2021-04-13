package com.test.testapp.ui.main;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityMainBinding;
import com.test.testapp.ui.main.dynamic.DynamicFragment;
import com.test.testapp.ui.main.home.HomeFragment;
import com.test.testapp.ui.main.my.MyFragment;
import com.test.testapp.ui.main.news.NewsFragment;
import com.test.testapp.utils.StatusBarUtil;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;

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
        StatusBarUtil.setStatusBar(this, false, R.color.color_14121E, false);

        //初始化底部Button
        initBottomTab();
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.tab.custom()
                .addItem(newItem(R.mipmap.btn_home_nor, R.mipmap.btn_home_pre, "首页"))
                .addItem(newItem(R.mipmap.btn_dynamic_nor, R.mipmap.btn_dynamic_pre, "动态"))
                .addItem(newItem(R.mipmap.btn_message_nor, R.mipmap.btn_message_pre, "消息"))
                .addItem(newItem(R.mipmap.btn_my_nor, R.mipmap.btn_my_pre, "我的"))
                .build();

        binding.viewPager.setAdapter(new TestViewPagerAdapter(getSupportFragmentManager(), navigationController.getItemCount()));
        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(binding.viewPager);
    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.parseColor("#595179"));
        normalItemView.setTextCheckedColor(Color.parseColor("#9A7CFE"));
        return normalItemView;
    }

    public class TestViewPagerAdapter extends FragmentPagerAdapter {

        private int size;

        public TestViewPagerAdapter(FragmentManager fm, int size) {
            super(fm);
            this.size = size;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new DynamicFragment();
                case 2:
                    return new NewsFragment();
                case 3:
                    return new MyFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return size;
        }
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
