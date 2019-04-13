package com.example.nguyendangtinh.read_json_array;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.ListViewDanhSach);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readJSON().execute("https://khoapham.vn/KhoaPhamTraining/laptrinhios/json/demo3.json");
            }
        });
    }
    class readJSON extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            String kq = docNoiDung_Tu_URL(strings[0]);
            return kq;
        }

        @Override
        protected void onPostExecute(String s) {
//            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            try {
                JSONObject root = new JSONObject(s);
                JSONArray mang = root.getJSONArray("danhsach");
//                String kq = "";
                ArrayList<String> mangKhoaHoc = new ArrayList<String>();
                for (int i = 0; i < mang.length(); i++) {
                    JSONObject son = mang.getJSONObject(i);
//                    kq += son.getString("khoahoc");
                    mangKhoaHoc.add(son.getString("khoahoc"));
                }
//                Toast.makeText(MainActivity.this,kq,Toast.LENGTH_LONG).show();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>( // trung gian đổ vào Listview
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        mangKhoaHoc
                );
                lv.setAdapter(adapter);
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
