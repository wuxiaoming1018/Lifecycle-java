package com.ming.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ming.lifecycle.mvp.persenter.LoginPresenter;

public class MainActivity extends AppCompatActivity {

    private LoginPresenter loginPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
    }

    public void textClick(View view){
        loginPresenter.login("13567264310","9870",this::success,this::failure);
    }

    private void failure(String content) {
        Toast.makeText(MainActivity.this,content,Toast.LENGTH_SHORT).show();
    }

    private void success() {
        Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
    }
}