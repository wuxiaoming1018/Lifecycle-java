package com.ming.lifecycle;

import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ming.lifecycle.mvp.persenter.MediaPlayerPresenter;

public class MediaPlayerActivity extends AppCompatActivity {

    private MediaPlayerPresenter mediaPlayerPresenter;
    private MediaPlayerPresenter playerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlayer();
        test();
    }

    private void test() {

    }

    private void initPlayer() {
        playerPresenter = new MediaPlayerPresenter(this);
        playerPresenter.setDataSource(Environment.getExternalStorageDirectory()+"/demo.mp4");
    }
}
