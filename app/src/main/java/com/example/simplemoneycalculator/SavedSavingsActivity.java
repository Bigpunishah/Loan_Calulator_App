package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedSavingsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView savingsListView;

    private LoansSavingsDB db;
    private SavingsAdapter savingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_savings_listview);

        //get DB
        db = new LoansSavingsDB(this);
        //Get values from DB
        ArrayList<Savings> savings = db.getSavings();
        //Use custom adapter for custom list to be inflated
        savingsAdapter = new SavingsAdapter(this, R.layout.saved_savings_listview, savings);
        savingsListView = findViewById(R.id.savingsListView);
        savingsListView.setAdapter(savingsAdapter);
        savingsListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Get the selected loan from the adapter
        Savings selectedSavings = (Savings) savingsAdapter.getItem(position);

        // Pass the selected loan to the dialog
        SavingsSelectedDialog dialog = new SavingsSelectedDialog(this, selectedSavings);
        dialog.show();
    }

    //Refresh the list
    private void refreshSavingsList(){
        // Clear the existing list of loans
        savingsAdapter.clear();

        // Reload data from the database
        ArrayList<Savings> savings = db.getSavings();

        // Update the adapter with the new data
        savingsAdapter.addAll(savings);

        // Notify the adapter that the data set has changed
        savingsAdapter.notifyDataSetChanged();
    }

    //On resume refresh the list.
    @Override
    protected void onResume() {
        super.onResume();
        refreshSavingsList();
    }
}