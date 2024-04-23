package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LoanCalculatorActivity extends AppCompatActivity {

    //Create all variables that will be associated with the activity
    private EditText loanAmountEditText;
    private EditText loanTermYearsEditText;
    private EditText loanTermMonthsEditText;
    private EditText interestRateEditText;
    private Spinner payRateSpinner;
    private Button calculateLoanButton;
    //These are the result labels
    private TextView paymentEveryRateOnlyTextView;
    private TextView totalPaymentsOnlyTextView;
    //These are the result text views
    private TextView paymentEveryRateTextView;
    private TextView totalPaymentsTextView;
    private TextView totalInterestTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_calculator);
    }
}