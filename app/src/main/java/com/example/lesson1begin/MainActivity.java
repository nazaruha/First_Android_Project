package com.example.lesson1begin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //private EditText txtInfo; // init property for some purpose
    private TextView txtOutputOperation;
    HashMap<String, Integer> precedence = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //txtInfo = findViewById(R.id.txtInfo); // get object by id
        txtOutputOperation = findViewById(R.id.txtOutputOperation);
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
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

        double result = evaluateExpression(str);
        txtOutputOperation.setText(String.format("%s", result));

//        HashMap<Character, Integer> operators = new HashMap<Character, Integer>();
//        for (Integer i = 0; i < str.length(); i++) {
//            char character = str.charAt(i);
//            if (!Character.isDigit(character) && character != '.') {
//                if (character == '-' && (i == 0 || (!Character.isDigit(str.charAt(i - 1)) && str.charAt(i - 1) != '.')))
//                    continue;
//                operators.put(character, i);
//            }
//        }
        Log.d("my-tag", "-----btn_Equals click-----");
    }

    public double evaluateExpression(String expression) {
        // Розбити вираз на операнди та оператори
        String[] tokens = expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        // Створити стеки для операндів і операторів
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        // Визначити пріорітетність операцій
        HashMap<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        // Пройтися по всіх токенах
        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                // Якщо це число, додати його до стеку операндів
                operands.push(Double.parseDouble(token));
            } else if (token.matches("[+\\-*/]")) {
                // Якщо це оператор, обробити його пріорітетність
                while (!operators.isEmpty() && precedence.get(operators.peek()) >= precedence.get(token)) {
                    double b = operands.pop();
                    double a = operands.pop();
                    String operator = operators.pop();
                    double result = performOperation(a, b, operator);
                    operands.push(result);
                }
                operators.push(token);
            }
        }

        // Виконати решту операцій, які залишились у стеках
        while (!operators.isEmpty()) {
            double b = operands.pop();
            double a = operands.pop();
            String operator = operators.pop();
            double result = performOperation(a, b, operator);
            operands.push(result);
        }

        // Результат знаходиться на вершині стеку operands
        return operands.pop();
    }

    private double performOperation(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    // Обробка помилки ділення на нуль
                    throw new ArithmeticException("Ділення на нуль");
                }
            default:
                throw new IllegalArgumentException("Невідомий оператор: " + operator);
        }
    }
}