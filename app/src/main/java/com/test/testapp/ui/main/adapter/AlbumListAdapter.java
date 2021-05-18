package com.test.testapp.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testapp.R;
import com.test.testapp.entity.login.UsersBean;
import com.test.testapp.utils.ConstantUtil;
import com.test.testapp.utils.ImageLoad;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/17
 * Time: 10:24
 */
public class AlbumListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<UsersBean.AlbumList> list;
    private int width;

    public AlbumListAdapter(Context context, List<UsersBean.AlbumList> list, int width) {
        this.context = context;
        this.list = list;
        this.width = width;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_album_list, parent, false);
        return new AlbumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AlbumHolder albumHolder = (AlbumHolder) holder;

        LinearLayout.LayoutParams paramsText = (LinearLayout.LayoutParams) albumHolder.tv_view.getLayoutParams();
        paramsText.width = ConstantUtil.dp2px(context, 3);
        albumHolder.tv_view.setLayoutParams(paramsText);

        int imageWidth = width / 3 - ConstantUtil.dp2px(context, 3) * 2;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) albumHolder.iv_image.getLayoutParams();
        params.height = imageWidth;
        params.width = imageWidth;
        albumHolder.iv_image.setLayoutParams(params);

        if (list.get(position).isVideo()) {
            ImageLoad.DisplayRoundCorner(context, list.get(position).getUserVideo(), albumHolder.iv_image, 4);
            albumHolder.iv_video_play.setVisibility(View.VISIBLE);
        } else {
            ImageLoad.DisplayRoundCorner(context, list.get(position).getUserImage(), albumHolder.iv_image, 4);
            albumHolder.iv_video_play.setVisibility(View.GONE);
        }

        if ((position + 1) % 3 == 0) {
            albumHolder.tv_view.setVisibility(View.GONE);
        }

        if (position == getItemCount() - 1) {
            if (list.size() > 3) {
                albumHolder.tv_albun_number.setText("+" + list.size());
                albumHolder.tv_albun_number.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() > 3 ? 3 : list.size();
    }

    public class AlbumHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_image;
        private final ImageView iv_video_play;
        private final TextView tv_albun_number;
        private final TextView tv_view;

        public AlbumHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            iv_video_play = itemView.findViewById(R.id.iv_video_play);
            tv_albun_number = itemView.findViewById(R.id.tv_albun_number);
            tv_view = itemView.findViewById(R.id.tv_view);
        }
    }
}
