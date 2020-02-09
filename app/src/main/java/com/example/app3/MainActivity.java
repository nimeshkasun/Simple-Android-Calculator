package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String displayText="";
    double number1;
    String calProcess = "";

    public void addDigit(View view){
        TextView answer = findViewById(R.id.answer);
        String digit = ((Button)view).getText().toString();
        if(digit.equals(".") && displayText.indexOf(".")>=0)
            return;
        displayText += digit;
        if((displayText).indexOf(".")==0)
            displayText = "0"+displayText;
        answer.setText(displayText);
    }

    public void delDigit(View view){
        TextView answer = findViewById(R.id.answer);
        if(displayText != null && displayText.length() > 0){
            displayText = displayText.substring(0, displayText.length() - 1);
        }
        answer.setText(displayText);
    }

    public void clearDigit(View view){
        TextView answer = findViewById(R.id.answer);
        displayText="";
        answer.setText("0");
        number1 = 0;
    }

    public void  equals(View view){
        TextView answer = findViewById(R.id.answer);
        if(calProcess == "addition"){
            double outputVal = number1 + Double.parseDouble(displayText);
            String returnOutput = Double.toString(outputVal);
            answer.setText(returnOutput);
        }
        if(calProcess == "subs"){
            double outputVal = number1 - Double.parseDouble(displayText);
            String returnOutput = Double.toString(outputVal);
            answer.setText(returnOutput);
        }
        if(calProcess == "multi"){
            double outputVal = number1 * Double.parseDouble(displayText);
            String returnOutput = Double.toString(outputVal);
            answer.setText(returnOutput);
        }
        if(calProcess == "devi"){
            double outputVal = number1 / Double.parseDouble(displayText);
            String returnOutput = Double.toString(outputVal);
            answer.setText(returnOutput);
        }

    }

    public void addition(View view){
        TextView answer = findViewById(R.id.answer);
        number1 += Double.parseDouble(displayText);
        displayText = "";
        answer.setText("0");
        calProcess = "addition";
    }

    public void subs(View view){
        TextView answer = findViewById(R.id.answer);
        if(number1==0){
            number1 = Double.parseDouble(displayText);
        }else {
            number1 -= Double.parseDouble(displayText);
        }
        displayText = "";
        answer.setText("0");
        calProcess = "subs";
    }

    public void multi(View view){
        TextView answer = findViewById(R.id.answer);
        if(number1==0){
            number1 = Double.parseDouble(displayText);
        }else {
            number1 *= Double.parseDouble(displayText);
        }
        displayText = "";
        answer.setText("0");
        calProcess = "multi";
    }

    public void devi(View view){
        TextView answer = findViewById(R.id.answer);
        if(number1==0){
            number1 = Double.parseDouble(displayText);
        }else {
            number1 /= Double.parseDouble(displayText);
        }
        displayText = "";
        answer.setText("0");
        calProcess = "devi";
    }

    public void presen(View view){
        TextView answer = findViewById(R.id.answer);
        number1 = Double.parseDouble(displayText) / 100;
        displayText = "";
        String returnOutput = Double.toString(number1);
        answer.setText(returnOutput);
    }


}
