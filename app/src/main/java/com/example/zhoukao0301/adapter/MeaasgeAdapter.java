package com.example.zhoukao0301.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.zhoukao0301.R;
import com.example.zhoukao0301.db.MessageEntity;
import com.example.zhoukao0301.entity.MessageA;

import java.util.List;

public class MeaasgeAdapter extends BaseQuickAdapter<MessageEntity, BaseViewHolder> {

    public MeaasgeAdapter(int layoutResId, @Nullable List<MessageEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageEntity item) {
        helper.setText( R.id.tv_xxlist,item.getMsg());
    }
}
