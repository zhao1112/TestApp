package com.test.testapp.ui.main.adapter;

import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.testapp.R;
import com.test.testapp.entity.home.DataListBean;
import com.test.testapp.utils.ImageLoad;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/7
 * Time: 14:18
 */
public class DataAdapter extends BaseQuickAdapter<DataListBean.DataBean, BaseViewHolder> {

    public DataAdapter() {
        super(R.layout.item_data_list);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, DataListBean.DataBean dataBean) {

        ImageView rlview = baseViewHolder.findView(R.id.iv_icon);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rlview.getLayoutParams();
        params.height = dataBean.getImageHeight();
        rlview.setLayoutParams(params);

        ImageLoad.TopDisplayRoundCorner(getContext(), dataBean.getImageLoad(), rlview);

        ImageView iv_authentication = baseViewHolder.findView(R.id.iv_authentication);
        if (dataBean.isIsAuthentication()) {
            iv_authentication.setImageResource(R.mipmap.img_certification);
        } else {
            iv_authentication.setImageResource(R.mipmap.img_nocertification);
        }

        baseViewHolder.setText(R.id.tv_name, dataBean.getName())
                .setText(R.id.tv_photo, dataBean.getPhotoNumber() + "")
                .setText(R.id.tv_video, dataBean.getVideoNumber() + "")
                .setText(R.id.tv_age, dataBean.getAge() + "")
                .setText(R.id.tv_occupation, dataBean.getOccupation())
                .setText(R.id.tv_address, dataBean.getAddress())
                .setText(R.id.tv_distance, dataBean.getDistance());

        if (dataBean.isIsOnline()) {
            baseViewHolder.setText(R.id.tv_online, "在线");
        } else {
            baseViewHolder.setText(R.id.tv_online, "离线");
        }

    }
}
