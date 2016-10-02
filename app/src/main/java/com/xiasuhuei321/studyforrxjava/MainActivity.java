package com.xiasuhuei321.studyforrxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity implements TestView {

    private Button btTest;
    private TestPresenter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RefWatcher refWatcher = ExampleApplication.getRefWatcher(this);
        refWatcher.watch(this);
//        p = new TestPresenter(this);
        btTest = (Button) findViewById(R.id.bt_test);
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.getMessage();
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                MainActivity.this.finish();
            }
        });
    }

    @Override
    public void getMessage() {
        Log.e("MainActivity", "asdf");
    }

    @Override
    protected void onDestroy() {
        p.onDestroy();
        p = null;
        super.onDestroy();
//        removeActivityFromTransitionManager(this);
        Log.e("MainActivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPasue");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity", "onRestart");
    }

//    private static void removeActivityFromTransitionManager(Activity activity){
//        if (Build.VERSION.SDK_INT < 21) {
//            return;
//        }
//        Class transitionManagerClass = TransitionManager.class;
//        try {
//            Field runningTransitionsField = transitionManagerClass.getDeclaredField("sRunningTransitions");
//            runningTransitionsField.setAccessible(true);
//            //noinspection unchecked
//            ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> runningTransitions
//                    = (ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>>)
//                    runningTransitionsField.get(transitionManagerClass);
//            if (runningTransitions.get() == null || runningTransitions.get().get() == null) {
//                return;
//            }
//            ArrayMap map = runningTransitions.get().get();
//            View decorView = activity.getWindow().getDecorView();
//            if (map.containsKey(decorView)) {
//                map.remove(decorView);
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
}
