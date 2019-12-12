package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;

    public void onclick(View view){
        EditText e = (EditText)findViewById(R.id.name);
        sp.edit().putString("username",e.getText().toString()).apply();

        Toast.makeText(this, sp.getString("username","user not found"), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);

        Toast.makeText(this, sp.getString("username","user not found"), Toast.LENGTH_SHORT).show();
    }
}
