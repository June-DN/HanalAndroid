package com.example.hanalandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class SplashActivity extends Activity { //시작 시 스플래시 화면 2초

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(2000); //2초 대기
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, MainActivity.class));    //2초 후에 MainActivity 실행
        finish();
    }
}
