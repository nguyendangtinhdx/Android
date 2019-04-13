package com.example.nguyendangtinh.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText txtUserName,txtPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPassWord = (EditText) findViewById(R.id.txtPassWord);
    }
    public void Login(View view)
    {
        String userName = txtUserName.getText().toString();
        String passWord = txtPassWord.getText().toString();
        if (checkLogin(userName,passWord)){
            // dang nhap thanh cong
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            // dang nhap that bai
            Toast.makeText(this,"UserName or PassWord incorrect",Toast.LENGTH_LONG).show();
        }
    }

    boolean checkLogin(String userName, String passWord)
    {
        if (userName.equals("admin") && passWord.equals("admin"))
            return true;
        else
            return false;
    }
}



