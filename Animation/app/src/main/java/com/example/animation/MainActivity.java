package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean b = true;
    public void click (View view){
        Log.i("cnf","Image being tapped");
        ImageView im = (ImageView) findViewById(R.id.imageView2);

        ImageView ima = (ImageView) findViewById(R.id.imageView3);
        if(b) {
            im.animate().alpha(0).setDuration(3000);
            ima.animate().alpha(1).setDuration(3000);
            b=false;
        }
        else{
            ima.animate().alpha(0).setDuration(3000);
            im.animate().alpha(1).setDuration(3000);
            b=true;

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
