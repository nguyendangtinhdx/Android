package com.example.nguyendangtinh.truyenthamso2manhinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtHoten;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHoten = (EditText)findViewById(R.id.editTextHoTen);
        btnSend = (Button)findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh2 = new Intent(MainActivity.this,ManHinh2.class);
                mh2.putExtra("hoten",edtHoten.getText().toString());
                startActivity(mh2);
            }
        });
    }
}
