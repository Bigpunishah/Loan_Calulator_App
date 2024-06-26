package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedLoansActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView loansListView;

    private LoansSavingsDB db;
    private LoanAdapter loanAdapter;

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
        loansListView = findViewById(R.id.loansListView);
        loansListView.setAdapter(loanAdapter);
        loansListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Get the selected loan from the adapter
        Loan selectedLoan = (Loan) loanAdapter.getItem(position);

        // Pass the selected loan to the dialog
        LoanSelectedDialog dialog = new LoanSelectedDialog(this, selectedLoan);
        dialog.show();
    }


    //Refreshes the list
    private void refreshLoanList() {
        // Clear the existing list of loans
        loanAdapter.clear();

        // Reload data from the database
        ArrayList<Loan> loans = db.getLoans();

        // Update the adapter with the new data
        loanAdapter.addAll(loans);

        // Notify the adapter that the data set has changed
        loanAdapter.notifyDataSetChanged();
    }

    //On resume refresh the list.
    @Override
    protected void onResume() {
        super.onResume();
        refreshLoanList();
    }


}