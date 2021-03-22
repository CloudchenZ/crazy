package com.example.zhoukao0301.mvp;

import com.example.zhoukao0301.entity.XiaEntity;
import com.example.zhoukao0301.mvp.MyContract.IPresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Presenter implements IPresenter{
    private Model model;
    private MyContract.IView iView;

    public Presenter(MyContract.IView iView) {
        this.iView = iView;
        model = new Model();
    }

    @Override
    public void getDate(int page) {
        if (iView != null){
            model.getDate(new Observer<XiaEntity>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(XiaEntity xiaEntity) {
                    if (iView != null){
                        iView.OnOK(xiaEntity);
                    }

                }

                @Override
                public void onError(Throwable e) {
                    if (iView != null){
                        iView.OnError(110,e.getMessage());
                    }
                }

                @Override
                public void onComplete() {

                }
            },page);
        }
    }
}
