package com.xiasuhuei321.studyforrxjava;


import android.os.Handler;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public class TestModeImpl implements TestModel {
    public static final int MESSAGE_DELAY = 0;

    @Override
    public void sendMessageDelayed(final Handler handler) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessageDelayed(MESSAGE_DELAY, 200000);
                    }
                }).start();
    }

    @Override
    public void sendMessage(Subscriber sb) {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (double i = 65536; i > 0; i--)
                    for (double j = 65536; j > 0; j--)
                        for (double k = 65536; k > 0; k--)
                            for (double l = 65536; l > 0; l--)
                                for (double m = 65536; m > 0; m--)
                                    subscriber.onNext(1);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sb);
    }
}
