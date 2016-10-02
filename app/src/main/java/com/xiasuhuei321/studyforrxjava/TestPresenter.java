package com.xiasuhuei321.studyforrxjava;


import rx.Subscriber;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public class TestPresenter {

    TestView testView;
    TestModel testModel;

    Subscriber<Integer> subscriber;

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case TestModeImpl.MESSAGE_DELAY:
//                    if (testView != null)
//                        TestPresenter.this.testView.getMessage();
//                    break;
//            }
//        }
//    };

    public TestPresenter(TestView testView) {
        this.testView = testView;
        testModel = new TestModeImpl();
    }

    public void getMessage() {
//        testModel.sendMessageDelayed(handler);
        subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                if (testView != null)
                    testView.getMessage();
            }
        };

        testModel.sendMessage(subscriber);
    }


    public void onDestroy() {
        if (subscriber != null)
            subscriber.unsubscribe();
        subscriber = null;
        this.testView = null;
//        handler.removeCallbacks(null);
    }
}
