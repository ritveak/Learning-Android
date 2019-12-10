package com.example.multiplicationtables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = findViewById(R.id.lst);
        final SeekBar sb = findViewById(R.id.seekBar);
        sb.setMax(20);
        sb.setProgress(10);
        ArrayList<String> aa  = new ArrayList<String>();
        for(int j =1;j<20;j++)
        {
            aa.add(Integer.toString(10*j));
        }
        ArrayAdapter<String> arr = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,aa);
        lv.setAdapter(arr);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min = 1;
                int number;
                if(i<min)
                {
                    number = min;
                    sb.setProgress(min);
                }
                else
                {
                    number = i;
                }
                ArrayList<String> a  = new ArrayList<String>();
                for(int j =1;j<20;j++)
                {
                    a.add(Integer.toString(number*j));
                }
                ArrayAdapter<String> ar = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,a);
                lv.setAdapter(ar);



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        final ArrayList<Integer>  a = new ArrayList<>();


    }
}
