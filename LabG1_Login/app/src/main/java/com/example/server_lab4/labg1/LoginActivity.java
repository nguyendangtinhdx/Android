package com.example.server_lab4.labg1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtUserName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    public void Login(View view) {
        String userName = txtUserName.getText().toString();
        String passWord = txtPassword.getText().toString();
        if (checkLogin(userName,passWord)) {
            //Dang nhap thanh cong
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        } else {
            //Dang nhap that bai
            Toast.makeText(this,"UserName or Password is not correct!",Toast.LENGTH_LONG).show();
        }
    }

    boolean checkLogin(String userName, String passWord) {
        if (userName.equals("dungnguyen") && passWord.equals("12345"))
            return true;
        else
            return false;
    }
}
