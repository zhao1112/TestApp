package com.test.testapp.ui.details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testapp.R;
import com.test.testapp.entity.login.UsersBean;
import com.test.testapp.utils.ImageLoad;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/17
 * Time: 10:24
 */
public class PhotoistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<UsersBean.AlbumList> list;


    public PhotoistAdapter(Context context, List<UsersBean.AlbumList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo_list, parent, false);
        return new AlbumHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AlbumHolder albumHolder = (AlbumHolder) holder;

        if (list.get(position).isVideo()) {
            ImageLoad.DisplayRoundCorner(context, list.get(position).getUserVideo(), albumHolder.iv_image, 4);
            albumHolder.iv_video_play.setVisibility(View.VISIBLE);
        } else {
            ImageLoad.DisplayRoundCorner(context, list.get(position).getUserImage(), albumHolder.iv_image, 4);
            albumHolder.iv_video_play.setVisibility(View.GONE);
        }

        if (position % 3 == 0) {
            albumHolder.tv_view.setVisibility(View.GONE);
        }

        if (position == getItemCount() - 1) {
            if (list.size() > 6) {
                albumHolder.tv_albun_number.setText("+" + list.size());
                albumHolder.tv_albun_number.setVisibility(View.VISIBLE);
            }
            albumHolder.tv_view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size() > 6 ? 6 : list.size();
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
