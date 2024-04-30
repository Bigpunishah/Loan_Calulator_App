package com.example.simplemoneycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SavingsSaveDialog extends Dialog implements View.OnClickListener {

    //Creating variables for dialog
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;
    private Button buttonCancel;

    private Savings saving;
    private LoansSavingsDB db;
    private Context context;


    public SavingsSaveDialog(Context context, LoansSavingsDB db, Savings saving) {
        super(context);
        this.db = db;
        this.context = context;
        this.saving = saving;
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
                saveSavings();
                dismiss();
                break;
            case R.id.button_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }

    private void saveSavings(){
        //Grabs the title & description from dialog then saves
        saving.setTitle(editTextTitle.getText().toString().trim());
        saving.setDescription(editTextDescription.getText().toString().trim());
        db.insertSavings(saving);
        Toast.makeText(context, "Your Savings has been saved!", Toast.LENGTH_SHORT).show();
        dismiss();
    }
}
