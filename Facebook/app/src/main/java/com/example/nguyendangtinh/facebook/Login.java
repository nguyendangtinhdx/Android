package com.example.nguyendangtinh.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView txtUsername,txtPassword;
    CheckBox cbShowPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = (TextView)findViewById(R.id.txtUsername);
        txtPassword = (TextView)findViewById(R.id.txtPassword);
        cbShowPassword = (CheckBox)findViewById(R.id.cbShowPassword);

        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                else
                    txtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
    }
    public void Login(View view)
    {
        String userName = txtUsername.getText().toString();
        String passWord = txtPassword.getText().toString();
        if (CheckLogin(userName,passWord))
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
            Toast.makeText(this,"Username or Password incorrect !", Toast.LENGTH_SHORT).show();

    }
    boolean CheckLogin(String userName, String passWord)
    {
        if (userName.equals("admin") && passWord.equals("55555"))
            return true;
        return  false;
    }
}
