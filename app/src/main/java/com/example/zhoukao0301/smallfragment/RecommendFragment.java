package com.example.zhoukao0301.smallfragment;


import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.zhoukao0301.R;
import com.example.zhoukao0301.adapter.RecyAdapter;
import com.example.zhoukao0301.db.DaoMaster;
import com.example.zhoukao0301.db.DaoSession;
import com.example.zhoukao0301.db.GoodsEntity;
import com.example.zhoukao0301.db.MessageEntity;
import com.example.zhoukao0301.entity.XiaEntity;
import com.example.zhoukao0301.mvp.MyContract;
import com.example.zhoukao0301.mvp.Presenter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment implements MyContract.IView {


    private RecyclerView rv1;
    private PullToRefreshLayout ref;
    private Button sendbro;
    private Presenter presenter;
    public RecommendFragment() {
        // Required empty public constructor
    }

    private List<XiaEntity.DataBean> dataBeans = new ArrayList<>();
    private int page = 1;
    RecyAdapter recyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recommend, container, false);
        rv1 = inflate.findViewById(R.id.rv1);
        ref = inflate.findViewById(R.id.ref);
        sendbro = inflate.findViewById(R.id.sendbro);
        EventBus.getDefault().register(this);
        presenter = new Presenter(this);
        presenter.getDate(page);
        ref.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {

            }

            @Override
            public void loadMore() {
                page++;
                presenter.getDate(page);
                Toast.makeText(getContext(), "加载了20条数据", Toast.LENGTH_SHORT).show();
                ref.finishLoadMore();
            }
        });
        sendbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(0);
            }
        });
        recyAdapter = new RecyAdapter(R.layout.list_view, dataBeans);
        rv1.setAdapter(recyAdapter);
        rv1.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        return inflate;
    }
    @Subscribe(sticky = true)
    public void Movetop(Integer i){
        rv1.scrollToPosition(0);
    }

    @Override
    public void OnOK(XiaEntity xiaEntity) {
        Log.e("aaa", "OnOK: " + xiaEntity);
        List<XiaEntity.DataBean> data = xiaEntity.getData();
        dataBeans.addAll(data);
        recyAdapter.notifyDataSetChanged();
        recyAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                final GoodsEntity goodsEntity = new GoodsEntity();
                goodsEntity.setTitle(dataBeans.get(position).getTitle());
                goodsEntity.setUrl(dataBeans.get(position).getPic());
                final MessageEntity messageEntity = new MessageEntity();
                messageEntity.setMsg(dataBeans.get(position).getTitle());
                final PopupWindow popupWindow = new PopupWindow();
                popupWindow.setOutsideTouchable(true);
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.popwindows, null);
                TextView button = inflate.findViewById(R.id.yes);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        DaoSession daoSession = DaoMaster.newDevSession(getContext(), "aaa");
                        daoSession.insert(goodsEntity);
                        DaoSession daoSession1 = DaoMaster.newDevSession(getContext(), "bbb");
                        daoSession1.insert(messageEntity);
                        EventBus.getDefault().post("增加了一条未读数据");
                    }
                });
                popupWindow.setContentView(inflate);
                popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(getView(),Gravity.CENTER,0,0);

                return false;
            }
        });
    }

    @Override
    public void OnError(int code, String msg) {
        Log.e("aaa", "OnOK: " + msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
