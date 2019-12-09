package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean game=true;
    boolean re=true;
    int play=0;
    int[][] win = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,6}};
    int[] st ={2,2,2,2,2,2,2,2,2};
    public void dropIn(View view){
        if(game) {
            ImageView counter = (ImageView) view;
            if (counter.getDrawable() == null) {
                play++;
                if(play==9)
                {
                    Toast.makeText(this, "Game Draw", Toast.LENGTH_SHORT).show();
                }
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
                for (int j = 0; j < 9; j++) {
                    if (st[win[i][0]] == st[win[i][1]] && st[win[i][1]] == st[win[i][2]] && st[win[i][0]] != 2) {
                        if (st[win[i][0]] == 0)
                            Toast.makeText(this, "Red wins", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this, "Yellow wins", Toast.LENGTH_SHORT).show();
                        game = false;

                    }
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
