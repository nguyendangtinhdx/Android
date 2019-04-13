package com.example.nguyendangtinh.pheptoan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1,edtSo2;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView txtvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edtSo1 = (EditText)findViewById(R.id.editTextSo1);
        edtSo2 = (EditText)findViewById(R.id.editTextSo2);
        txtvKetQua = (TextView)findViewById(R.id.textViewKetQua);

        btnCong = (Button)findViewById(R.id.btnCong);
        btnTru = (Button)findViewById(R.id.btnTru);
        btnNhan = (Button)findViewById(R.id.btnNhan);
        btnChia = (Button)findViewById(R.id.btnChia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString();// lấy chuỗi nhập trong editText
                int so1 = Integer.parseInt(chuoi1); // ép chuỗi về số

                String chuoi2 = edtSo2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int tong = so1 + so2;
                txtvKetQua.setText(String.valueOf(tong)); // ép về chuỗi
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString();// lấy chuỗi nhập trong editText
                int so1 = Integer.parseInt(chuoi1); // ép chuỗi về số

                String chuoi2 = edtSo2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int hieu = so1 - so2;
                txtvKetQua.setText(String.valueOf(hieu)); // ép về chuỗi
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString();// lấy chuỗi nhập trong editText
                int so1 = Integer.parseInt(chuoi1); // ép chuỗi về số

                String chuoi2 = edtSo2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int tich= so1 * so2;
                txtvKetQua.setText(String.valueOf(tich)); // ép về chuỗi
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtSo1.getText().toString();// lấy chuỗi nhập trong editText
                int so1 = Integer.parseInt(chuoi1); // ép chuỗi về số

                String chuoi2 = edtSo2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int thuong = so1 / so2;
                txtvKetQua.setText(String.valueOf(thuong)); // ép về chuỗi
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
