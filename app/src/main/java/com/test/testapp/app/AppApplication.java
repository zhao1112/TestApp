package com.test.testapp.app;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.igexin.sdk.IUserLoggerInterface;
import com.igexin.sdk.PushManager;
import com.tencent.mmkv.MMKV;
import com.test.testapp.BuildConfig;
import com.test.testapp.entity.login.UsersBean;
import com.test.testapp.ui.main.MainActivity;
import com.test.testapp.R;
import com.test.testapp.utils.FilePutGetUtils;

import java.util.Iterator;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * Created by goldze on 2017/7/16.
 */

public class AppApplication extends BaseApplication {

    private UsersBean user;
    private static AppApplication instance;
    int pid = android.os.Process.myPid();

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
        //个推
        initSdk();
        //环信
//        initHx();
    }

    private void initHx() {
        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
        // 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
        options.setAutoTransferMessageAttachments(true);
        // 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
        options.setAutoDownloadThumbnail(true);
        if (getAppName(pid) == null || !getAppName(pid).equalsIgnoreCase(this.getPackageName())) {
            Log.e("AppApplication", "enter the service process!");
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }
        //初始化
        EMClient.getInstance().init(this, options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }

    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

    private void initSdk() {
        Log.d("AppApplication", "initializing sdk...");
        PushManager.getInstance().initialize(this);
        if (BuildConfig.DEBUG) {
            //切勿在 release 版本上开启调试日志
            PushManager.getInstance().setDebugLogger(this, new IUserLoggerInterface() {
                @Override
                public void log(String s) {
                    Log.d("AppApplication", "initializing " + s);
                }
            });
        }
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
