package com.example.simplemoneycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//This adapter is what sets up the list view for the saved values
public class SavingsAdapter extends ArrayAdapter<Savings> {
    private TextView titleTextView;
    private TextView valueTextView;

    private Context context;
    private ArrayList<Savings> savings;

    public SavingsAdapter(Context context, int resource, ArrayList<Savings> savings) {
        super(context, resource, savings);
        this.context = context;
        this.savings = savings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        }

        //Get the saving object for this position
        Savings saving = savings.get(position);

        //Find TextViews in list item layout
        titleTextView = convertView.findViewById(R.id.titleTextView);
        valueTextView = convertView.findViewById(R.id.valueTextView);

        // Set saving data to TextViews
        if(saving.getTitle() == null){
            titleTextView.setText("No Savings saved");
            valueTextView.setText("Go save one from the Loan Calculator");
        } else {
            titleTextView.setText("Title: " + saving.getTitle());
            valueTextView.setText("Deposit Amount: $" + saving.getDepositAmount());
        }

        return convertView;
    }
}