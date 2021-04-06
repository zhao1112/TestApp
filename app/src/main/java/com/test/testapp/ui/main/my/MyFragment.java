package com.test.testapp.ui.main.my;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentNewsBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:43
 */
public class MyFragment extends BaseFragment<FragmentNewsBinding, MyViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_my;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public MyViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(MyViewModel.class);
    }
}
