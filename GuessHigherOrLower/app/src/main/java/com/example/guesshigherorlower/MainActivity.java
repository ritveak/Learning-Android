package com.example.guesshigherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int rand = (int)(Math.random() * 20);
    public void click(View view){
        EditText ed = (EditText) findViewById(R.id.editText);
        String v = ed.getText().toString();
        int d = Integer.parseInt(v);
        Log.i("hw","Random number"+rand);
        String s = "Correct!!!";
        if(rand>d)
        {
            s="Try Higher!";
        }
        else if(rand<d){
            s="Try Lower!";
        }
        else{
            s="Correct!!!";
        }
        if(d>20 || d<0)
        {
            s="Choose a number between 0 and 20 only";
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();


    }
    public void refresh(View view)
    {
        rand = (int)(Math.random()*20);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
