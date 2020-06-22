package com.ming.lifecycle.mvp.persenter;

import android.os.Handler;
import android.text.TextUtils;

import androidx.fragment.app.FragmentActivity;

import com.ming.lifecycle.listener.Failure;
import com.ming.lifecycle.listener.Success;


public class LoginPresenter extends BasePresenter {

    private boolean isDestroy;

    public LoginPresenter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void login(String phoneNumber, String code, final Success success, final Failure failure){
        if (TextUtils.isEmpty(phoneNumber)) {
            failure.onFailure("手机号不能为空");
            return;
        }
        if (TextUtils.isEmpty(code)) {
            failure.onFailure("验证码不能为空");
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isDestroy) {
                    failure.onFailure("this presenter has destroyed");
                    return;
                }
                success.onSuccess();
            }
        },2000);
    }
}
