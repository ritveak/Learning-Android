package com.example.timerbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Basic one
//        final Handler h = new Handler();
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Do Something", "A sec has passed");
//                h.postDelayed(this,1000);
//            }
//        };
//        h.post(r);

        //Better with defined time to stop!

        SeekBar sb = findViewById(R.id.seekBar);
        sb.setMax(10000);
        sb.setProgress(1000);
        final TextView t = findViewById(R.id.timer);
        final ImageView w = findViewById(R.id.whole);
        final ImageView c = findViewById(R.id.crack);
        final TextView up= findViewById(R.id.up);
        final MediaPlayer med = MediaPlayer.create(this,R.raw.horn);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                w.setAlpha(1);
                c.setAlpha(0);
                up.setAlpha(0);
                t.setText(String.valueOf(progress/1000));
                new CountDownTimer(progress,1000){
                    public void onTick(long mili){
                        Log.i("sec left",String.valueOf(mili/1000));
                        int tt =(int)mili/1000;

                        t.setText(String.valueOf(tt));

                    }
                    public void  onFinish(){
                        Log.i("we are done", "Time up");
                        t.setText(String.valueOf(0));
                        w.setAlpha(0);
                        c.setAlpha(1);
                        up.setAlpha(1);
                        med.start();



                    }
                }.start();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



//        new CountDownTimer(10000,1000){
//            public void onTick(long mili){
//                Log.i("sec left",String.valueOf(mili/1000));
//
//            }
//            public void  onFinish(){
//                Log.i("we are done", "Time up");
//            }
//        }.start();

    }
}
