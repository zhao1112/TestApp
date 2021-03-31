package com.test.testapp.data.source;


import com.test.testapp.entity.DemoEntity;
import com.test.testapp.entity.ShopBean;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {

    Observable<BaseResponse<ShopBean>> demoGet(String shopId);

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);

}
