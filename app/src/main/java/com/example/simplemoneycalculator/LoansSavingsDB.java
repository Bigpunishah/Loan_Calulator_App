package com.example.simplemoneycalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class LoansSavingsDB {

    //Database contents
    public static final String DB_NAME = "loansaving.db";
    public static final int DB_VERSION = 1;

    //List table for loan
    public static final String LIST_TABLE = "list";

    public static final String LIST_ID = "id";
    public static final int LIST_ID_COL = 0;

    public static final String LIST_TITLE = "list_title";
    public static final int LIST_TITLE_COL = 1;

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

    public static final String LOAN_TERM_MONTHS = "loan_term_months";
    public static final int LOAN_TERM_MONTHS_COL = 5;

    public static final String LOAN_INTEREST_RATE = "loan_interest_rate";
    public static final int LOAN_INTEREST_RATE_COL = 6;

    public static final String LOAN_PAY_RATE = "pay_rate";
    public static final int LOAN_PAY_RATE_COL = 7;

    public static final String LOAN_PAYMENT = "loan_payments";
    public static final int LOAN_PAYMENTS_COL = 8;

    public static final String LOAN_TOTAL_PAYBACK = "loan_total_payback";
    public static final int LOAN_TOTAL_PAYBACK_COL = 9;

    public static final String LOAN_TOTAL_INTEREST = "loan_total_interest";
    public static final int LOAN_TOTAL_INTEREST_COL = 10;

    public static final String CREATE_LIST_TABLE =
            "CREATE TABLE " + LIST_TABLE + " (" + LIST_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LIST_TITLE
                    + " TEXT NOT NULL UNIQUE);";

    public static final String CREATE_LOAN_TABLE =
            "CREATE TABLE " + LOAN_TABLE + " (" +
                    LOAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LOAN_LIST_ID + " INTEGER NOT NULL, " +
                    LOAN_TITLE + " TEXT NOT NULL, " +
                    LOAN_DESCRIPTION + "TEXT, " +
                    LOAN_AMOUNT + " INTEGER NOT NULL, " +
                    LOAN_TERM_MONTHS + " INTEGER NOT NULL, " +
                    LOAN_INTEREST_RATE + " INTEGER NOT NULL, " +
                    LOAN_PAY_RATE + " TEXT NOT NULL, " +
                    LOAN_PAYMENT + " INTEGER NOT NULL, " +
                    LOAN_TOTAL_PAYBACK + " INTEGER NOT NULL, " +
                    LOAN_TOTAL_INTEREST + " INTEGER NOT NULL);";

    public static String DROP_LIST_TABLE = "DROP TABLE IF EXISTS " + LIST_TABLE;

    public static String DROP_LOAN_TABLE = "DROP TABLE IF EXISTS " + LOAN_TABLE;

    public static class DBHelper extends SQLiteOpenHelper{
        //Add constructor which will pass its SQLiteOpenHelper super class four arguments
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //If android does not find the database on the device the onCreate method is executed
        @Override
        public void onCreate(SQLiteDatabase db) {
            //create tables
            db.execSQL(CREATE_LIST_TABLE);
            db.execSQL(CREATE_LOAN_TABLE);

            //insert default lists
            db.execSQL("INSERT INTO list VALUES (1, 'Loans')");
            db.execSQL("INSERT INTO list VALUES (2, 'Savings');");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("Money DB", "Upgrading db from new version" + oldVersion + " to " + newVersion);
            db.execSQL(LoansSavingsDB.DROP_LIST_TABLE);
            db.execSQL(LoansSavingsDB.DROP_LOAN_TABLE);

            onCreate(db); //Create new db
        }
    }

}
