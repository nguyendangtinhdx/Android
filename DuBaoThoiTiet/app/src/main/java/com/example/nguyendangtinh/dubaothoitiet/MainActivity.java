package com.example.nguyendangtinh.dubaothoitiet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    Button btnSearch, btnChangeActivity;
    TextView txtName, txtCountry, txtStatus,txtTemp, txtHumidity, txtCloud, txtWind,txtDay;
    ImageView imgIcon;
    String City = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        GetCurrentWeatherData("Saigon");
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                if (city.equals("")){
                    City = "Saigon";
                    GetCurrentWeatherData(City);
                }
                else {
                    City = city;
                    GetCurrentWeatherData(City);
                }
            }
        });
        btnChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = edtSearch.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name",city);
                startActivity(intent);
            }
        });
    }
    public void GetCurrentWeatherData(String data){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this); // thực thi request gửi đi
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+data+"&units=metric&appid=53fbf527d52d4d773e828243b90c1f8e";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String day = jsonObject.getString("dt");
                            String name = jsonObject.getString("name");
                            txtName.setText("Tên thành phố: " + name);

                            long l = Long.valueOf(day); // chuyển kiểu biến date về kiểu dữ liệu long
                            Date date = new Date(l*1000L); // chuyển về giây
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE  dd-MM-yyyy  HH:mm:ss");
                            String Day = simpleDateFormat.format(date);// hứng dữ liệu sau khi format
                            txtDay.setText(Day);

                            JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
                            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0); // lấy phần tử 0
                            String status = jsonObjectWeather.getString("main");
                            String icon = jsonObjectWeather.getString("icon");
                            Picasso.with(MainActivity.this).load("http://openweathermap.org/img/w/"+icon+".png").into(imgIcon); // load icon
                            txtStatus.setText(status);

                            JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                            String nhietdo = jsonObjectMain.getString("temp");
                            String doam = jsonObjectMain.getString("humidity");
                            Double a = Double.valueOf(nhietdo);
                            String NhietDo = String.valueOf(a.intValue()); // chuyển nhiệt độ về kiểu int
                            txtTemp.setText(NhietDo + " ºC");
                            txtHumidity.setText(doam + " %");

                            JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                            String gio = jsonObjectWind.getString("speed");
                            txtWind.setText(gio + " m/s");

                            JSONObject jsonObjectClouds = jsonObject.getJSONObject("clouds");
                            String may = jsonObjectClouds.getString("all");
                            txtCloud.setText(may + " %");

                            JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
                            String country = jsonObjectSys.getString("country");
                            txtCountry.setText("Tên quốc gia: " + country);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }

    private void AnhXa(){
        edtSearch = (EditText)findViewById(R.id.edittextSearch);
        btnSearch = (Button)findViewById(R.id.buttonSearch);
        btnChangeActivity = (Button)findViewById(R.id.buttonChangeActivity);
        txtName = (TextView)findViewById(R.id.textviewName);
        txtCountry = (TextView)findViewById(R.id.textviewCountry);
        txtStatus = (TextView)findViewById(R.id.textviewStatus);
        txtTemp = (TextView)findViewById(R.id.textviewTemp);
        txtHumidity = (TextView)findViewById(R.id.textviewHumidity);
        txtCloud = (TextView)findViewById(R.id.textviewCloud);
        txtWind = (TextView)findViewById(R.id.textviewWind);
        txtDay = (TextView)findViewById(R.id.textviewDay);
        imgIcon = (ImageView)findViewById(R.id.imageIcon);
    }
}
