package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoanAdapter extends ArrayAdapter<List> {

    private ArrayList<List> loansList;
    private Context context;

    public LoanAdapter(Context context, int resource, ArrayList<List> loansList) {
        super(context, resource, loansList);
        this.context = context;
        this.loansList = loansList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.saved_loans, parent, false);
        }

        // Get the loan object for this position
        List list = loansList.get(position);

        // Find TextViews in list item layout
        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView valueTextView = convertView.findViewById(R.id.valueTextView);

        // Set loan data to TextViews
        titleTextView.setText(list.getTitle());
        valueTextView.setText(String.valueOf(list.getValue())); // Assuming value is an integer

        return convertView;
    }
}