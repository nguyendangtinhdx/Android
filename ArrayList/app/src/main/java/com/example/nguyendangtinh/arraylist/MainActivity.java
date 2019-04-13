package com.example.nguyendangtinh.arraylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvArray = (ListView)findViewById(R.id.ListViewArray);

        final ArrayList<String> mangMonHoc = new ArrayList<String>();
        mangMonHoc.add("Lập trình Android");
        mangMonHoc.add("Lập trình ASP.Net");
        mangMonHoc.add("Lập trình PHP");
        mangMonHoc.add("Lập trình Web");

        // trung gian đổ vào Listview
        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mangMonHoc
        );
        lvArray.setAdapter(adapter);

        lvArray.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                    MainActivity.this,
                    mangMonHoc.get(i), // "" + i : show vị trí
                    Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
