package com.example.y_itoyama.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button button_segue;
    private Button button_segue2;
    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OnGestureListenerImpl gestureListener = new OnGestureListenerImpl();
        gestureDetector = new GestureDetector(this, gestureListener);

        button_segue=(Button)findViewById(R.id.button_segue);
        button_segue.setOnClickListener(this);

        button_segue2=(Button)findViewById(R.id.button_segue2);
        button_segue2.setOnClickListener(this);

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        viewFlipper.setDisplayedChild(0);

        // viewFlipper.setAutoStart(true);     //自動でスライドショーを開始
        // viewFlipper.setFlipInterval(1000);  //更新間隔(ms単位)
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // gestureDetector#onTouchEventメソッドでタッチイベントの判別・振り分けを行う
        gestureDetector.onTouchEvent(ev);

        return false;
    }

    //ボタンクリック時の関数
    public void onClick(View v) {

        if(v==button_segue){
            Intent intent = new Intent(this, SubActivity.class);
            startActivityForResult(intent, 0);
        }

        if(v==button_segue2){
            Intent intent = new Intent(this, Sub2Activity.class);
            startActivityForResult(intent, 0);
        }

//        switch(v.getId()) {
//            case R.id.startButton:
//                viewFlipper.startFlipping();
//                break;
//
//            case R.id.prevButton:
//                viewFlipper.showPrevious();
//                break;
//
//            case R.id.nextButton:
//                viewFlipper.showNext();
//                break;
//
//            case R.id.stopButton:
//                viewFlipper.stopFlipping();
//                break;
//
//            default:
//                break;
//        }
    }

    private class OnGestureListenerImpl implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1 // TouchDown時のイベント
                , MotionEvent e2   // TouchDown後、指の移動毎に発生するイベント
                , float velocityX  // X方向の移動距離
                , float velocityY)  // Y方向の移動距離
        {
            // 絶対値の取得
            float dx = Math.abs(velocityX);
            float dy = Math.abs(velocityY);
            // 指の移動方向(縦横)および距離の判定
            if (dx > dy && dx > 300) {
                // 指の移動方向(左右)の判定
                if (e1.getX() < e2.getX()) {
                    viewFlipper.showPrevious();
                } else {
                    viewFlipper.showNext();
                }
                return true;
            }
            return false;
        }
        @Override
        public void onLongPress(MotionEvent event) {
        }

        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent event) {
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return false;
        }
    }




}
