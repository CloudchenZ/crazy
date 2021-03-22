package com.example.zhoukao0301.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.zhoukao0301.R;
import com.example.zhoukao0301.adapter.ViewTabAdapter;
import com.example.zhoukao0301.smallfragment.FindFragment;
import com.example.zhoukao0301.smallfragment.FravorableFragment;
import com.example.zhoukao0301.smallfragment.RecommendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private TabLayout tab;
    private ViewPager vp;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        tab = inflate.findViewById(R.id.tab);
        vp = inflate.findViewById(R.id.vp);
        List<Fragment> list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new FravorableFragment());
        list.add(new FindFragment());
        List<String> words = new ArrayList<>();
        words.add("猜你喜欢");
        words.add("今日特价");
        words.add("发现好店");
        ViewTabAdapter viewTabAdapter = new ViewTabAdapter(getChildFragmentManager(), list, words);
        tab.setupWithViewPager(vp);
        vp.setAdapter(viewTabAdapter);

        return inflate;
    }

}
