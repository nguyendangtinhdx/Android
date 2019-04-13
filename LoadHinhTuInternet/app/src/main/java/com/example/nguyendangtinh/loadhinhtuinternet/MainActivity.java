package com.example.nguyendangtinh.loadhinhtuinternet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView hinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hinh = (ImageView)findViewById(R.id.imageViewLogo);

        // gọi tới class AsyncTask
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new LoadHinhTuInternet().execute("https://tinhte.cdnforo.com/store/2013/09/3491984_tinhte.vn-dien-thoai.jpg");
            }
        });
    }

    private class LoadHinhTuInternet extends AsyncTask<String, Integer,String>{

        @Override
        protected String doInBackground(String... params) { // hành động lấy hình về
            try {
                URL u = new URL(params[0]);
                Bitmap bmp = BitmapFactory.decodeStream(u.openConnection().getInputStream());
                hinh.setImageBitmap(bmp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        // khi load xong thì sẽ chạy hàm onPostExecute
        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(MainActivity.this,"Load hinh xong",Toast.LENGTH_LONG).show();
        }
    }
}
