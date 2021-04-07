package com.test.testapp.app;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.test.testapp.BuildConfig;
import com.test.testapp.entity.UsersBean;
import com.test.testapp.ui.main.MainActivity;
import com.test.testapp.R;
import com.test.testapp.utils.FilePutGetUtils;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * Created by goldze on 2017/7/16.
 */

public class AppApplication extends BaseApplication {

    private UsersBean user;
    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //
        MMKV.initialize(this);
        //是否开启打印日志
        KLog.init(BuildConfig.DEBUG);
        //初始化全局异常崩溃
        initCrash();
    }

    private void initCrash() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(false) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(MainActivity.class) //重新启动后的activity
                .apply();
    }

    public void setNullUser() {
        user = null;
        if (FilePutGetUtils.exists(getApplicationContext(), "app_user.json")) {
            FilePutGetUtils.deleteFile(this.getApplicationContext(), "app_user.json");
        }
    }

    public synchronized UsersBean getUser() {
        if (user == null) {
            String content = FilePutGetUtils.readFile(this.getApplicationContext(), "app_user.json");
            try {
                if (content != null && !content.equals("")) {
                    user = new Gson().fromJson(content, UsersBean.class);
                }
            } catch (Exception e) {
            }
        }
        return user;
    }

    public void setUser(UsersBean user) {
        this.user = user;
        String jsonObject = new Gson().toJson(user);
        FilePutGetUtils.writeFile(this.getApplicationContext(), "app_user.json", jsonObject);
    }
}
