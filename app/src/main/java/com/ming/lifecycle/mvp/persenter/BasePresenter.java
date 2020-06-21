package com.ming.lifecycle.mvp.persenter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.ming.lifecycle.Helper.LifecycleHelper;
import com.ming.lifecycle.listener.LifecycleObserverIml;

public class BasePresenter implements LifecycleObserverIml {

    private static final String TAG = "BasePresenter";

    private LifecycleHelper lifecycleHelper;
    private FragmentActivity fragmentActivity;
    private Fragment fragment;

    public BasePresenter(FragmentActivity fragmentActivity) {
        bindLifecycleOwner(fragmentActivity);
    }

    private void bindLifecycleOwner(Object object) {
        if (lifecycleHelper != null && lifecycleHelper.hasReference()) {
            lifecycleHelper.clearAll();
        }

        if (object instanceof FragmentActivity) {
            this.fragmentActivity = (FragmentActivity) object;
        }

        if (object instanceof Fragment) {
            this.fragment = (Fragment) object;
            this.fragmentActivity = fragment.getActivity();
        }

        lifecycleHelper = LifecycleHelper.with(object)
                .addLifecycleCallback(this);
    }

    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate()..");
    }

    @Override
    public void onStart() {
        Log.e(TAG,"onStart()..");
    }

    @Override
    public void onResume() {
        Log.e(TAG,"onResume()");
    }

    @Override
    public void onPause() {
        Log.e(TAG,"onPause()..");
    }

    @Override
    public void onStop() {
        Log.e(TAG,"onStop()..");
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy()..");
        if (lifecycleHelper.hasReference()) {
            lifecycleHelper.clearAll();
        }
    }
}
