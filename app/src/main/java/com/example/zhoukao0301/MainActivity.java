package com.example.zhoukao0301;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.zhoukao0301.adapter.ViewAdapter;
import com.example.zhoukao0301.entity.XiaEntity;
import com.example.zhoukao0301.fragment.HomeFragment;
import com.example.zhoukao0301.fragment.MessageFragment;
import com.example.zhoukao0301.fragment.MineFragment;
import com.example.zhoukao0301.fragment.SearchFragment;
import com.example.zhoukao0301.mvp.MyContract;
import com.example.zhoukao0301.mvp.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ViewPager vp;
    private RadioGroup rgp;
    private TextView tvxx;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new SearchFragment());
        list.add(new MessageFragment());
        list.add(new MineFragment());
        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(viewAdapter);
        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sy:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.fx:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.xx:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.wd:
                        vp.setCurrentItem(3);
                        break;
                }
            }
        });

    }
    @Subscribe
    public void AddMessage(String s){
        if (s.equals("增加了一条未读数据")){
            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            i++;
            tvxx.setText(i+"");
        }else {
            Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
            i--;
            tvxx.setText(i+"");
        }

    }


    private void initView() {
        vp = findViewById(R.id.vp);
        rgp = findViewById(R.id.rgp);
        tvxx = findViewById(R.id.tvxx);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
