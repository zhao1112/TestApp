package com.test.testapp.ui.main.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.testapp.R;
import com.test.testapp.entity.news.NewsListBean;
import com.test.testapp.utils.ImageLoad;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/16
 * Time: 10:52
 */
public class NewsAdapter extends BaseQuickAdapter<NewsListBean.DataBean, BaseViewHolder> {

    public NewsAdapter() {
        super(R.layout.item_news_list);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewsListBean.DataBean dataBean) {
        ImageLoad.DisplayRoundCorner(getContext(), dataBean.getUserHeard(), baseViewHolder.findView(R.id.iv_heard), 5);
        baseViewHolder.setText(R.id.tv_name, dataBean.getUserName())
                .setText(R.id.tv_time, dataBean.getSendTime())
                .setText(R.id.tv_msg, dataBean.getUserMessage());
    }
}
