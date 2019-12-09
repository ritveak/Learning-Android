package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean game=true;
    boolean re=true;
    int play=0;
    int[][] win = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int[] st ={2,2,2,2,2,2,2,2,2};
    public void dropIn(View view){
        if(game) {
            ImageView counter = (ImageView) view;
            if (counter.getDrawable() == null) {
                play++;
                counter.setTranslationY(-1500);
                int t = Integer.parseInt(counter.getTag().toString());

                if (re) {
                    counter.setImageResource(R.drawable.red);
                    st[t] = 0;
                    re = false;
                } else {
                    counter.setImageResource(R.drawable.yellow);
                    st[t] = 1;
                    re = true;
                }
                counter.animate().translationYBy(1500).setDuration(1000);
            }
            for (int i = 0; i < 8; i++) {

                    if (st[win[i][0]] == st[win[i][1]] && st[win[i][1]] == st[win[i][2]] && st[win[i][0]] != 2) {
                        if (st[win[i][0]] == 0)
                            Toast.makeText(this, "Red wins", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this, "Yellow wins", Toast.LENGTH_SHORT).show();
                        game = false;
                        Button b = findViewById(R.id.reset);
                        b.setAlpha(1);

                    }


            }
            if(play==9) {
                Button b = findViewById(R.id.reset);
                b.setAlpha(1);

                if (game) {
                    Toast.makeText(this, "Game Draw", Toast.LENGTH_SHORT).show();
                    play = 0;
                }
            }
        }
    }
    public void reset(View view){
        for(int i =0;i<9;i++)
        {
            st[i]=2;
        }
        game=true;
        re=true;
        play=0;
        ImageView r = (ImageView)findViewById(R.id.red1);
        r.setImageDrawable(null);
        ImageView r2 = (ImageView)findViewById(R.id.red2);
        r2.setImageDrawable(null);
        ImageView r3= (ImageView)findViewById(R.id.red3);
        r3.setImageDrawable(null);
        ImageView r4 = (ImageView)findViewById(R.id.red4);
        r4.setImageDrawable(null);
        ImageView r5 = (ImageView)findViewById(R.id.red5);
        r5.setImageDrawable(null);
        ImageView r6 = (ImageView)findViewById(R.id.red6);
        r6.setImageDrawable(null);
        ImageView r7 = (ImageView)findViewById(R.id.red7);
        r7.setImageDrawable(null);
        ImageView r8 = (ImageView)findViewById(R.id.red8);
        r8.setImageDrawable(null);
        ImageView r9 = (ImageView)findViewById(R.id.red9);
        r9.setImageDrawable(null);

//        GridLayout g = (GridLayout) findViewById(R.id.gridLayout);
//        for(int i=0; i<g.getChildCount(); i++) {
//            ImageView child = (ImageView)g.getChildAt(i);
//            child.setImageDrawable(null);
//            // do stuff with child view
//        }
        Button b = findViewById(R.id.reset);
        b.setAlpha(0);



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
