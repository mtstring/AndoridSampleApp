package com.example.y_itoyama.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // お辞儀する人
        ImageView imageView = (ImageView) findViewById(R.id.imageBow);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.drawable.bow).into(target);

        // ドラえもん歩く用
        final ImageView draemonImg = (ImageView) findViewById(R.id.imageDraemon);


        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBarGrowUp);
        seekBar.setMax(80);
        seekBar.setProgress(80);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // つまみを離したときに発生する.
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            // つまみにタッチしたときに発生する.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            // つまみを移動したときに発生する.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(0 <= progress && progress <= 10){
                    draemonImg.setImageResource(R.drawable.draemon1);
                }
                if(11 <= progress && progress <= 20){
                    draemonImg.setImageResource(R.drawable.draemon2);
                }
                if(21 <= progress && progress <= 30){
                    draemonImg.setImageResource(R.drawable.draemon3);
                }
                if(31 <= progress && progress <= 40){
                    draemonImg.setImageResource(R.drawable.draemon4);
                }
                if(41 <= progress && progress <= 50){
                    draemonImg.setImageResource(R.drawable.draemon5);
                }
                if(51 <= progress && progress <= 60){
                    draemonImg.setImageResource(R.drawable.draemon6);
                }
                if(61 <= progress && progress <= 70){
                    draemonImg.setImageResource(R.drawable.draemon7);
                }
                if(71 <= progress && progress <= 80){
                    draemonImg.setImageResource(R.drawable.draemon1);
                }
            }
        });

    }
}
