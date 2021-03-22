package com.example.zhoukao0301.mvp;

import com.example.zhoukao0301.entity.XiaEntity;

import io.reactivex.Observer;

public interface MyContract {
    interface IModel{
        void getDate(Observer<XiaEntity> xiaEntityObserver,int page);
    }
    interface IPresenter{
        void getDate(int page);
    }
    interface IView{
        void OnOK(XiaEntity xiaEntity);
        void OnError(int code,String msg);
    }
}
