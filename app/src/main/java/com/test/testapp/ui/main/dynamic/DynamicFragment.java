package com.test.testapp.ui.main.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentDynamicBinding;
import com.test.testapp.entity.ResDatas;
import com.test.testapp.ui.main.adapter.DynamicAdapter;
import com.test.testapp.utils.DataUtils;
import com.test.testapp.utils.ImageLoad;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void initData() {
        super.initData();

        initBanner();
        initView();
    }

    private void initView() {
        binding.rcView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DynamicAdapter dynamicAdapter = new DynamicAdapter();
        binding.rcView.setAdapter(dynamicAdapter);

        dynamicAdapter.setList(DataUtils.getInstance().initDynamicBean(getActivity()).getData());
    }

    private void initBanner() {
        binding.banner
                .setAdapter(new BannerImageAdapter<String>(ResDatas.getBannerImages()) {

                    @Override
                    public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                        ImageLoad.DisplayRoundCorner(getActivity(), data, (ImageView) holder.itemView, 10);
                    }
                })
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(getActivity()));
    }
}
