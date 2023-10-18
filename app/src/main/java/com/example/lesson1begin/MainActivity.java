package com.example.lesson1begin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //private EditText txtInfo; // init property for some purpose
    private TextView txtOutputOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //txtInfo = findViewById(R.id.txtInfo); // get object by id
        txtOutputOperation = findViewById(R.id.txtOutputOperation);
        txtOutputOperation.setText("Hello, World!");
    }

//    public void OnClickHandler(View view) {
//        String text = txtInfo.getText().toString();
//        Log.d("my-tag", "-----Нажали кнопку-----" + text);
//    }

    public void OnClearAllClickHandler(View view) {
        txtOutputOperation.setText("");
        Log.d("my-tag", "-----btn_ClearAll click-----");
    }

    public void OnDivisionClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty())
            return;
        Character lstChr = str.charAt(str.length() - 1);
        if (!Character.isDigit(lstChr))
            str = str.substring(0, str.length() - 1);
        txtOutputOperation.setText(str + "/");
        Log.d("my-tag", "-----btn_Division click-----");
    }

    public void OnMultiplicationClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty())
            return;
        Character lstChr = str.charAt(str.length() - 1);
        if (!Character.isDigit(lstChr))
            str = str.substring(0, str.length() - 1);
        txtOutputOperation.setText(str + "*");
        Log.d("my-tag", "-----btn_Multiplication click-----");
    }

    public void OnDeleteClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty())
            return;
        str = str.substring(0, str.length() - 1);
        txtOutputOperation.setText(str);
        Log.d("my-tag", "-----btn_Delete click-----");
    }

    public void On7ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "7");
        Log.d("my-tag", "-----btn_7 click-----");
    }

    public void On8ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "8");
        Log.d("my-tag", "-----btn_8 click-----");
    }

    public void On9ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "9");
        Log.d("my-tag", "-----btn_9 click-----");
    }

    public void OnMinusClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty())
            return;
        Character lstChr = str.charAt(str.length() - 1);
        if (!Character.isDigit(lstChr))
            switch(lstChr) {
                case '+':
                    str = str.substring(0, str.length() - 1);
                    break;
                case '-': {
                    Character preLstChr = str.charAt(str.length() - 2);
                    if (!Character.isDigit(preLstChr) && preLstChr != '.') {
                        str = str.substring(0, str.length() - 2);
                    }
                    else
                        str = str.substring(0, str.length() - 1);
                }
            }
        txtOutputOperation.setText(str + "-");
        Log.d("my-tag", "-----btn_Minus click-----");
    }

    public void On4ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "4");
        Log.d("my-tag", "-----btn_4 click-----");
    }

    public void On5ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "5");
        Log.d("my-tag", "-----btn_5 click-----");
    }

    public void On6ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "6");
        Log.d("my-tag", "-----btn_6 click-----");
    }

    public void OnPlusClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty())
            return;
        Character lstChr = str.charAt(str.length() - 1);
        if (!Character.isDigit(lstChr))
            str = str.substring(0, str.length() - 1);
        txtOutputOperation.setText(str + "+");
        Log.d("my-tag", "-----btn_Plus click-----");
    }

    public void On1ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "1");
        Log.d("my-tag", "-----btn_1 click-----");
    }

    public void On2ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "2");
        Log.d("my-tag", "-----btn_2 click-----");
    }

    public void On3ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "3");
        Log.d("my-tag", "-----btn_3 click-----");
    }

    public void On0ClickHandler(View view) {
        txtOutputOperation.setText(txtOutputOperation.getText() + "0");
        Log.d("my-tag", "-----btn_0 click-----");
    }

    public void OnDotClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty()) {
            txtOutputOperation.setText("0.");
            return;
        }
        Character lastChr = str.charAt(str.length() - 1);
        if (Character.isDigit(lastChr))
            txtOutputOperation.setText(str + ".");
        else
            txtOutputOperation.setText(str + "0.");
        Log.d("my-tag", "-----btn_Dot click-----");
    }

    public void OnDoubleZeroClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty()) {
            txtOutputOperation.setText("0");
            return;
        }
        Character lastChr = str.charAt(str.length() - 1);
        if (Character.isDigit(lastChr) || lastChr == '.') {
            txtOutputOperation.setText(txtOutputOperation.getText() + "00");
        }
        else {
            txtOutputOperation.setText(txtOutputOperation.getText() + "0");
        }

        Log.d("my-tag", "-----btn_Remainder click-----");
    }

    public void OnEqualsClickHandler(View view) {
        String str = (String)txtOutputOperation.getText();
        if (str.isEmpty())
            return;
        HashMap<Character, Integer> operators = new HashMap<Character, Integer>();
        for (Integer i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (!Character.isDigit(character) && character != '.') {
                if (character != '-' && i > 0)
                operators.put(character, i);
            }
        }
        Log.d("my-tag", "-----btn_Equals click-----");
    }
}