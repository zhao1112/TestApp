package com.test.testapp.ui.main.news;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentDynamicBinding;
import com.test.testapp.databinding.FragmentNewsBinding;
import com.test.testapp.ui.main.adapter.NewsAdapter;
import com.test.testapp.utils.DataUtils;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:43
 */
public class NewsFragment extends BaseFragment<FragmentNewsBinding, NewsViewModel> {

    private NewsAdapter newsAdapter;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_news;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public NewsViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(NewsViewModel.class);
    }

    @Override
    public void initData() {
        super.initData();

        initRecycle();
    }

    private void initRecycle() {
        newsAdapter = new NewsAdapter();

        binding.rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvNews.setAdapter(newsAdapter);
        newsAdapter.setList(DataUtils.getInstance().initNewsListBean(getActivity()).getData());

        //禁止加载更多
        binding.swView.setEnableLoadMore(false);
        //刷新
        binding.swView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        newsAdapter.setList(DataUtils.getInstance().initNewsListBean(getActivity()).getData());
                        binding.swView.finishRefresh();
                    }
                }, 1500);
            }
        });

    }
}
