package com.test.testapp.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;

import com.test.testapp.data.AppRepository;
import com.test.testapp.entity.ShopBean;

import io.reactivex.observers.DisposableObserver;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.RxUtils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/3/31
 * Time: 15:35
 */
public class MainViewModel extends BaseViewModel<AppRepository> {

    public MainViewModel(@NonNull Application application, AppRepository model) {
        super(application, model);

        initGet();
    }

    private void initGet() {
        model.demoGet("739072031093424128")
                .compose(RxUtils.schedulersTransformer())
                .compose(RxUtils.exceptionTransformer())
                .doOnSubscribe(this)
                .subscribe(new DisposableObserver<BaseResponse<ShopBean>>() {

                    @Override
                    public void onNext(BaseResponse<ShopBean> shopBeanBaseResponse) {
                        if (shopBeanBaseResponse.getCode() == 0) {
                            KLog.e("-----" + shopBeanBaseResponse.getResult().getShopModel().getSId());
                        } else {
                            KLog.e("請求錯誤");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
