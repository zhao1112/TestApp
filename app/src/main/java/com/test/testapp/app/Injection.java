package com.test.testapp.app;

import com.test.testapp.data.AppRepository;
import com.test.testapp.data.source.HttpDataSource;
import com.test.testapp.data.source.http.HttpDataSourceImpl;
import com.test.testapp.data.source.http.RetrofitClient;
import com.test.testapp.data.source.http.service.AppApiService;

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static AppRepository provideDemoRepository() {
        //网络API服务
        AppApiService apiService = RetrofitClient.getInstance().create(AppApiService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //两条分支组成一个数据仓库
        return AppRepository.getInstance(httpDataSource);
    }
}
