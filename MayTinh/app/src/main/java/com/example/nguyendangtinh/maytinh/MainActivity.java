package com.example.nguyendangtinh.maytinh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtNumber;
    private TextView tvResult;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnPoint;
    private Button btnResult;
    private Button btnClear;
    private Button btnClearAll;
    private  final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickView();
    }
    public void initWidget(){
        edtNumber = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnNumber0 = (Button)findViewById(R.id.btnNumber0);
        btnNumber1 = (Button)findViewById(R.id.btnNumber1);
        btnNumber2 = (Button)findViewById(R.id.btnNumber2);
        btnNumber3 = (Button)findViewById(R.id.btnNumber3);
        btnNumber4 = (Button)findViewById(R.id.btnNumber4);
        btnNumber5 = (Button)findViewById(R.id.btnNumber5);
        btnNumber6 = (Button)findViewById(R.id.btnNumber6);
        btnNumber7 = (Button)findViewById(R.id.btnNumber7);
        btnNumber8 = (Button)findViewById(R.id.btnNumber8);
        btnNumber9 = (Button)findViewById(R.id.btnNumber9);

        btnCong = (Button)findViewById(R.id.btnCong);
        btnTru = (Button)findViewById(R.id.btnTru);
        btnNhan = (Button)findViewById(R.id.btnNhan);
        btnChia = (Button)findViewById(R.id.btnChia);

        btnPoint = (Button)findViewById(R.id.btnPoint);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnClearAll = (Button)findViewById(R.id.btnClearAll);
        btnResult = (Button)findViewById(R.id.btnResult);


    }

    public void setEventClickView(){
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);


        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNumber0:
                edtNumber.append("0");
                break;
            case R.id.btnNumber1:
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                edtNumber.append("9");
                break;
            case R.id.btnCong:
                edtNumber.append("+");
                break;
            case R.id.btnTru:
                edtNumber.append("-");
                break;
            case R.id.btnNhan:
                edtNumber.append("*");
                break;
            case R.id.btnChia:
                edtNumber.append("/");
                break;
            case R.id.btnPoint:
                edtNumber.append(".");
                break;
            case R.id.btnClear:
//                String numberAfterRemove = deleteANumber(edtNumber.getText().toString());
//                edtNumber.setText(numberAfterRemove);
                // xóa kí tự trước con trỏ
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));

                break;
            case R.id.btnClearAll:
                edtNumber.setText("");
                break;
            case R.id.btnResult:
                DecimalFormat df = new DecimalFormat("###.########");//làm tròn 8 chữ số thập ph
                double result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                // thuật toán tính toán biểu th
                if (arrOperation.size() >= arrNumber.size() || arrOperation.size() <1) {
                    tvResult.setText("Lỗi định dạng");
                } else {
                for (int i = 0; i < (arrNumber.size() - 1); i++) {
                    switch (arrOperation.get(i)) {
                        case "+":
                            if (i == 0) {
                                result = arrNumber.get(i) + arrNumber.get(i + 1);
                            } else {
                                result = result + arrNumber.get(i + 1);
                            }
                            break;
                        case "-":
                            if (i == 0) {
                                result = arrNumber.get(i) - arrNumber.get(i + 1);
                            } else {
                                result = result - arrNumber.get(i + 1);
                            }
                            break;
                        case "*":
                            if (i == 0) {
                                result = arrNumber.get(i) * arrNumber.get(i + 1);
                            } else {
                                result = result * arrNumber.get(i + 1);
                            }
                            break;
                        case "/":
                            if (i == 0) {
                                result = arrNumber.get(i) / arrNumber.get(i + 1);
                            } else {
                                result = result / arrNumber.get(i + 1);
                            }
                            break;
                        default:
                            break;
                    }
                }
                    tvResult.setText(df.format(result) +"");  // định dạng double => int nếu tròn
                }
//                Log.d(TAG,"onClick: "+result);
        }
    }
    // xóa phía sau nhưng con trỏ ở phía trước
//    public String deleteANumber(String number){
//        int length = number.length();
//        String tem = number.substring(0,length-1);
//        return tem;
//    }

    // mảng chứa các phép tính +,-,*,/
    public ArrayList<String>arrOperation;
    // mảng chưa các số
    public  ArrayList<Double>arrNumber;

    // lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input){
        arrOperation = new ArrayList<>();
        arrNumber = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i=0; i< cArray.length; i++){
            switch (cArray[i]){
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    // lấy tất cả các số lưu vào mảng arrNumber
    public  void addNumber(String stringInput){
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
