package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class LoanCalculatorActivity extends AppCompatActivity implements
        View.OnClickListener, LoanSaveDialog.LoanSaveDialogListener {

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
    private TextView totalInterestOnlyTextView;
    //These are the result text views
    private TextView paymentEveryRateTextView;
    private TextView totalPaymentsTextView;
    private TextView totalInterestTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_calculator);

        //Assign the variables created
        loanAmountEditText = (EditText) findViewById(R.id.loanAmountEditText);
        loanTermYearsEditText = (EditText) findViewById(R.id.loanTermYearsEditText);
        loanTermMonthsEditText = (EditText) findViewById(R.id.loanTermMonthsEditText);
        interestRateEditText = (EditText) findViewById(R.id.interestRateEditText);
        payRateSpinner = (Spinner) findViewById(R.id.payRateSpinner);
        calculateLoanButton = (Button) findViewById(R.id.calculateLoanButton);
        //result labels
        paymentEveryRateOnlyTextView = (TextView) findViewById(R.id.paymentEveryRateOnlyTextView);
        totalPaymentsOnlyTextView = (TextView) findViewById(R.id.totalPaymentsOnlyTextView);
        totalInterestOnlyTextView = (TextView) findViewById(R.id.totalInterestOnlyTextView);
        //result text views
        paymentEveryRateTextView = (TextView) findViewById(R.id.paymentEveryRateTextView);
        totalPaymentsTextView = (TextView) findViewById(R.id.totalPaymentsTextView);
        totalInterestTextView = (TextView) findViewById(R.id.totalInterestTextView);

        calculateLoanButton.setOnClickListener(this);
    }

    //Correct way to use onClickListener
    //calculateLoanButton.setOnClickListener(this);
    //implements android.view.View.OnClickListener
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.calculateLoanButton:
                calculateAndDisplay();
                break;
            default:
                break;
        }
    }

    public void calculateAndDisplay(){
        double loanAmount;
        double loanTermInMonths;
        double interestRate;
        double payments;
        double totalInterest;
        double totalPayback;

        //Hide keyboard
//        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        //Formula for monthly loan payments:
        //Interest rate is divided by 100 to turn whole number into percent value
        // (LoanAmount * (InterestRate / 100 / 12))
        //---------------------------------------- my form of a division bar
        // 1 - (1 + (InterestRate/100/12))^LoanTerm
        //I hope I understand this in the future

        //Ensure values are in place to calculate
        if(loanAmountEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Loan Amount Must Be Greater Than 0.", Toast.LENGTH_SHORT).show();
            return;
        }

        loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());

        //Ensure months && years is not empty
        if(loanTermYearsEditText.getText().toString().isEmpty() && loanTermMonthsEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Loan term must be greater than 0.", Toast.LENGTH_SHORT).show();
            return;
        }

        //Parse the values after ensuring at least one field is filled
        double years = loanTermYearsEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(loanTermYearsEditText.getText().toString());
        double months = loanTermMonthsEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(loanTermMonthsEditText.getText().toString());
        // Combining years & months to create a total of months
        loanTermInMonths = (years * 12) + months;

        if(interestRateEditText.getText().toString().isEmpty()){
            interestRateEditText.setText("0");
            interestRate = 0;
            Toast.makeText(this, "Interest rate set to 0 since left blank.", Toast.LENGTH_SHORT).show();

        } else {
            interestRate = Double.parseDouble(interestRateEditText.getText().toString()) / 100 / 12;
        }


        //Decimal formatter for the Doubles
        DecimalFormat df = new DecimalFormat("#.##");

        //Get the item integer from spinner
        int payRateSpinnerSelection = payRateSpinner.getSelectedItemPosition();
        switch (payRateSpinnerSelection){
            case 0:
                //Monthly pay rate
                if(interestRate == 0){
                    payments = loanAmount / loanTermInMonths;
                    totalInterest = 0;
                } else {
                    payments = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTermInMonths));
                    totalInterest = (payments * loanTermInMonths) - loanAmount;
                }
                totalPayback = totalInterest + loanAmount;
                paymentEveryRateOnlyTextView.setText("Pay Every Month");
                totalPaymentsOnlyTextView.setText("Total of " + df.format(loanTermInMonths) + " Payments");

                paymentEveryRateTextView.setText("$"+df.format(payments));
                totalPaymentsTextView.setText("$"+df.format(totalPayback));
                totalInterestTextView.setText("$"+df.format(totalInterest));
                setFieldsVisible();
                break;

            case 1:
                //Bi Weekly pay rate
                double loanTermBiWeekly = loanTermInMonths / 12 * 26;
                if(interestRate == 0){
                    payments = loanAmount / loanTermBiWeekly;
                    totalInterest = 0;
                } else{
                    payments = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTermBiWeekly));
                    totalInterest = (payments * loanTermBiWeekly) - loanAmount;
                }
                totalPayback = totalInterest + loanAmount;
                paymentEveryRateOnlyTextView.setText("Pay Every 2 Weeks");
                totalPaymentsOnlyTextView.setText("Total of " + df.format(loanTermBiWeekly) + " Payments");

                paymentEveryRateTextView.setText("$"+df.format(payments));
                totalPaymentsTextView.setText("$"+df.format(totalPayback));
                totalInterestTextView.setText("$"+df.format(totalInterest));
                setFieldsVisible();
                break;
            case 2:
                //Weekly pay rate
                double loanTermWeekly = loanTermInMonths / 12 * 52;
                if(interestRate == 0){
                    payments = loanAmount / loanTermWeekly;
                    totalInterest = 0;
                } else{
                    payments = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTermWeekly));
                    totalInterest = (payments * loanTermWeekly) - loanAmount;
                }
                totalPayback = totalInterest + loanAmount;
                paymentEveryRateOnlyTextView.setText("Pay Every Week");
                totalPaymentsOnlyTextView.setText("Total of " + df.format(loanTermWeekly) + " Payments");

                paymentEveryRateTextView.setText("$"+df.format(payments));
                totalPaymentsTextView.setText("$"+df.format(totalPayback));
                totalInterestTextView.setText("$"+df.format(totalInterest));
                setFieldsVisible();
                break;
            case 3:
                //Daily pay rate
                double loanTermDaily = loanTermInMonths / 12 * 365;
                if(interestRate == 0){
                    payments = loanAmount / loanTermDaily;
                    totalInterest = 0;
                } else{
                    payments = (loanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -loanTermDaily));
                    totalInterest = (payments * loanTermDaily) - loanAmount;
                }
                totalPayback = totalInterest + loanAmount;
                paymentEveryRateOnlyTextView.setText("Pay Every Day");
                totalPaymentsOnlyTextView.setText("Total of " + df.format(loanTermDaily) + " Payments");

                paymentEveryRateTextView.setText("$"+df.format(payments));
                totalPaymentsTextView.setText("$"+df.format(totalPayback));
                totalInterestTextView.setText("$"+df.format(totalInterest));
                setFieldsVisible();
                break;
        }

    }

    public void setFieldsVisible(){
        paymentEveryRateOnlyTextView.setVisibility(View.VISIBLE);
        totalPaymentsOnlyTextView.setVisibility(View.VISIBLE);
        totalInterestOnlyTextView.setVisibility(View.VISIBLE);
        paymentEveryRateTextView.setVisibility(View.VISIBLE);
        totalPaymentsTextView.setVisibility(View.VISIBLE);
        totalInterestTextView.setVisibility(View.VISIBLE);
    }

    public void clearAllFields(){
        loanAmountEditText.setText("");
        loanTermYearsEditText.setText("");
        loanTermMonthsEditText.setText("");
        interestRateEditText.setText("");
        payRateSpinner.setSelection(0);
        paymentEveryRateOnlyTextView.setVisibility(View.INVISIBLE);
        totalPaymentsOnlyTextView.setVisibility(View.INVISIBLE);
        totalInterestOnlyTextView.setVisibility(View.INVISIBLE);
        paymentEveryRateTextView.setVisibility(View.INVISIBLE);
        totalPaymentsTextView.setVisibility(View.INVISIBLE);
        totalInterestTextView.setVisibility(View.INVISIBLE);

    }

    //Inflate menu & select options
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.save_loan_savings_menu, menu);
        return true;
    }

    //On selection of the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSave:
                //execute saving loan
                //Ensuring data is in proper positions & the calculations are correct.
                calculateAndDisplay();
                //If the default value is there then it has not been calculated.
                if(!paymentEveryRateTextView.getText().toString().equals("TextView")){
                    LoanSaveDialog dialog = new LoanSaveDialog(LoanCalculatorActivity.this);
                    dialog.show();
                }
                return true;
            case R.id.menuClear:
                //execute clearing the info in the fields
                clearAllFields();
                Toast.makeText(this, "Cleared the input fields", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onSaveClicked(String title, String description) {

    }
}