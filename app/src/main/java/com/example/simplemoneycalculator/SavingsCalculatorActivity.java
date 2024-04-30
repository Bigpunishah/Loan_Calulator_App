package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class SavingsCalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    //create the values in xml
    private EditText savingsInitialDepositEditText;
    private Spinner savingsDepositFrequencySpinner;
    private EditText savingsYearlyDepositEditText;
    private EditText savingsDurationYearsEditText;
    private EditText savingsDurationMonthsEditText;
    private EditText savingsYearlyInterestEditText;
    private Button savingsCalculateSavingsButton;

    //Label TextViews
    private TextView savingsInitialCalculatedAmountTextView;
    //"Total of .. Contributions
    private TextView savingsTotalContributionsTextView;
    private TextView savingsTotalInterestEarnedTextView;
    private TextView savingsTotalTextView;
    //Calculated value TextViews
    private TextView savingsInitialAmountCalculatedTextView;
    private TextView savingsTotalContributionsCalculatedTextView;
    private TextView savingsTotalInterestEarnedCalculatedTextView;
    private TextView savingsTotalCalculatedTextView;

    private LoansSavingsDB db;

    //scroll view for putting view back at top or bottom
    private ScrollView savingsCalculatorScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savings_calulator);

        savingsInitialDepositEditText = (EditText) findViewById(R.id.savingsInitialDepositEditText);
        savingsDepositFrequencySpinner = (Spinner) findViewById(R.id.savingsDepositFrequencySpinner);
        savingsYearlyDepositEditText = (EditText) findViewById(R.id.savingsYearlyDepositEditText);
        savingsDurationYearsEditText = (EditText) findViewById(R.id.savingsDurationYearsEditText);
        savingsDurationMonthsEditText = (EditText) findViewById(R.id.savingsDurationMonthsEditText);
        savingsYearlyInterestEditText = (EditText) findViewById(R.id.savingsYearlyInterestEditText);
        savingsCalculateSavingsButton = (Button) findViewById(R.id.savingsCalculateSavingsButton);

        //Label TextViews
        savingsInitialCalculatedAmountTextView = (TextView) findViewById(R.id.savingsInitialCalculatedAmountTextView);
        savingsTotalContributionsTextView = (TextView) findViewById(R.id.savingsTotalContributionsTextView);
        savingsTotalInterestEarnedTextView = (TextView) findViewById(R.id.savingsTotalInterestEarnedTextView);
        savingsTotalTextView = (TextView) findViewById(R.id.savingsTotalTextView);
        //Calculated TextViews
        savingsInitialAmountCalculatedTextView = (TextView) findViewById(R.id.savingsInitialAmountCalculatedTextView);
        savingsTotalContributionsCalculatedTextView = (TextView) findViewById(R.id.savingsTotalContributionsCalculatedTextView);
        savingsTotalInterestEarnedCalculatedTextView = (TextView) findViewById(R.id.savingsTotalInterestEarnedCalculatedTextView);
        savingsTotalCalculatedTextView = (TextView) findViewById(R.id.savingsTotalCalculatedTextView);

        savingsCalculateSavingsButton.setOnClickListener(this);

        //Scroll view reference
        savingsCalculatorScrollView = (ScrollView) findViewById(R.id.savingsCalculatorScrollView);

        db = new LoansSavingsDB(this);
    }

    public void calculateAndDisplay(){
        double initialAmount;
        double totalAmount;
        double totalInterest;
        double totalContributions;

        // Obtain the input method manager
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // Hide the keyboard
        imm.hideSoftInputFromWindow(savingsCalculateSavingsButton.getWindowToken(), 0);

        DecimalFormat df = new DecimalFormat("#.##");

        //Ensure values are in place to calculate
        if(savingsInitialDepositEditText.getText().toString().isEmpty()){
            Toast.makeText(this, "Initial Deposit must have a value", Toast.LENGTH_SHORT).show();
            return;
        }
        initialAmount = Double.parseDouble(savingsInitialDepositEditText.getText().toString());

        int savingsSpinnerFrequencySpinner = savingsDepositFrequencySpinner.getSelectedItemPosition();
        double frequentDeposit = Double.parseDouble(savingsYearlyDepositEditText.getText().toString());
        double years = savingsDurationYearsEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(savingsDurationYearsEditText.getText().toString());
        double months = savingsDurationMonthsEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(savingsDurationMonthsEditText.getText().toString());
        double durationMonths = (years * 12) + months;
        double interestRate = savingsYearlyInterestEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(savingsYearlyInterestEditText.getText().toString()) / 100;


        switch (savingsSpinnerFrequencySpinner){
            case 0:
                //Yearly
                if(interestRate == 0){
                    totalAmount = initialAmount + frequentDeposit * (durationMonths / 12);
                    totalInterest = 0;
                }else{
                    totalAmount = initialAmount * Math.pow(1 + interestRate, durationMonths / 12.0) + frequentDeposit * ((Math.pow(1 + interestRate, durationMonths / 12.0) - 1) / interestRate);
                    totalContributions = (frequentDeposit * (durationMonths / 12));
                    totalInterest = totalAmount - totalContributions;
                }
                totalContributions = (frequentDeposit * (durationMonths / 12));

                savingsTotalContributionsTextView.setText("Total of " +df.format(durationMonths/12) + " Contributions");


                savingsInitialAmountCalculatedTextView.setText("$"+initialAmount);
                savingsTotalContributionsCalculatedTextView.setText("+$"+df.format(totalContributions));
                savingsTotalInterestEarnedCalculatedTextView.setText("+$"+df.format(totalInterest));
                savingsTotalCalculatedTextView.setText("$"+df.format(totalAmount));
                makeFieldsVisible();
                break;
            case 1:
                //Monthly
                if(interestRate == 0){
                    totalAmount = initialAmount + frequentDeposit * durationMonths;
                    totalInterest = 0;
                }else{
                    totalAmount = initialAmount * Math.pow(1 + interestRate, durationMonths) + frequentDeposit * ((Math.pow(1 + interestRate, durationMonths) - 1) / interestRate);
                    totalContributions = (frequentDeposit * durationMonths);
                    totalInterest = totalAmount - totalContributions;
                }
                totalContributions = (frequentDeposit * durationMonths);

                savingsTotalContributionsTextView.setText("Total of " +df.format(durationMonths) + " Contributions");


                savingsInitialAmountCalculatedTextView.setText("+$"+initialAmount);
                savingsTotalContributionsCalculatedTextView.setText("+$"+df.format(totalContributions));
                savingsTotalInterestEarnedCalculatedTextView.setText("+$"+df.format(totalInterest));
                savingsTotalCalculatedTextView.setText("$"+df.format(totalAmount));
                makeFieldsVisible();
                break;
            case 2:
                //Bi-Weekly
                if(interestRate == 0){
                    totalAmount = initialAmount + frequentDeposit * (durationMonths / 12) * 26;
                    totalInterest = 0;

                }else{
                    double pow = Math.pow(1 + interestRate, durationMonths / 12 * 26);
                    totalAmount = initialAmount * pow + frequentDeposit * ((pow - 1) / interestRate);
                    totalContributions = (frequentDeposit * durationMonths / 12 * 26);
                    totalInterest = totalAmount - totalContributions;
                }
                totalContributions = (frequentDeposit * durationMonths / 12 * 26);

                savingsTotalContributionsTextView.setText("Total of " +df.format(durationMonths / 12 * 26) + " Contributions");


                savingsInitialAmountCalculatedTextView.setText("$"+initialAmount);
                savingsTotalContributionsCalculatedTextView.setText("+$"+df.format(totalContributions));
                savingsTotalInterestEarnedCalculatedTextView.setText("+$"+df.format(totalInterest));
                savingsTotalCalculatedTextView.setText("$"+df.format(totalAmount));
                makeFieldsVisible();
                break;
            case 3:
                //Weekly
                if(interestRate == 0){
                    totalAmount = initialAmount + frequentDeposit * (durationMonths / 12) * 52;
                }else{
                    double pow = Math.pow(1 + interestRate, durationMonths / 12 * 52);
                    totalAmount = initialAmount * pow + frequentDeposit * ((pow - 1) / interestRate);
                }
                totalContributions = (frequentDeposit * durationMonths / 12 * 52);
                totalInterest = totalAmount - totalContributions;

                savingsTotalContributionsTextView.setText("Total of " +df.format(durationMonths / 12 * 52) + " Contributions");

                savingsInitialAmountCalculatedTextView.setText("$"+initialAmount);
                savingsTotalContributionsCalculatedTextView.setText("+$"+df.format(totalContributions));
                savingsTotalInterestEarnedCalculatedTextView.setText("+$"+df.format(totalInterest));
                savingsTotalCalculatedTextView.setText("$"+df.format(totalAmount));
                makeFieldsVisible();
                break;
            case 4:
                //Daily
                if(interestRate == 0){
                    totalAmount = initialAmount + frequentDeposit * (durationMonths / 12) * 365;
                    totalInterest = 0;
                }else{
                    double pow = Math.pow(1 + interestRate, durationMonths / 12 * 365);
                    totalAmount = initialAmount * pow + frequentDeposit * ((pow - 1) / interestRate);
                    totalContributions = (frequentDeposit * durationMonths / 12 * 365);
                    totalInterest = totalAmount - totalContributions;
                }
                totalContributions = (frequentDeposit * durationMonths / 12 * 365);


                savingsTotalContributionsTextView.setText("Total of " +df.format(durationMonths / 12 * 365) + " Contributions");

                savingsInitialAmountCalculatedTextView.setText("$"+initialAmount);
                savingsTotalContributionsCalculatedTextView.setText("+$"+df.format(totalContributions));
                savingsTotalInterestEarnedCalculatedTextView.setText("+$"+df.format(totalInterest));
                savingsTotalCalculatedTextView.setText("$"+df.format(totalAmount));
                makeFieldsVisible();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.savingsCalculateSavingsButton:
                calculateAndDisplay();
                break;
            default:
                break;
        }
    }

    public void makeFieldsVisible(){
        savingsInitialCalculatedAmountTextView.setVisibility(View.VISIBLE);
        savingsTotalContributionsTextView.setVisibility(View.VISIBLE);
        savingsTotalInterestEarnedTextView.setVisibility(View.VISIBLE);
        savingsTotalTextView.setVisibility(View.VISIBLE);
        savingsInitialAmountCalculatedTextView.setVisibility(View.VISIBLE);
        savingsTotalContributionsCalculatedTextView.setVisibility(View.VISIBLE);
        savingsTotalInterestEarnedCalculatedTextView.setVisibility(View.VISIBLE);
        savingsTotalCalculatedTextView.setVisibility(View.VISIBLE);
        savingsCalculatorScrollView.smoothScrollTo(0,500);
        //Hide keyboard next
    }

    public void clearAllFields(){
        savingsInitialDepositEditText.setText("");
        savingsDepositFrequencySpinner.setSelection(0);
        savingsYearlyDepositEditText.setText("");
        savingsDurationYearsEditText.setText("");
        savingsDurationMonthsEditText.setText("");
        savingsYearlyInterestEditText.setText("");
        savingsInitialCalculatedAmountTextView.setVisibility(View.INVISIBLE);
        savingsTotalContributionsTextView.setVisibility(View.INVISIBLE);
        savingsTotalInterestEarnedTextView.setVisibility(View.INVISIBLE);
        savingsTotalTextView.setVisibility(View.INVISIBLE);
        savingsInitialAmountCalculatedTextView.setVisibility(View.INVISIBLE);
        savingsTotalContributionsCalculatedTextView.setVisibility(View.INVISIBLE);
        savingsTotalInterestEarnedCalculatedTextView.setVisibility(View.INVISIBLE);
        savingsTotalCalculatedTextView.setVisibility(View.INVISIBLE);

        //send the scroll view back to top
        savingsCalculatorScrollView.smoothScrollTo(0,0);

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
                //execute saving savings
                calculateAndDisplay(); //Calculate before saving values
                if(!checkIfEmpty()){
                    SavingsSaveDialog dialog = new SavingsSaveDialog(SavingsCalculatorActivity.this, db, savingToSendDialog());
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

    private boolean checkIfEmpty(){
        if(savingsInitialDepositEditText.equals("") && savingsYearlyDepositEditText.equals("")){
            return true;
        }else{
            return false;
        }
    }

    private Savings savingToSendDialog(){
        Savings saving = new Savings();
        saving.setListId(2);
        saving.setInitialAmount(Double.parseDouble(savingsInitialDepositEditText.getText().toString()));
        saving.setDepositFrequency(savingsDepositFrequencySpinner.getSelectedItem().toString());
        saving.setDepositAmount(Double.parseDouble(savingsYearlyDepositEditText.getText().toString()));
        double years = savingsDurationYearsEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(savingsDurationYearsEditText.getText().toString());
        double months = savingsDurationMonthsEditText.getText().toString().isEmpty() ? 0 : Double.parseDouble(savingsDurationMonthsEditText.getText().toString());
        double durationMonths = (years * 12)  + months;
        saving.setDuration(durationMonths);
        saving.setInterest(Double.parseDouble(savingsYearlyInterestEditText.getText().toString()));

        DecimalFormat df = new DecimalFormat("#.##");
        double contributionCount = 0;
        //Switch to determine contributions
        switch (savingsDepositFrequencySpinner.getSelectedItemPosition()){
            case 0:
                contributionCount = Double.parseDouble(df.format(durationMonths / 12));
                break;
            case 1:
                contributionCount = Double.parseDouble(df.format(durationMonths));
                break;
            case 2:
                contributionCount = Double.parseDouble(df.format(durationMonths / 12 * 26));
                break;
            case 3:
                contributionCount = Double.parseDouble(df.format(durationMonths / 12 * 52));
                break;
            case 4:
                contributionCount = Double.parseDouble(df.format(durationMonths / 12 * 365));
                break;
        }

        saving.setNumberOfContributions(contributionCount);

        saving.setTotalContributions(Double.parseDouble(savingsTotalContributionsCalculatedTextView.getText().toString().replace("$", "")));
        saving.setTotalInterest(Double.parseDouble(savingsTotalInterestEarnedCalculatedTextView.getText().toString().replace("$", "")));
        saving.setTotalAmount(Double.parseDouble(savingsTotalCalculatedTextView.getText().toString().replace("$", "")));

        return saving;
    }

}