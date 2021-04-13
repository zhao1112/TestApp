package com.test.testapp.ui.main.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.testapp.R;
import com.test.testapp.entity.dynamic.DynamicBean;
import com.test.testapp.utils.ImageLoad;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/13
 * Time: 10:49
 */
public class DynamicAdapter extends BaseQuickAdapter<DynamicBean.DataBean, BaseViewHolder> {

    public DynamicAdapter() {
        super(R.layout.item_dynamic_list);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, DynamicBean.DataBean dataBean) {
        //基础信息
        ImageLoad.DisplayRoundCorner(getContext(), dataBean.getHeardLoader(), baseViewHolder.findView(R.id.iv_heard), 5);
        baseViewHolder.setText(R.id.tv_name, dataBean.getName())
                .setText(R.id.tv_age, dataBean.getAge() + "")
                .setText(R.id.tv_occupation, dataBean.getOccupation());
        //认证
        ImageView iv_authentication = baseViewHolder.findView(R.id.iv_authentication);
        if (dataBean.isAuthentication()) {
            iv_authentication.setImageResource(R.mipmap.img_certification);
        } else {
            iv_authentication.setImageResource(R.mipmap.img_nocertification);
        }
        //参与
        TextView tv_participate = baseViewHolder.findView(R.id.tv_participate);
        if (!TextUtils.isEmpty(dataBean.getParticipate())) {
            switch (dataBean.getParticipate()) {
                case "01":
                    tv_participate.setText("报名中");
                    break;
                case "02":
                    tv_participate.setText("已报名");
                    tv_participate.setBackground(getContext().getResources().getDrawable(R.drawable.ic_dynamic_icon));
                    break;
            }
            tv_participate.setVisibility(View.VISIBLE);
        } else {
            tv_participate.setVisibility(View.GONE);
        }
        //主题
        TagFlowLayout tf_theme = baseViewHolder.findView(R.id.tf_theme);
        tf_theme.setAdapter(new TagAdapter<String>(dataBean.getThemeList()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_tag_view, tf_theme, false);
                TextView tv_view = view.findViewById(R.id.tv_view);
                tv_view.setText(s);
                return view;
            }
        });
        //条件
        TagFlowLayout tf_appointment = baseViewHolder.findView(R.id.tf_appointment);
        tf_appointment.setAdapter(new TagAdapter<String>(dataBean.getConditionList()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_tag_view, tf_appointment, false);
                TextView tv_view = view.findViewById(R.id.tv_view);
                tv_view.setText(s);
                return view;
            }
        });
        //城市
        TagFlowLayout tf_city = baseViewHolder.findView(R.id.tf_city);
        tf_city.setAdapter(new TagAdapter<String>(dataBean.getTimeList()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_tag_view, tf_city, false);
                TextView tv_view = view.findViewById(R.id.tv_view);
                tv_view.setText(s);
                return view;
            }
        });
        //图片集合
        RecyclerView rv_image = baseViewHolder.findView(R.id.rv_image);
        if (dataBean.getImageList() != null && dataBean.getImageList().size() > 0) {
            rv_image.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
            DynamicImageadapter dynamicImageadapter = new DynamicImageadapter();
            rv_image.setAdapter(dynamicImageadapter);
            dynamicImageadapter.setList(dataBean.getImageList());
            rv_image.setVisibility(View.VISIBLE);
        } else {
            rv_image.setVisibility(View.GONE);
        }
        //视频
        RelativeLayout rl_video = baseViewHolder.findView(R.id.rl_video);
        if (!TextUtils.isEmpty(dataBean.getVideoPath())) {
            ImageLoad.DisplayRoundCorner(getContext(), dataBean.getVideoCover(), baseViewHolder.findView(R.id.iv_cover), 5);
            rl_video.setVisibility(View.VISIBLE);
        } else {
            rl_video.setVisibility(View.GONE);
        }
        //内容
        if (!TextUtils.isEmpty(dataBean.getContent())) {
            baseViewHolder.setText(R.id.tv_content, dataBean.getContent());
            baseViewHolder.findView(R.id.tv_content).setVisibility(View.VISIBLE);
        } else {
            baseViewHolder.findView(R.id.tv_content).setVisibility(View.GONE);
        }

    }
}
