package com.example.nguyendangtinh.truyenthamso2manhinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinh2 extends AppCompatActivity {
    TextView txtHoTen;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        txtHoTen = (TextView)findViewById(R.id.textViewHoten);
        btnBack = (Button)findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh1 = new Intent(ManHinh2.this,MainActivity.class);
                startActivity(mh1);
            }
        });

        Bundle bd = getIntent().getExtras();
        if (bd != null){
            String ten = bd.getString("hoten");
            txtHoTen.setText(ten);
        }
    }
}
