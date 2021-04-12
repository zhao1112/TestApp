package com.test.testapp.ui.main.dynamic;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.FragmentDynamicBinding;
import com.test.testapp.utils.DownloadUtil;

import java.io.File;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/6
 * Time: 15:43
 */
public class DynamicFragment extends BaseFragment<FragmentDynamicBinding, DynamicViewModel> {

    private String path = Environment.getExternalStorageDirectory().getPath() + "/Video";
//    private String url = "https://mp4i.vodfile.m1905.com/202104130342/ebe0be3acccaf92ea3d330c6e200f652/video/2021/03/26/v20210326YQVKMGRYA51OHSIK/v20210326YQVKMGRYA51OHSIK.mp4";
    private String url = "https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813";

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


        binding.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {


                    @Override
                    public void run() {
                        DownloadUtil.getInstance().download(url, path, "一年到头.mp4", new DownloadUtil.OnDownloadListener() {
                            @Override
                            public void onDownloadSuccess(File file) {
                                //下载成功
                                Log.i("downFile", "onDownloadSuccess:....... ..................文件下载成功..............................");
                            }

                            @Override
                            public void onDownloading(int progress) {
                                //下载中
                                Log.i("downFile", "onDownloading:..............................文件下载中................................" + progress);
                            }

                            @Override
                            public void onDownloadFailed(Exception e) {
                                //下载异常进行相关提示操作
                                Log.e("downFile", "onDownloadFailed:..........................下载文件失败..............................." + e.getMessage());
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
