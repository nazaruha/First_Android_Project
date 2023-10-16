package com.example.lesson1begin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtInfo; // init property for some purpose

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo = findViewById(R.id.txtInfo); // get object by id
    }

    public void OnClickHandler(View view) {
        String text = txtInfo.getText().toString();
        Log.d("my-tag", "-----Нажали кнопку-----" + text);
    }
}