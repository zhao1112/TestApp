package com.test.testapp.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentHomeBinding;
import com.test.testapp.ui.main.dynamic.DynamicFragment;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:07
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {

    private String[] pageTitle = new String[]{"推荐", "新人", "附近"};


    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_home;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public HomeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(HomeViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();

        initView();
    }

    private void initView() {
        for (int i = 0; i < pageTitle.length; i++) {
            binding.xlClass.addTab(binding.xlClass.newTab().setText(pageTitle[i]));
        }

        binding.pager.setAdapter(new MyPageAdapter(getChildFragmentManager()));
        binding.pager.setOffscreenPageLimit(3);
        binding.xlClass.setupWithViewPager(binding.pager);
    }

    public class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return pageTitle.length;
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new DataFragment();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitle[position];
        }
    }
}
