package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv=(ListView)findViewById(R.id.lst);
        final ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");

        ArrayAdapter<String> ar=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(ar);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, a.get(position), Toast.LENGTH_SHORT).show();
                
            }
        });
    }
}
