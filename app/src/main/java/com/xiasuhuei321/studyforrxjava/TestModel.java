package com.xiasuhuei321.studyforrxjava;


import android.os.Handler;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public interface TestModel {
    void sendMessageDelayed(Handler handler);

    void sendMessage(Subscriber sb);
}
