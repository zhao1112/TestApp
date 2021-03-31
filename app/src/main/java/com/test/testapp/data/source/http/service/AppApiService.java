package com.test.testapp.data.source.http.service;

import com.test.testapp.entity.DemoEntity;
import com.test.testapp.entity.ShopBean;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by goldze on 2017/6/15.
 */

public interface AppApiService {
    @GET("api/shopshowmodel/shopshowmodel/getshopmodelmodule")
    Observable<BaseResponse<ShopBean>> demoGet(@Query("shopId") String shopId);

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<DemoEntity>> demoPost(@Field("catalog") String catalog);
}
