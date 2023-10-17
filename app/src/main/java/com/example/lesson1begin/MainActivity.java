package com.example.lesson1begin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
}