package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    //scroll view for putting back at top
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
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.savingsCalculateSavingsButton:
                makeFieldsVisible();
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
        savingsCalculatorScrollView.fullScroll(ScrollView.FOCUS_DOWN);
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
        savingsCalculatorScrollView.fullScroll(ScrollView.FOCUS_UP);

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

}