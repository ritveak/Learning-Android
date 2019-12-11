package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String res ="";
            URL url;
            HttpURLConnection urlconnedction;
            try{
                url = new URL(urls[0]);
                urlconnedction=(HttpURLConnection) url.openConnection();
                InputStream in = urlconnedction.getInputStream();
                InputStreamReader reader= new InputStreamReader(in);
                int data = reader.read();

                while(data!=-1)
                {
                    char current = (char) data;
                    res+=current;
                    data=reader.read();

                }
                return res;
            }catch(Exception e)
            {
                Toast.makeText(MainActivity.this, "Could not find the city", Toast.LENGTH_SHORT).show();
                e.printStackTrace();

                return null;
            }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Log.i("The Json",s);
            try {
                JSONObject jsonobj = new JSONObject(s);
                String winfo = jsonobj.getString("weather");
                Log.i("weather",winfo);
                JSONArray  ja = new JSONArray(winfo);
                String sss="";
                tt=findViewById(R.id.result);
                for(int i=0;i<ja.length();i++) {
                    JSONObject jsonpart = ja.getJSONObject(i);

                    sss+="Status: "+jsonpart.getString("main")+"\nDescription: "+jsonpart.getString("description");
                    Log.i("main",jsonpart.getString("main"));
                    Log.i("description",jsonpart.getString("description"));
                }



                String temp = jsonobj.getString("main");
                Log.i("main",temp);
                JSONObject jaj = new JSONObject(temp);
//                long kel = Long.parseLong();
//                kel-=273.15;
//                //String cel = String.valueOf(kel)+"C";

                sss+="\nTemperature:"+ String.format("%.2f",Double.parseDouble(jaj.getString("temp"))-273.15)+"°C\nHumidity: "+jaj.getString("humidity");

                tt.setText(sss);



            } catch (JSONException e) {

                Toast.makeText(MainActivity.this, "Could not find the city", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        }
    }
    EditText editText;
    TextView tt;
    public void getweather(View view){

        DownloadTask task =new DownloadTask();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q="+editText.getText().toString()+"&appid=0495492fe940b8155d8262944d590960");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

    }
}
