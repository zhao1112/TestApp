package com.test.testapp.ui.details;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppApplication;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityDetailsBinding;
import com.test.testapp.entity.login.UsersBean;
import com.test.testapp.ui.details.adapter.DynamicListAdapter;
import com.test.testapp.ui.details.adapter.PhotoistAdapter;
import com.test.testapp.utils.ImageLoad;
import com.test.testapp.utils.StatusBarUtil;

import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/17
 * Time: 14:38
 */
public class DetailsActivity extends BaseActivity<ActivityDetailsBinding, DetailsViewModel> {

    private UsersBean user;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_details;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public DetailsViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(DetailsViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusBarUtil.setStatusBar(DetailsActivity.this, true, 0, false);
    }

    @Override
    public void initData() {
        super.initData();

        user = AppApplication.getInstance().getUser();

        ImageLoad.DisplayRoundCorner(DetailsActivity.this, "http://gank.io/images/f12526b3e9654a47842db6ce21222874", binding.ivHeard, 6);

        PhotoistAdapter photoistAdapter = new PhotoistAdapter(DetailsActivity.this, user.getAlbumLists());
        binding.rvPhoto.setLayoutManager(new GridLayoutManager(DetailsActivity.this, 3));
        binding.rvPhoto.setAdapter(photoistAdapter);

        DynamicListAdapter dynamicListAdapter = new DynamicListAdapter(DetailsActivity.this, user.getAlbumLists());
        binding.rvDynamic.setLayoutManager(new LinearLayoutManager(DetailsActivity.this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvDynamic.setAdapter(dynamicListAdapter);
    }
}
