package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class loggedin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);

        Intent intent =getIntent();
        Log.i("inten",intent.getStringExtra("nme"));
        String gname = intent.getStringExtra("nme");
        TextView t = findViewById(R.id.wel);
        t.setText("Welcome " +gname);
    }
}
