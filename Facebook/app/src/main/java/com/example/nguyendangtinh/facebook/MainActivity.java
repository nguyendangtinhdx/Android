package com.example.nguyendangtinh.facebook;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ProfilePictureView profilePictureView;
    LoginButton loginButton;
    Button btndangxuat, btnchucnang;
    TextView txtname,txtemail,txtfirstname;
    CallbackManager callbackManager; // khi gửi lên server thông điệp thì server trả về lời nhắn //5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create(); // 5
        setContentView(R.layout.activity_main);
        Anhxa();
        btnchucnang.setVisibility(View.INVISIBLE);
        btndangxuat.setVisibility(View.INVISIBLE);
        txtemail.setVisibility(View.INVISIBLE);
        txtname.setVisibility(View.INVISIBLE);
        txtfirstname.setVisibility(View.INVISIBLE);
        loginButton.setReadPermissions(Arrays.asList("public_profile","email")); // gửi lên server list string
        setLogin_Button(); // login vào Facebook
        ChuyenManHinh();
        setLogout_Button();

        try {
            PackageInfo info = null;
            try {
                info = getPackageManager().getPackageInfo(
                        "com.example.nguyendangtinh.facebook",
                        PackageManager.GET_SIGNATURES);
            }catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            for (Signature signature : info.signatures ) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update ( signature.toByteArray ());
                Log.d ("KeyHash", Base64.encodeToString (md.digest(), Base64.DEFAULT));
            }

        } catch ( NoSuchAlgorithmException e ) {

        }



    }

    private void ChuyenManHinh() { // 6
        btnchucnang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ManHinhChucNang.class);
                startActivity(intent);
            }
        });
    }

    private void setLogout_Button() {  // 6
        btndangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                btndangxuat.setVisibility(View.INVISIBLE);
                btnchucnang.setVisibility(View.INVISIBLE);
                txtemail.setVisibility(View.INVISIBLE);
                txtname.setVisibility(View.INVISIBLE);
                txtfirstname.setVisibility(View.INVISIBLE);
                txtemail.setText("");
                txtname.setText("");
                txtfirstname.setText("");
                profilePictureView.setProfileId(null);
                loginButton.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setLogin_Button() { // callbackManager tin nhắn server trả về //5
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                result();
                loginButton.setVisibility(View.INVISIBLE); // mờ đi
                btnchucnang.setVisibility(View.VISIBLE);
                btndangxuat.setVisibility(View.VISIBLE);
                txtemail.setVisibility(View.VISIBLE);
                txtname.setVisibility(View.VISIBLE);
                txtfirstname.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void result() { // lấy thông về // 5
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON",response.getJSONObject().toString()); // lấy đoạn JSON về
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "name,email,first_name");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();

    }

    public  void Anhxa(){ // 4
        profilePictureView = (ProfilePictureView)findViewById(R.id.imageprofilepictureview);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        btnchucnang = (Button)findViewById(R.id.buttonchucnang);
        btndangxuat = (Button)findViewById(R.id.buttondangxuat);
        txtemail = (TextView)findViewById(R.id.textviewemail);
        txtname = (TextView)findViewById(R.id.textviewname);
        txtfirstname = (TextView)findViewById(R.id.textviewfirstname);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // nhận kết quả trả về của server
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data); // 5
    }
}
