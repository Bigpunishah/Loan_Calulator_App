package com.example.simplemoneycalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoanAdapter extends ArrayAdapter<Loan>  {
    private TextView titleTextView;
    private TextView valueTextView;

    private ArrayList<Loan> loans;
    private Context context;
    //This file is for the single item .xml layout that will be populated for the listview
    public LoanAdapter(Context context, int resource, ArrayList<Loan> loans) {
        super(context, resource, loans);
        this.context = context;
        this.loans = loans;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        }

        // Get the loan object for this position
        Loan loan = loans.get(position);

        // Find TextViews in list item layout
        titleTextView = convertView.findViewById(R.id.titleTextView);
        valueTextView = convertView.findViewById(R.id.valueTextView);

        // Set loan data to TextViews
        if(loan == null){
            titleTextView.setText("No Loans saved");
            valueTextView.setText("Go save one from the Loan Calculator");
        } else {
            titleTextView.setText("Loan Title: " + loan.getTitle());
            valueTextView.setText("Loan Amount: " + String.valueOf(loan.getLoanAmount()));
        }
        return convertView;
    }


}