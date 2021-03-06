package com.test.testapp.ui.main.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentDataBinding;
import com.test.testapp.ui.details.DetailsActivity;
import com.test.testapp.ui.main.adapter.DataAdapter;
import com.test.testapp.utils.DataUtils;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 17:08
 */
public class DataFragment extends BaseFragment<FragmentDataBinding, DataViewModel> {

    private DataAdapter dataAdapter;

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
        //??????item ????????????
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        binding.rvList.setLayoutManager(layoutManager);
        binding.rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                layoutManager.invalidateSpanAssignments(); //???????????????????????????????????????
            }
        });

        dataAdapter = new DataAdapter();
        binding.rvList.setAdapter(dataAdapter);
        dataAdapter.setList(DataUtils.getInstance().initDataList(getActivity()).getData());
        dataAdapter.addChildClickViewIds(R.id.iv_icon);
        dataAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                switch (view.getId()){
                    case R.id.iv_icon:
                        startActivity(DetailsActivity.class);
                        break;
                }
            }
        });

        //??????
        binding.swView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataAdapter.setList(DataUtils.getInstance().initDataList(getActivity()).getData());
                        binding.swView.finishRefresh();
                    }
                }, 1500);
            }
        });
        //????????????
        binding.swView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataAdapter.addData(DataUtils.getInstance().initDataList(getActivity()).getData());
                        binding.swView.finishLoadMore();
                    }
                }, 1500);
            }
        });

    }

}
