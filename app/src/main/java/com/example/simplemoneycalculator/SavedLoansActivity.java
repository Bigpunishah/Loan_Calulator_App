package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SavedLoansActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView loansListView;

    private LoansSavingsDB db;
    private LoanAdapter loanAdapter;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_loans_listview);

        //Get the db
        db = new LoansSavingsDB(this);
        //Get values from db
        ArrayList<Loan> loans = db.getLoans();
        //Use the custom adapter for the custom  view to be inflated
        loanAdapter = new LoanAdapter(this, R.layout.saved_loans_listview, loans);
        loansListView = (ListView) findViewById(R.id.loansListView);
        loansListView.setAdapter(loanAdapter);
        loansListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        db = new LoansSavingsDB(this);
        ArrayList<Loan> loans = db.getLoans();
        Loan selectedLoan = loans.get(position);

        SelectedLoanDialog dialog = new SelectedLoanDialog(this, selectedLoan);
        dialog.show();

    }
}