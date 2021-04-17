package com.test.testapp.ui.details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
public class DynamicListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<UsersBean.AlbumList> list;


    public DynamicListAdapter(Context context, List<UsersBean.AlbumList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_details_dynamic_list, parent, false);
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

    }

    @Override
    public int getItemCount() {
        return list.size() > 3 ? 3 : list.size();
    }

    public class AlbumHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_image;
        private final ImageView iv_video_play;

        public AlbumHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            iv_video_play = itemView.findViewById(R.id.iv_video_play);
        }
    }
}
