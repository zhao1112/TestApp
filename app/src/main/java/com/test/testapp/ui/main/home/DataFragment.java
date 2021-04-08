package com.test.testapp.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentDataBinding;
import com.test.testapp.entity.DataListBean;
import com.test.testapp.ui.main.adapter.DataAdapter;
import com.test.testapp.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 17:08
 */
public class DataFragment extends BaseFragment<FragmentDataBinding, DataViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_data;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public DataViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(DataViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();

        initView();
    }

    private void initView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //防止item 交换位置
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        binding.rvList.setLayoutManager(layoutManager);
        binding.rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                layoutManager.invalidateSpanAssignments(); //防止第一行到顶部有空白区域
            }
        });

        DataAdapter dataAdapter = new DataAdapter();
        dataAdapter.setList( DataUtils.getInstance().initDataList(getActivity()).getData());

        binding.rvList.setAdapter(dataAdapter);
    }

}
