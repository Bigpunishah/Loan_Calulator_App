package com.example.simplemoneycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SavingsSelectedDialog extends Dialog {
    private TextView selectedSavingsTitleTextView;
    private TextView selectedSavingsDescriptionTextView;
    private TextView selectedSavingsAmountTextView;
    private TextView selectedSavingsDurationTextView;
    private TextView selectedSavingsInterestRateTextView;
    private TextView selectedSavingsDepositFrequencyTextView;
    private TextView selectedSavingsTotalContributionsTextView;
    private TextView selectedSavingsTotalInterestEarnedTextView;
    private TextView selectedSavingsTotalTextView;
    private TextView selectedTotalOfBlankContributionsTextView;
    private TextView selectedSavingsDepositAmountTextView;
    private Savings selectedSavings;

    public SavingsSelectedDialog(Context context, Savings savings) {
        super(context);
        selectedSavings = savings;
        setContentView(R.layout.dialog_selected_savings);
        initializeFields();
    }

    private void initializeFields(){
        DecimalFormat df = new DecimalFormat("#.##");
        selectedSavingsTitleTextView = (TextView) findViewById(R.id.selectedSavingsTitleTextView);
        selectedSavingsDescriptionTextView = (TextView) findViewById(R.id.selectedSavingsDescriptionTextView);
        selectedSavingsAmountTextView = (TextView) findViewById(R.id.selectedSavingsAmountTextView);
        selectedSavingsDurationTextView = (TextView) findViewById(R.id.selectedSavingsDurationTextView);
        selectedSavingsInterestRateTextView = (TextView) findViewById(R.id.selectedSavingsInterestRateTextView);
        selectedSavingsDepositFrequencyTextView = (TextView) findViewById(R.id.selectedSavingsDepositFrequencyTextView);
        selectedSavingsTotalContributionsTextView = (TextView) findViewById(R.id.selectedSavingsTotalContributionsTextView);
        selectedSavingsTotalInterestEarnedTextView = (TextView) findViewById(R.id.selectedSavingsTotalInterestEarnedTextView);
        selectedSavingsTotalTextView = (TextView) findViewById(R.id.selectedSavingsTotalTextView);
        selectedSavingsDepositAmountTextView = (TextView) findViewById(R.id.selectedSavingsDepositAmountTextView);
        selectedTotalOfBlankContributionsTextView = (TextView) findViewById(R.id.selectedTotalOfBlankContributionsTextView);

        //Setting the contribution number
        selectedTotalOfBlankContributionsTextView.setText(selectedSavings.getNumberOfContributions() + " Contributions: ");

        selectedSavingsTitleTextView.setText(selectedSavings.getTitle());
        selectedSavingsDescriptionTextView.setText(selectedSavings.getDescription());
        selectedSavingsAmountTextView.setText("$" + df.format(selectedSavings.getInitialAmount()));
        selectedSavingsDurationTextView.setText(df.format(selectedSavings.getDuration()) + " Months");
        selectedSavingsInterestRateTextView.setText(df.format(selectedSavings.getInterest()) + "%");
        selectedSavingsDepositFrequencyTextView.setText(selectedSavings.getDepositFrequency());
        selectedSavingsDepositAmountTextView.setText("$" + df.format(selectedSavings.getDepositAmount()));
        selectedSavingsTotalContributionsTextView.setText("$" + df.format(selectedSavings.getTotalContributions()));
        selectedSavingsTotalInterestEarnedTextView.setText("$" + df.format(selectedSavings.getTotalInterest()));
        selectedSavingsTotalTextView.setText("$" + df.format(selectedSavings.getTotalAmount()));

    }
}