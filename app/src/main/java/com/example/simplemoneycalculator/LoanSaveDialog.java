package com.example.simplemoneycalculator;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoanSaveDialog extends Dialog implements View.OnClickListener {

    //Creating variables for dialog
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;
    private Button buttonCancel;

    private Loan loan;
    private LoansSavingsDB db;
    private Context context;


    public LoanSaveDialog(Context context, LoansSavingsDB db, Loan loan) {
        super(context);
        this.db = db;
        this.context = context;
        this.loan = loan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Set the dialog window size
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setContentView(R.layout.dialog_save_info);

        //Assigning variables for dialog
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        buttonSave = findViewById(R.id.button_save);
        buttonCancel = findViewById(R.id.button_cancel);



        //on click listener for buttons
        buttonSave.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_save:
                saveLoan();

                dismiss();
                break;
            case R.id.button_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }

    private void saveLoan(){
        //Grabs the title & description from dialog then saves
        loan.setTitle(editTextTitle.getText().toString().trim());
        loan.setDescription(editTextDescription.getText().toString().trim());
        db.insertLoan(loan);
        Toast.makeText(context, "Your Loan has been saved!", Toast.LENGTH_SHORT).show();
        dismiss();
    }
}
