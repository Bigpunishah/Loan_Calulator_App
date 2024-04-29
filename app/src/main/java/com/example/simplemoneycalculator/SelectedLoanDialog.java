package com.example.simplemoneycalculator;


import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SelectedLoanDialog extends Dialog {

    //Create variables
    private TextView selectedLoanTitleTextView;
    private TextView selectedLoanDescriptionTextView;
    private TextView selectedLoanAmountTextView;
    private TextView selectedLoanTermTextView;
    private TextView selectedLoanInterestTextView;
    private TextView selectedLoanPayRateTextView;
    private TextView selectedLoanPaymentsTextView;
    private TextView selectedLoanTotalNumberOfPaymentsTextView;
    private TextView selectedLoanTotalPayTextView;
    private TextView selectedLoanTotalInterestTextView;
    private Loan selectedLoan;


    //Create the dialog with the layout
    public SelectedLoanDialog(Context context, Loan loan) {
        super(context);
        selectedLoan = loan;
        setContentView(R.layout.dialog_selected_loan);
        initializeFields();
    }

    //Initialize the fields
    private void initializeFields(){
        DecimalFormat df = new DecimalFormat("#.##");
        selectedLoanTitleTextView = (TextView) findViewById(R.id.selectedLoanTitleTextView);
        selectedLoanDescriptionTextView = (TextView) findViewById(R.id.selectedLoanDescriptionTextView);
        selectedLoanAmountTextView = (TextView) findViewById(R.id.selectedLoanAmountTextView);
        selectedLoanTermTextView = (TextView) findViewById(R.id.selectedLoanTermTextView);
        selectedLoanInterestTextView = (TextView) findViewById(R.id.selectedLoanInterestTextView);
        selectedLoanPaymentsTextView = (TextView) findViewById(R.id.selectedLoanPaymentsTextView);
        selectedLoanPayRateTextView = (TextView) findViewById(R.id.selectedLoanPayRateTextView);
        selectedLoanTotalNumberOfPaymentsTextView = (TextView) findViewById(R.id.selectedLoanTotalNumberOfPaymentsTextView);
        selectedLoanTotalPayTextView = (TextView) findViewById(R.id.selectedLoanTotalPayTextView);
        selectedLoanTotalInterestTextView = (TextView) findViewById(R.id.selectedLoanTotalInterestTextView);

        selectedLoanTitleTextView.setText(selectedLoan.getTitle());
        selectedLoanDescriptionTextView.setText(selectedLoan.getDescription());
        selectedLoanAmountTextView.setText(df.format(selectedLoan.getLoanAmount()));
        selectedLoanTermTextView.setText(df.format(selectedLoan.getLoanTermInYears()) + " Years");
        selectedLoanInterestTextView.setText(df.format(selectedLoan.getInterestRate()));
        selectedLoanPaymentsTextView.setText(df.format(selectedLoan.getPayments()));
        selectedLoanPayRateTextView.setText(selectedLoan.getPayRate());
        selectedLoanTotalNumberOfPaymentsTextView.setText(df.format(selectedLoan.getNumberOfPayments()));
        selectedLoanTotalPayTextView.setText(df.format(selectedLoan.getTotalPayback()));
        selectedLoanTotalInterestTextView.setText(df.format(selectedLoan.getTotalInterest()));
    }
}