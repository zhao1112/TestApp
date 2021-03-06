package com.test.testapp.ui.main.my;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppApplication;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentMyBindingImpl;
import com.test.testapp.entity.login.UsersBean;
import com.test.testapp.ui.main.adapter.AlbumListAdapter;
import com.test.testapp.utils.ImageLoad;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:43
 */
public class MyFragment extends BaseFragment<FragmentMyBindingImpl, MyViewModel> {

    private UsersBean user;

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

    @Override
    public void initData() {
        super.initData();
        user = AppApplication.getInstance().getUser();

        initView();
    }

    private void initView() {
        ImageLoad.DisplayRoundCorner(getActivity(), user.getUsersHeard(), binding.ivUserHeard, 5);
        binding.tvUserName.setText(user.getUsersName());
        if (user.isAuthentication()) {
            binding.ivAuthentication.setImageResource(R.mipmap.img_certification);
        } else {
            binding.ivAuthentication.setImageResource(R.mipmap.img_nocertification);
        }
        binding.tvLookingNumber.setText(user.getLookingNumber() + "");
        binding.tvDynamicNumber.setText(user.getDynamicNumber() + "");
        binding.tvFlowercoin.setText(user.getFlowercoin() + "");

        if (user.getAlbumLists() != null && user.getAlbumLists().size() > 0) {
            binding.rvAlbum.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    binding.rvAlbum.getViewTreeObserver().removeOnPreDrawListener(this);
                    int width = binding.rvAlbum.getMeasuredWidth();
                    Log.d("width", "initData: " + width);
                    binding.rvAlbum.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    AlbumListAdapter albumListAdapter = new AlbumListAdapter(getActivity(), user.getAlbumLists(), width);
                    binding.rvAlbum.setAdapter(albumListAdapter);
                    return true;
                }
            });
        }
    }
}
