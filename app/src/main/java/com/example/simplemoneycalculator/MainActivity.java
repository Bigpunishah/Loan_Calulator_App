package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Create variables
    private Button loanCalculatorButton;
    private Button savingCalculatorButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variables
        loanCalculatorButton = (Button) findViewById(R.id.loanCalculatorButton);
        savingCalculatorButton = (Button) findViewById(R.id.savingCalculatorButton);


        //Changing views from the MainActivity
        //Check LoanCalculatorActivity.java to see proper implementation of onClickListener
        loanCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent & then start that intent
                Intent intent = new Intent(MainActivity.this, LoanCalculatorActivity.class);
                startActivity(intent);
            }
        });


        savingCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SavingsCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }





    //Access Menu Items Information
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        //Fin the menu items by ID
        MenuItem savedLoansMenuItem = (MenuItem) menu.findItem(R.id.savedLoansMenuItem);
        MenuItem savedSavingsMenuItem = (MenuItem) menu.findItem(R.id.savedSavingsMenuItem);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle the menu item selection
        switch (item.getItemId()){
            case R.id.savedLoansMenuItem:
                //Create Intents like the onCreate method
                Intent intent = new Intent(MainActivity.this, SavedLoansActivity.class);
                startActivity(intent);
                return true;
            case R.id.savedSavingsMenuItem:
                //Execute code to show saved savings
                Intent intent1 = new Intent(MainActivity.this, SavedSavingsActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}