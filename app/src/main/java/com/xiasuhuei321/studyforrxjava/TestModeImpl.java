package com.xiasuhuei321.studyforrxjava;


import android.os.Handler;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public class TestModeImpl implements TestModel {
    public static final int MESSAGE_DELAY = 0;

    @Override
    public void sendMessageDelayed(final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessageDelayed(MESSAGE_DELAY, 2000);
            }
        }).start();
    }
}
