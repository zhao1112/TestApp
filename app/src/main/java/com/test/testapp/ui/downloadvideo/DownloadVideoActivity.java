package com.test.testapp.ui.downloadvideo;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.test.testapp.BR;
import com.test.testapp.R;
import com.test.testapp.app.AppViewModelFactory;
import com.test.testapp.databinding.ActivityDownloadVideoBinding;
import com.test.testapp.utils.DownloadUtil;

import java.io.File;

import cc.shinichi.library.tool.ui.ToastUtil;
import me.goldze.mvvmhabit.base.BaseActivity;
import retrofit2.http.PUT;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/12
 * Time: 17:38
 */
public class DownloadVideoActivity extends BaseActivity<ActivityDownloadVideoBinding, DownloadVideoViewModel> {

    private String path = Environment.getExternalStorageDirectory().getPath() + "/Video";

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_download_video;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }

    @Override
    public DownloadVideoViewModel initViewModel() {
        AppViewModelFactory instance = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, instance).get(DownloadVideoViewModel.class);
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
                        DownloadUtil.getInstance().download(binding.etUrl.getText().toString().trim(), path, binding.etName.getText().toString().trim() + ".mp4", new DownloadUtil.OnDownloadListener() {
                            @Override
                            public void onDownloadSuccess(File file) {
                                //????????????
                                Log.i("downFile", "onDownloadSuccess:....... ..................??????????????????..............................");
                                ToastUtil.getInstance()._short(DownloadVideoActivity.this, "??????????????????");
                            }

                            @Override
                            public void onDownloading(int progress) {
                                //?????????
                                Log.i("downFile", "onDownloading:..............................???????????????................................" + progress);
                            }

                            @Override
                            public void onDownloadFailed(Exception e) {
                                //????????????????????????????????????
                                Log.e("downFile", "onDownloadFailed:..........................??????????????????..............................." + e.getMessage());
                                ToastUtil.getInstance()._short(DownloadVideoActivity.this, "??????????????????");
                            }
                        });
                    }
                }).start();
            }
        });
    }

}
