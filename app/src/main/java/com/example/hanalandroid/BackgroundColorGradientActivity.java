package com.example.hanalandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class BackgroundColorGradientActivity extends Activity {    //시간별로 배경색 다르게 적용하는 액티비티

    public void myBackgroundDawn() {    //새벽 배경색
        final LinearLayout mainBackGround = (LinearLayout)findViewById(R.id.mainpage);
        mainBackGround.setBackgroundResource(R.drawable.background_gradient_dawn);
    }

    public void myBackgroundDaytime() {    //낮 배경색
        final LinearLayout mainBackGround = (LinearLayout)findViewById(R.id.mainpage);
        mainBackGround.setBackgroundResource(R.drawable.background_gradient_daytime);
    }

    public void myBackgroundTwilight() {    //저녁 배경색
        final LinearLayout mainBackGround = (LinearLayout)findViewById(R.id.mainpage);
        mainBackGround.setBackgroundResource(R.drawable.background_gradient_twilight);
    }

    public void myBackgroundNighttime() {    //밤 배경색
        final LinearLayout mainBackGround = (LinearLayout)findViewById(R.id.mainpage);
        mainBackGround.setBackgroundResource(R.drawable.background_gradient_nighttime);
    }


    public void myTimeNow() {       //새벽 낮 저녁 밤 시간대별로 스킨 적용

        String startDawn = "0530";      //새벽 시작하는 시간
        String startDaytime = "0900";   //낮 시작하는 시간
        String startTwilight = "1630";  //저녁 시작하는 시간
        String startNighttime = "2000"; //밤 시작하는 시간

        Date now = new Date();          //현재시간

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");

            Date start_dawn = dateFormat.parse(startDawn);
            Date start_daytime = dateFormat.parse(startDaytime);
            Date start_Twilight = dateFormat.parse(startTwilight);
            Date start_Nighttime = dateFormat.parse(startNighttime);

            if (now.getTime() >= start_dawn.getTime() && now.getTime() < start_daytime.getTime()) {
                //System.out.println("새벽");
                myBackgroundDawn();
            } else if (now.getTime() >= start_daytime.getTime() && now.getTime() < start_Twilight.getTime()) {
                //System.out.println("낮");
                myBackgroundDaytime();
            } else if (now.getTime() >= start_Twilight.getTime() && now.getTime() < start_Nighttime.getTime()) {
                //System.out.println("저녁");
                myBackgroundTwilight();
            } else if (now.getTime() >= start_Nighttime.getTime() || now.getTime() < start_dawn.getTime()) {
                //System.out.println("밤");
                myBackgroundNighttime();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
    }


}
