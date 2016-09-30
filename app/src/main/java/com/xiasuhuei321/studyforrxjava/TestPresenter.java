package com.xiasuhuei321.studyforrxjava;


import android.os.Handler;
import android.os.Message;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public class TestPresenter {

    TestView testView;
    TestModel testModel;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TestModeImpl.MESSAGE_DELAY:
                    TestPresenter.this.testView.getMessage();
                    break;
            }
        }
    };

    public TestPresenter(TestView testView) {
        this.testView = testView;
        testModel = new TestModeImpl();
    }

    public void getMessage() {
//        testModel.sendMessageDelayed(handler);
        handler.sendEmptyMessageDelayed(0, 3000);
    }

}
