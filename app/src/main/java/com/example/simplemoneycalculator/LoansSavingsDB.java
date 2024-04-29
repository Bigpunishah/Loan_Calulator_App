package com.example.simplemoneycalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class LoansSavingsDB {

    //Database contents
    public static final String DB_NAME = "loansaving.db";
    public static final int DB_VERSION = 1;

    //Loan table contents
    public static final String LOAN_TABLE = "loan";

    public static final String LOAN_ID = "_id";
    public static final int LOAN_ID_COL = 0;

    public static final String LOAN_LIST_ID = "list_id";
    public static final int LOAN_LIST_ID_COL = 1;

    public static final String LOAN_TITLE = "loan_title";
    public static final int LOAN_TITLE_COL = 2;

    public static final String LOAN_DESCRIPTION = "loan_description";
    public static final int LOAN_DESCRIPTION_COL = 3;

    public static final String LOAN_AMOUNT = "loan_amount";
    public static final int LOAN_AMOUNT_COL = 4;

    public static final String LOAN_TERM_YEARS = "loan_term_years";
    public static final int LOAN_TERM_YEARS_COL = 5;

    public static final String LOAN_INTEREST_RATE = "loan_interest_rate";
    public static final int LOAN_INTEREST_RATE_COL = 6;

    public static final String LOAN_PAY_RATE = "pay_rate";
    public static final int LOAN_PAY_RATE_COL = 7;

    public static final String LOAN_PAYMENT = "loan_payments";
    public static final int LOAN_PAYMENTS_COL = 8;

    public static final String LOAN_TOTAL_NUMBER_PAYMENTS = "loan_number_of_payments";
    public static final int LOAN_TOTAL_NUMBER_PAYMENTS_COL = 9;


    public static final String LOAN_TOTAL_PAYBACK = "loan_total_payback";
    public static final int LOAN_TOTAL_PAYBACK_COL = 10;

    public static final String LOAN_TOTAL_INTEREST = "loan_total_interest";
    public static final int LOAN_TOTAL_INTEREST_COL = 11;

    public static final String CREATE_LOAN_TABLE =
            "CREATE TABLE " + LOAN_TABLE + " (" +
                    LOAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LOAN_LIST_ID + " INTEGER NOT NULL, " +
                    LOAN_TITLE + " TEXT NOT NULL, " +
                    LOAN_DESCRIPTION + " TEXT, " +
                    LOAN_AMOUNT + " INTEGER NOT NULL, " +
                    LOAN_TERM_YEARS + " INTEGER NOT NULL, " +
                    LOAN_INTEREST_RATE + " INTEGER NOT NULL, " +
                    LOAN_PAY_RATE + " TEXT NOT NULL, " +
                    LOAN_PAYMENT + " INTEGER NOT NULL, " +
                    LOAN_TOTAL_NUMBER_PAYMENTS + " INTEGER NOT NULL, " +
                    LOAN_TOTAL_PAYBACK + " INTEGER NOT NULL, " +
                    LOAN_TOTAL_INTEREST + " INTEGER NOT NULL);";

    //END OF LOAN SQL

    //SAVINGS SQL
    public static final String SAVINGS_TABLE = "savings";

    public static final String SAVINGS_ID = "_id";
    public static final int SAVINGS_ID_COL = 0;

    public static final String SAVINGS_LIST_ID = "list_id";
    public static final int SAVINGS_LIST_ID_COL = 1;

    public static final String SAVINGS_TITLE = "savings_title";
    public static final int SAVINGS_TITLE_COL = 2;

    public static final String SAVINGS_DESCRIPTION = "savings_description";
    public static final int SAVINGS_DESCRIPTION_COL = 3;

    public static final String SAVINGS_INITIAL_AMT = "saving_initial_amt";
    public static final int SAVINGS_INITIAL_AMT_COL = 4;

    public static final String SAVINGS_DEPOSIT_FREQUENCY = "saving_deposit_frequency";
    public static final int SAVINGS_DEPOSIT_FREQUENCY_COL = 5;

    public static final String SAVINGS_DEPOSIT_AMT = "saving_deposit_amt";
    public static final int SAVINGS_DEPOSIT_AMT_COL = 6;

    public static final String SAVINGS_DURATION_MONTHS = "savings_duration_months";
    public static final int SAVINGS_DURATION_MONTHS_COL = 7;

    public static final String SAVINGS_INTEREST = "savings_interest";
    public static final int SAVINGS_INTEREST_COL = 8;

    public static final String SAVINGS_TOTAL_CONTRIBUTIONS = "savings_total_contributions";
    public static final int SAVINGS_TOTAL_CONTRIBUTIONS_COL = 9;

    public static final String SAVINGS_TOTAL_INTEREST = "savings_total_interest";
    public static final int SAVINGS_TOTAL_INTEREST_COL = 10;

    public static final String SAVINGS_TOTAL_AMT = "savings_total_amt";
    public static final int SAVINGS_TOTAL_AMT_COL = 11;

    //create & drop table statements
    public static final String CREATE_SAVINGS_TABLE =
            "CREATE TABLE " + SAVINGS_TABLE + "( " +
                    SAVINGS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SAVINGS_LIST_ID + " INTEGER NOT NULL, " +
                    SAVINGS_TITLE + " TEXT NOT NULL, " +
                    SAVINGS_DESCRIPTION + " TEXT, " +
                    SAVINGS_INITIAL_AMT + " INTEGER NOT NULL, " +
                    SAVINGS_DEPOSIT_FREQUENCY + " TEXT NOT NULL, " +
                    SAVINGS_DEPOSIT_AMT + " INTEGER NOT NULL, " +
                    SAVINGS_DURATION_MONTHS + " TEXT NOT NULL, " +
                    SAVINGS_INTEREST + " INTEGER NOT NULL, " +
                    SAVINGS_TOTAL_CONTRIBUTIONS + " INTEGER NOT NULL, " +
                    SAVINGS_TOTAL_INTEREST + " INTEGER NOT NULL, " +
                    SAVINGS_TOTAL_AMT + " INTEGER NOT NULL);";

//END SAVINGS SQL

//    public static String DROP_LIST_TABLE = "DROP TABLE IF EXISTS " + LIST_TABLE;

    public static String DROP_LOAN_TABLE = "DROP TABLE IF EXISTS " + LOAN_TABLE;

    public static String DROP_SAVINGS_TABLE = "DROP TABLE IF EXISTS " + SAVINGS_TABLE;



    public static class DBHelper extends SQLiteOpenHelper{
        //Add constructor which will pass its SQLiteOpenHelper super class four arguments
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //If android does not find the database on the device the onCreate method is executed
        @Override
        public void onCreate(SQLiteDatabase db) {
            //create tables
//            db.execSQL(CREATE_LIST_TABLE);
            db.execSQL(CREATE_LOAN_TABLE);
            db.execSQL(CREATE_SAVINGS_TABLE);

            //insert default lists
            db.execSQL("INSERT INTO  loan VALUES (1, 1, 'car', 'for my future car', 10000, 5, 2.5, 'daily', 12, 25.12, 13535.23, 3535.23)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("Money DB", "Upgrading db from new version" + oldVersion + " to " + newVersion);
//            db.execSQL(LoansSavingsDB.DROP_LIST_TABLE);
            db.execSQL(LoansSavingsDB.DROP_LOAN_TABLE);
            db.execSQL(LoansSavingsDB.DROP_SAVINGS_TABLE);

            onCreate(db); //Create new db
        }
    }

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    //constructor
    public LoansSavingsDB(Context context){
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    //private methods to open & close the DB
    private void openReadableDB(){ db = dbHelper.getReadableDatabase();}
    private void openWritableDB(){ db = dbHelper.getWritableDatabase();}

    private void closeDB(){
        if(db != null){
            db.close();
        }
    }

    //Queries

    //Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit)

    /*
    table: The name of the table to query from.
    columns: An array of column names that you want to retrieve data from. Passing null here retrieves all columns.
    selection: The selection criteria for the rows. This is the WHERE clause in the SQL query. You can specify selection criteria to filter the rows returned. For example, "COLUMN_NAME = ?".
    selectionArgs: An array of values that will replace the ? placeholders in the selection parameter. Each ? will be replaced by the corresponding value in this array.
    groupBy: A string specifying how to group the rows, similar to the GROUP BY clause in SQL.
    having: A string specifying the criteria for which group of rows to include in the result set, similar to the HAVING clause in SQL.
    orderBy: A string specifying the order in which the rows should be sorted, similar to the ORDER BY clause in SQL.
    limit: A string specifying the maximum number of rows to return, similar to the LIMIT clause in SQL.
     */

    //Get list for loans
    public ArrayList<Loan> getLoans(){
        this.openReadableDB();
        String where = LOAN_LIST_ID + " = 1";
        Cursor cursor = db.query(LOAN_TABLE, null, where, null, null, null, null, null);
        ArrayList<Loan> loansList = new ArrayList<>();

        while(cursor.moveToNext()){
            loansList.add(getLoanFromCursor(cursor));
        }

        if(cursor != null){
            cursor.close();
        }

        this.closeDB();
        return loansList;
    }

    //Get list for savings
    public ArrayList<Savings> getSavings(){
        this.openReadableDB();
        String where = SAVINGS_LIST_ID + " = 2";
        Cursor cursor = db.query(SAVINGS_TABLE, null, where, null, null, null, null, null);
        ArrayList<Savings> savingsList = new ArrayList<>();

        while(cursor.moveToNext()){
            savingsList.add(getSavingsFromCursor(cursor));
        }

        if(cursor != null){
            cursor.close();
        }

        this.closeDB();
        return savingsList;
    }

    //Get loan from id.
    public Loan getLoan(int id){
        this.openReadableDB();
        String where =  LOAN_ID + " = ? ";
        String[] whereArgs = {String.valueOf(id)}; // id matches the id
        Cursor cursor = db.query(LOAN_TABLE, null, where, whereArgs, null, null, null, null);
        cursor.moveToFirst();
        Loan loan = null;

        //Check if the cursor has data before accessing it
        if(cursor.moveToFirst()){
            loan = getLoanFromCursor(cursor);
        }

        if(cursor != null){
            cursor.close();
        }

        this.closeDB();
        return loan;
    }

    private static Loan getLoanFromCursor(Cursor cursor){
        if(cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try{
                Loan loan = new Loan(
                        cursor.getInt(LOAN_ID_COL),
                        cursor.getInt(LOAN_LIST_ID_COL),
                        cursor.getString(LOAN_TITLE_COL),
                        cursor.getString(LOAN_DESCRIPTION_COL),
                        cursor.getDouble(LOAN_AMOUNT_COL),
                        cursor.getDouble(LOAN_TERM_YEARS_COL),
                        cursor.getDouble(LOAN_INTEREST_RATE_COL),
                        cursor.getString(LOAN_PAY_RATE_COL),
                        cursor.getDouble(LOAN_PAYMENTS_COL),
                        cursor.getDouble(LOAN_TOTAL_NUMBER_PAYMENTS_COL),
                        cursor.getDouble(LOAN_TOTAL_PAYBACK_COL),
                        cursor.getDouble(LOAN_TOTAL_INTEREST_COL)

                );
                return loan;
            } catch (Exception e){
                Log.e("Error from cursor", "MSG: " + e);
                return  null;
            }
        }
    }

    //Inserting loan
    public void insertLoan(Loan loan){

        ContentValues cv = new ContentValues();
        //Insert into loans table
        cv.put(LOAN_ID, loan.getLoanId());
        cv.put(LOAN_LIST_ID, 1); //sets the entry type also known as LOAN_LIST_ID or SAVINGS_LIST_ID
        cv.put(LOAN_TITLE, loan.getTitle());
        cv.put(LOAN_DESCRIPTION, loan.getDescription());
        cv.put(LOAN_AMOUNT, loan.getLoanAmount());
        cv.put(LOAN_TERM_YEARS, loan.getLoanTermInYears());
        cv.put(LOAN_INTEREST_RATE, loan.getInterestRate());
        cv.put(LOAN_PAY_RATE, loan.getPayRate());
        cv.put(LOAN_PAYMENT, loan.getPayments());
        cv.put(LOAN_TOTAL_NUMBER_PAYMENTS, loan.getNumberOfPayments());
        cv.put(LOAN_TOTAL_PAYBACK, loan.getTotalPayback());
        cv.put(LOAN_TOTAL_INTEREST, loan.getTotalInterest());

        this.openWritableDB();
        this.closeDB();
    }
    //End of Loan main queries


    //Savings main queries
    public Savings getSavings(int id){
        this.openReadableDB();
        String where = SAVINGS_ID + " = ?";
        String whereArgs[] = {String.valueOf(id)}; //title matches & entry type is correct
        Cursor cursor = db.query(SAVINGS_TABLE, null, where, whereArgs, null, null, null, null);
        cursor.moveToFirst();
        Savings savings = null;

        //Check if cursor has data before accessing it
        if(cursor.moveToFirst()){
            savings = getSavingsFromCursor(cursor);
        }

        if(cursor != null){
            cursor.close();
        }

        this.closeDB();
        return savings;
    }

    private static Savings getSavingsFromCursor(Cursor cursor){
        if(cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try{
                Savings savings = new Savings(
                        cursor.getInt(SAVINGS_ID_COL),
                        cursor.getInt(SAVINGS_LIST_ID_COL),
                        cursor.getString(SAVINGS_TITLE_COL),
                        cursor.getString(SAVINGS_DESCRIPTION_COL),
                        cursor.getDouble(SAVINGS_INITIAL_AMT_COL),
                        cursor.getString(SAVINGS_DEPOSIT_FREQUENCY_COL),
                        cursor.getDouble(SAVINGS_DEPOSIT_AMT_COL),
                        cursor.getDouble(SAVINGS_DURATION_MONTHS_COL),
                        cursor.getDouble(SAVINGS_INTEREST_COL),
                        cursor.getDouble(SAVINGS_TOTAL_CONTRIBUTIONS_COL),
                        cursor.getDouble(SAVINGS_TOTAL_INTEREST_COL),
                        cursor.getDouble(SAVINGS_TOTAL_AMT_COL)
                );
                return savings;
            } catch (Exception e){
                Log.e("Error from cursor", "MSG: " + e);
                return null;
            }
        }
    }

    public void insertSavingsAndList(Savings savings){

        ContentValues cv = new ContentValues();
        //Save into savings table
        cv.put(SAVINGS_ID, savings.getSavingsId());
        cv.put(SAVINGS_LIST_ID, savings.getListId());
        cv.put(SAVINGS_TITLE, savings.getTitle());
        cv.put(SAVINGS_DESCRIPTION, savings.getDescription());
        cv.put(SAVINGS_INITIAL_AMT, savings.getInitialAmount());
        cv.put(SAVINGS_DEPOSIT_FREQUENCY, savings.getDepositFrequency());
        cv.put(SAVINGS_DEPOSIT_AMT, savings.getDepositAmount());
        cv.put(SAVINGS_DURATION_MONTHS, savings.getDuration());
        cv.put(SAVINGS_INTEREST, savings.getInterest());
        cv.put(SAVINGS_TOTAL_CONTRIBUTIONS, savings.getTotalContributions());
        cv.put(SAVINGS_TOTAL_INTEREST, savings.getTotalInterest());
        cv.put(SAVINGS_TOTAL_AMT, savings.getTotalAmount());

        this.openWritableDB();
        this.closeDB();
    }


    //deletion of saved values
    public void deleteLoanRowByID(long id){
        this.openReadableDB();
        //Pick up here to delete

        this.openWritableDB();
        String where = LOAN_ID + " = ?";
        String[] whereArgs = {String.valueOf(id)};
        db.delete(LOAN_TABLE, where, whereArgs);
        this.closeDB();
    }

    public void deleteSavingsRowByID(long id){
        this.openWritableDB();
        String where = SAVINGS_ID + " = ?";
        String[] whereArgs = {String.valueOf(id)};
        db.delete(SAVINGS_TABLE, where, whereArgs);
        this.closeDB();
    }

}
