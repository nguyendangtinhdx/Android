package com.example.nguyendangtinh.read_json;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    TextView monhoc,noihoc,website,fanpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monhoc = (TextView)findViewById(R.id.textViewMonHoc);
        noihoc= (TextView)findViewById(R.id.textViewNoiHoc);
        website = (TextView)findViewById(R.id.textViewWebsite);
        fanpage = (TextView)findViewById(R.id.textViewFanpage);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/android/json/demo3.json");
            }
        });
    }

    class ReadJSON extends AsyncTask<String ,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            String chuoi = docNoiDung_Tu_URL(strings[0]);
            return chuoi;
        }

        @Override
        protected void onPostExecute(String s) {
            // đọc JSON
            try {
                JSONObject root = new JSONObject(s); // những gì down về được
                monhoc.setText(root.getString("monhoc"));
                noihoc.setText(root.getString("noihoc"));
                website.setText(root.getString("website"));
                fanpage.setText(root.getString("fanpage"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}
