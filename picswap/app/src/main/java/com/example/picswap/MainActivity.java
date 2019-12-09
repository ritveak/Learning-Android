package com.example.picswap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public void click1 (View view){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.dog2);
    }
    public void click2(View view)
    {
        ImageView im = (ImageView) findViewById(R.id.imageView);
        im.setImageResource(R.drawable.dog1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
