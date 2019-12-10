package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public void play(View view){
        Button btn= (Button) view;
        Log.i("Button pressed",btn.getTag().toString());
        MediaPlayer m = MediaPlayer.create(this, getResources().getIdentifier(btn.getTag().toString(), "raw", getPackageName()));
        m.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
