package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    //Access Menu Items Information
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        //Fin the menu by ID
        MenuItem savedLoansMenuItem = (MenuItem) menu.findItem(R.id.savedLoansMenuItem);
        MenuItem savedSavingsMenuItem = (MenuItem) menu.findItem(R.id.savedSavingsMenuItem);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle the menu item selection
        switch (item.getItemId()){
            case R.id.savedLoansMenuItem:
                //Execute code to show saved loans
                return true;
            case R.id.savedSavingsMenuItem:
                //Execute code to show saved savings
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}