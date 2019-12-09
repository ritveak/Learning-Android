package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean re=true;
    public void dropIn(View view){
        ImageView counter = (ImageView)view;
        if(counter.getDrawable()==null) {
            counter.setTranslationY(-1500);
            if (re) {
                counter.setImageResource(R.drawable.red);
                re = false;
            } else {
                counter.setImageResource(R.drawable.yellow);
                re = true;
            }
            counter.animate().translationYBy(1500).setDuration(1000);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
