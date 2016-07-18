package com.alikhani.jalal.calculatorwithunittestsjavaandroid;

/**
 * Created by J.Alikhani on 18/07/16.
 *
 * To Demo Unit Tests in Java Android
 * Strictly MVC model
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    TextView accumulator;
    Boolean userTouchedCalculator = false;
    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        accumulator = (TextView) findViewById(R.id.accumalator);
    }

    public void onClickDigit(View v)
    {
        String accumulatorValue = ((Button) v).getText().toString();
        if(userTouchedCalculator) {
            accumulator.setText(accumulator.getText() + accumulatorValue);
        } else {
            accumulator.setText(accumulatorValue);
        }
        userTouchedCalculator = true;
        return;
    }

    public void onClickOperand(View v)
    {
        String operand = ((Button) v).getText().toString();
        accumulator.setText(calculatorModel.Operator(accumulator.getText().toString(), operand));
        userTouchedCalculator = false;
        return;
    }
}
