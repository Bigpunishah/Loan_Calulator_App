package com.example.simplemoneycalculator;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class LoanInfoDialog extends Dialog implements View.OnClickListener {

    public interface LoanInfoDialogListener {
        void onSaveClicked(String title, String description);
    }

    //Creating variables
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;
    private Button buttonCancel;
    private LoanInfoDialogListener mListener;

    public LoanInfoDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Set the dialog window size
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setContentView(R.layout.dialog_loan_info);

        //Assigning variables
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        buttonSave = findViewById(R.id.button_save);
        buttonCancel = findViewById(R.id.button_cancel);

        buttonSave.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_save:
                String title = editTextTitle.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();
                mListener.onSaveClicked(title, description);
                dismiss();
                break;
            case R.id.button_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }
}