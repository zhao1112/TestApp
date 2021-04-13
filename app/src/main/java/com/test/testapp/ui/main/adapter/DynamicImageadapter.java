package com.test.testapp.ui.main.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.test.testapp.R;
import com.test.testapp.utils.ImageLoad;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/13
 * Time: 14:49
 */
public class DynamicImageadapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public DynamicImageadapter() {
        super(R.layout.item_dynamic_image_list);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        ImageLoad.DisplayRoundCorner(getContext(), s, baseViewHolder.findView(R.id.iv_image), 5);
    }
}
