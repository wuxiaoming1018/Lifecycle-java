package com.ming.lifecycle.Helper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import java.util.ArrayList;
import java.util.List;

public class LifecycleHelper {

    private LifecycleOwner lifecycleOwner;
    private List<LifecycleObserver> lifecycleCallback = new ArrayList<>();

    public LifecycleHelper(Object object) {
        if (hasReference() && object instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) object;
        }
    }

    public static LifecycleHelper with(Object object) {
        return new LifecycleHelper(object);
    }

    public static LifecycleHelper with(AppCompatActivity appCompatActivity) {
        return new LifecycleHelper(appCompatActivity);
    }

    public static LifecycleHelper with(Fragment fragment) {
        return new LifecycleHelper(fragment);
    }

    public LifecycleHelper addLifecycleCallback(LifecycleObserver lifecycleObserver) {
        if (hasReference() && lifecycleObserver != null) {
            lifecycleCallback.add(lifecycleObserver);
            lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        }
        return this;
    }

    public LifecycleHelper removeLifecycleCallback(LifecycleObserver lifecycleObserver) {
        if (hasReference() && lifecycleObserver != null) {
            lifecycleCallback.remove(lifecycleObserver);
            lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
        }
        return this;
    }

    public List<LifecycleObserver> getLifecycleCallback() {
        return lifecycleCallback;
    }

    public void clearAll() {
        if (!hasReference()) {
            return;
        }
        for (LifecycleObserver observer : getLifecycleCallback()) {
            removeLifecycleCallback(observer);
        }
        build();
    }

    private void build() {
        lifecycleCallback.clear();
        lifecycleOwner = null;
    }

    public boolean hasReference() {
        return lifecycleOwner != null;
    }
}
