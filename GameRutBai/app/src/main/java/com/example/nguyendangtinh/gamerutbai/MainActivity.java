package com.example.nguyendangtinh.gamerutbai;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imglaBai;
    Button btnRutLaBai;

    TextView txtCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imglaBai = (ImageView)findViewById(R.id.imageViewLaBai);
        btnRutLaBai = (Button)findViewById(R.id.buttonRutLaBai);

        btnRutLaBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> mangLaBai = new ArrayList<Integer>();

                // add lá bài vào mảng
                mangLaBai.add(R.drawable.h1);
                mangLaBai.add(R.drawable.h2);
                mangLaBai.add(R.drawable.h3);
                mangLaBai.add(R.drawable.h4);
                mangLaBai.add(R.drawable.h5);
                mangLaBai.add(R.drawable.h6);
                mangLaBai.add(R.drawable.h7);
                mangLaBai.add(R.drawable.h8);
                mangLaBai.add(R.drawable.h9);
                mangLaBai.add(R.drawable.h10);
                mangLaBai.add(R.drawable.hj);
                mangLaBai.add(R.drawable.hq);
                mangLaBai.add(R.drawable.hk);

                Random r = new Random();
                int batki = r.nextInt(mangLaBai.size()); // từ 0 - >13

                imglaBai.setImageResource(mangLaBai.get(batki));

            }
        });

        txtCountDownTimer = (TextView)findViewById(R.id.textViewCountDownTimer);
        new CountDownTimer(10000,1000) { // trong 10 giây nó sẽ thực hiện hàm onTick 1 lần, và thực hiện đủ 10 lần 1000/10000
            @Override
            public void onTick(long l) {
                String s = txtCountDownTimer.getText().toString();
                s += "*";
                txtCountDownTimer.setText(s);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"Time out",Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}
