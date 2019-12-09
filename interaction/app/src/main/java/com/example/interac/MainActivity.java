package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void click(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.nametext);
        Log.i("Holaaa","yooooo");
        Log.i("text", nameEditText.getText().toString());

        Toast.makeText(this, "Hello "+nameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
