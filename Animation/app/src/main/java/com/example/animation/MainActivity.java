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

        //alpha is for transparency, hence helps in fading in and out....
        // use other animations like translation, rotate etc
        // use multiple animations by adding more after .
        // eg ima.animate().rotate(1800).alpha(0).setDuration(3000);
        // this rotates 5 times and fades out simultaneously
        // if using decimals, add f in the end, else it wouldn't be accepted.
        //use scale to increase or decrease size

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView dog = (ImageView)findViewById(R.id.dg);
        dog.animate().rotationY(360).setDuration(2000);
    }
}
