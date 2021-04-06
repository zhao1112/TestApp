package com.test.testapp.ui.main.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentDynamicBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:43
 */
public class DynamicFragment extends BaseFragment<FragmentDynamicBinding, DynamicViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_dynamic;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public DynamicViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(DynamicViewModel.class);
    }
}
