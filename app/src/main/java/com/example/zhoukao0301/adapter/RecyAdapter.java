package com.example.zhoukao0301.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhoukao0301.R;
import com.example.zhoukao0301.entity.XiaEntity;

import java.util.List;

public class RecyAdapter extends BaseQuickAdapter<XiaEntity.DataBean, BaseViewHolder> {
    public RecyAdapter(int layoutResId, @Nullable List<XiaEntity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XiaEntity.DataBean item) {
        helper.setText(R.id.tv_list,item.getTitle());
        Glide.with(mContext)
                .load(item.getPic())
                .transform(new CenterCrop())
                .into((ImageView) helper.getView(R.id.iv_list));
    }
}
