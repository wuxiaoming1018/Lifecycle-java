package com.ming.lifecycle.mvp.persenter;

import android.media.MediaPlayer;

import androidx.fragment.app.FragmentActivity;

import java.io.IOException;

/**
 * 延伸阅读思考：
 * EventBus可以说是Android开发中消息必不可少的部分,以刚刚P层为例,当我们已经能在内部
 * 感知生命周期时注册和解绑我们就可以在P层内部进行自处理,外部则不需要关系注册以及解绑的问题了
 */

public class MediaPlayerPresenter extends BasePresenter {

    private MediaPlayer mediaPlayer;

    public MediaPlayerPresenter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        mediaPlayer = new MediaPlayer();
        //EventBus.getDefault().register(this);
    }

    public void setDataSource(String path){
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        //EventBus.getDefault().unregister(this);
    }
}
