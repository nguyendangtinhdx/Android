package com.example.nguyendangtinh.dangnhap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {

    EditText txtUserName, txtPassWord;
    CheckBox showPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUserName = (EditText) findViewById(R.id.txtUsername);
        txtPassWord = (EditText) findViewById(R.id.txtPassword);
        showPassWord = (CheckBox)findViewById(R.id.showPassword);

        showPassWord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    txtPassWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                else
                    txtPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
    }
    public void Login(View view)
    {
        String userName = txtUserName.getText().toString();
        String passWord = txtPassWord.getText().toString();
        if (checkLogin(userName,passWord))
        {
            // dang nhap thanh cong
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            // dang nhap that bai
            Toast.makeText(this,"Username or Password is not correct !",Toast.LENGTH_SHORT).show();
        }
    }
    boolean checkLogin(String userName,String passWord)
    {
        if (userName.equals("admin") && passWord.equals("admin"))
            return true;
        else
            return false;
    }

}
