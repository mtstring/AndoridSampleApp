package com.example.y_itoyama.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by y-itoyama on 2016/12/01.
 */

public class Sub3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);


        final ImageView imageView = (ImageView) findViewById(R.id.imageStar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Sub3Activity.this, R.anim.touch);
                imageView.startAnimation(animation);
            }
        });

        imageView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                RotateAnimation rotate = new RotateAnimation(0, 360, imageView.getWidth()/2, imageView.getHeight()/2); // imgの中心を軸に、0度から360度にかけて回転
                rotate.setDuration(3000); // 3000msかけてアニメーションする
                imageView.startAnimation(rotate); // アニメーション適用
                return true;
            }
        });
    }
}