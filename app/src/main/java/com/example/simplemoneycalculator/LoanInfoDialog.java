package com.example.simplemoneycalculator;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoanInfoDialog extends Dialog implements View.OnClickListener {

    public interface LoanInfoDialogListener {
        void onSaveClicked(String title, String description);
    }

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;
    private Button buttonCancel;
    private LoanInfoDialogListener mListener;

    public LoanInfoDialog(Context context, LoanInfoDialogListener listener) {
        super(context);
        this.mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

    }
}