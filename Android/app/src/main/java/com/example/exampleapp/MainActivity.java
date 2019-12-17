package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public void callfun(View view){
        Log.i("info","Button pressed!!");
        EditText usrname = (EditText)findViewById(R.id.editText);
        Intent intent = new Intent(MainActivity.this,loggedin.class);
        Log.i("info",usrname.getText().toString());
        intent.putExtra("nme",usrname.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
