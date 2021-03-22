package com.example.zhoukao0301.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhoukao0301.R;
import com.example.zhoukao0301.adapter.MeaasgeAdapter;
import com.example.zhoukao0301.db.DaoMaster;
import com.example.zhoukao0301.db.DaoSession;
import com.example.zhoukao0301.db.MessageEntity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    private RecyclerView rvxx;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_message, container, false);
        rvxx = inflate.findViewById(R.id.rvxx);
        DaoSession daoSession = DaoMaster.newDevSession(getContext(), "bbb");
        List<MessageEntity> messageEntities = daoSession.loadAll(MessageEntity.class);
        MeaasgeAdapter meaasgeAdapter = new MeaasgeAdapter(R.layout.list_xx, messageEntities);
        rvxx.setAdapter(meaasgeAdapter);
        rvxx.setLayoutManager(new LinearLayoutManager(getContext()));
        meaasgeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CheckBox checkBox = view.findViewById(R.id.cbx);
                checkBox.setChecked(false);
                EventBus.getDefault().post("已阅读");
            }
        });
        return inflate;
    }


}
