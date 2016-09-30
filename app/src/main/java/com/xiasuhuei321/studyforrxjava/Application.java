package com.xiasuhuei321.studyforrxjava;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Luo on 2016/9/30.
 * desc:
 */
public class Application extends android.app.Application {
    @Override public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
