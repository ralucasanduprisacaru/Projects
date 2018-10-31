package com.ralu.numberscalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        // code used in all the operations
    public double[] getValues(View view) {
        double[] numbers = new double[2];
        TextView fn = (TextView) findViewById(R.id.firstNumber);
        TextView sn = (TextView) findViewById(R.id.secondNumber);

        double n1 = Double.parseDouble(fn.getText().toString());
        double n2 = Double.parseDouble(sn.getText().toString());
        numbers[0] = n1;
        numbers[1] = n2;
        return numbers;
    }

    public void calculateSum(View view) {
        double numbers[] = getValues(view);
        String sum = String.valueOf(numbers[0] + numbers[1]);
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(sum);
    }


    public void calcDiff(View view) {
        double numbers[] = getValues(view);
        String diff = String.valueOf(numbers[0] - numbers[1]);
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(diff);
    }

    public void calcMultip(View view) {
        double numbers[] = getValues(view);
        String mult = String.valueOf(numbers[0] * numbers[1]);
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(mult);
    }

    public void calcDiv(View view) {
        double numbers[] = getValues(view);
        TextView result = (TextView) findViewById(R.id.result);
        // check division by zero
        if (numbers[1] == 0) {
            result.setText("You can't divide by zero");
        } else {
            String div = String.valueOf(numbers[0] / numbers[1]);
            result.setText(div);
        }
    }
}
