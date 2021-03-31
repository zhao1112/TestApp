package com.test.testapp.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.test.testapp.data.source.HttpDataSource;
import com.test.testapp.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class AppRepository extends BaseModel implements HttpDataSource {

    private volatile static AppRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private AppRepository(@NonNull HttpDataSource httpDataSource) {
        this.mHttpDataSource = httpDataSource;
    }

    public static AppRepository getInstance(HttpDataSource httpDataSource) {
        if (INSTANCE == null) {
            synchronized (AppRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppRepository(httpDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return null;
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return null;
    }
}
