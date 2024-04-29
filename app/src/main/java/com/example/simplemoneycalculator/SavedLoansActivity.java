package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SavedLoansActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView valueTextView;

    private LoansSavingsDB db;
    private LoanAdapter loanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_loans);


        db = new LoansSavingsDB(this);

        ArrayList<List> loansList = db.getLoansList();
        loanAdapter = new LoanAdapter(this, R.layout.saved_loans, loansList);



    }
}