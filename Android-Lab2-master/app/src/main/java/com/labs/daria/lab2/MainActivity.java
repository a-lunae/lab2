package com.labs.daria.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Integer firstValue;
    Integer secondValue;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        editText = (EditText) findViewById(R.id.editText1);
        setTitle("Калькулятор");
    }

    public void buttonClick(View view) {
        Button button = (Button) view;
        switch (button.getText().toString()) {
            case "C":
                firstValue = null;
                secondValue = null;
                operation = null;
                editText.setText("");
                break;
            case "<-":
                String s = editText.getText().toString();
                editText.setText(s.substring(0, s.length()-1));
                break;
            case "+":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "+";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "-":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "-";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "*":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "*";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "/":
                firstValue = Integer.valueOf(editText.getText().toString());
                operation = "/";
                editText.setText(editText.getText().toString() + button.getText());
                break;
            case "=":
                switch (operation) {
                    case "+":
                        editText.setText(String.valueOf((firstValue + secondValue)));
                        break;
                    case "-":
                        editText.setText(String.valueOf((firstValue - secondValue)));
                        break;
                    case "*":
                        editText.setText(String.valueOf((firstValue * secondValue)));
                        break;
                    case "/":
                        if (secondValue == 0) {
                            editText.setText("Ошибка");
                        } else {
                            String value = String.valueOf((firstValue / secondValue));
                            editText.setText(value);
                        }
                        break;
                    default:
                        editText.setText("WRONG");
                        break;
                }
                firstValue = null;
                secondValue = null;
                operation = null;
                break;
            default:
                if (operation != null) {
                    if (secondValue != null)
                        secondValue =
                                Integer.valueOf((String.valueOf(secondValue) + button.getText().toString()));
                    else
                        secondValue =
                                Integer.valueOf(button.getText().toString());
                }
                editText.setText(editText.getText().toString() + button.getText());
                break;
        }
    }
}