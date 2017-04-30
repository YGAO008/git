package com.example.ygao008.tipcalculatorv0;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tipCalc;

    public NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipCalc = new TipCalculator(0.17f, 100.0f);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v)
    {
        EditText billEditText = (EditText) findViewById(R.id.amount_bill);
        EditText tipEditText = (EditText) findViewById(R.id.amount_tip_percent);

        String billString = billEditText.getText().toString();
        String tipStirng = tipEditText.getText().toString();

        TextView tipTextView = (TextView) findViewById(R.id.amount_tip);
        TextView totalTextView = (TextView) findViewById(R.id.amount_total);

        try{
            float billAmount = Float.parseFloat(billString);
            int tipParcent = Integer.parseInt(tipStirng);

            tipCalc.setBill(billAmount);
            tipCalc.setTip(.01f * tipParcent);

            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();

            tipTextView.setText(money.format(tip));
            totalTextView.setText(money.format(total));
        }catch (NumberFormatException nfe){
            // pop on an alert view here
        }
    }
}
