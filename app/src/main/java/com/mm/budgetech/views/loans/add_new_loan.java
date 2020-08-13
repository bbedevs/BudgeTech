package com.mm.budgetech.views.loans;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.monthlyBudget;
import com.mm.budgetech.views.navigation.bottom_navigation;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class add_new_loan extends AppCompatActivity {

    FloatingActionButton foodFAB;
    FloatingActionButton housingFAB;
    FloatingActionButton transportFAB;
    FloatingActionButton billFAB;
    FloatingActionButton insuranceFAB;
    FloatingActionButton healthFAB;

    FloatingActionButton save;

    monthlyBudget estimation;

    AppCompatEditText amount;

    AppCompatEditText name;

    AppCompatSpinner loan_spinner;

    View view;

    String ID;

    ArrayAdapter<String> adapter;

    String[] loans = {"Select Loan Type", "Loan Amount To be Paid Back", "Loan Amount to be Received"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_loan);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.hide();


        foodFAB = findViewById(R.id.emergency_loan);
        housingFAB = findViewById(R.id.housing_loan);
        transportFAB = findViewById(R.id.transport_loan);
        billFAB = findViewById(R.id.billutil_loan);
        insuranceFAB = findViewById(R.id.insurance_loan);
        healthFAB = findViewById(R.id.health_loan);

        loan_spinner = findViewById(R.id.LoanInfo);


        save = findViewById(R.id.next_estimate_loan);

        estimation = new monthlyBudget();

        amount = findViewById(R.id.amount_loan);

        name = findViewById(R.id.name_loan);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, loans);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loan_spinner.setAdapter(adapter);


        foodFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    if (view != null)
                    {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID =  estimation.amountAddFABaction_loan(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        housingFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    if (view != null)
                    {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID =  estimation.amountAddFABaction_loan(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        transportFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    if (view != null)
                    {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID =  estimation.amountAddFABaction_loan(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        billFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    if (view != null)
                    {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID =  estimation.amountAddFABaction_loan(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        insuranceFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    if (view != null)
                    {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID =  estimation.amountAddFABaction_loan(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        healthFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    if (view != null)
                    {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID =  estimation.amountAddFABaction_loan(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view != null)
                {
                    if(loan_spinner.getSelectedItem().toString() == "Select Loan Type") {
                        Toast.makeText(getApplicationContext(), "Select Loan Type", Toast.LENGTH_SHORT).show();
                    }
                   else if (loan_spinner.getSelectedItem().toString() == "Loan Amount To be Paid Back")
                    {
                        view.setPressed(false);
                        view = null;
                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(name.getText().toString()).child("Category").setValue(ID);
                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(name.getText().toString()).child("Amount").setValue(amount.getText().toString());

                    }
                    else if (loan_spinner.getSelectedItem().toString() == "Loan Amount to be Received")
                    {
                        view.setPressed(false);
                        view = null;
                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(name.getText().toString()).child("Category").setValue(ID);
                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(name.getText().toString()).child("Amount").setValue(amount.getText().toString());

                    }

                    DialogueBoxLoans dialogueBoxLoans = new DialogueBoxLoans(add_new_loan.this, name.getText().toString(), loan_spinner.getSelectedItem().toString());
                    dialogueBoxLoans.show();
                }
                else
                {
                    if(loan_spinner.getSelectedItem().toString() == "Select Loan Type") {
                        Toast.makeText(getApplicationContext(), "Select Loan Type", Toast.LENGTH_SHORT).show();
                    }
                    else if (loan_spinner.getSelectedItem().toString() == "Loan Amount To be Paid Back")
                    {
                        //view.setPressed(false);
                       // view = null;
                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(name.getText().toString()).child("Category").setValue("Custom");
                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(name.getText().toString()).child("Amount").setValue(amount.getText().toString());

                    }
                    else if (loan_spinner.getSelectedItem().toString() == "Loan Amount to be Received")
                    {
                      //  view.setPressed(false);
                        //view = null;
                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(name.getText().toString()).child("Category").setValue("Custom");
                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(name.getText().toString()).child("Amount").setValue(amount.getText().toString());

                    }

                    DialogueBoxLoans dialogueBoxLoans = new DialogueBoxLoans(add_new_loan.this, name.getText().toString(), loan_spinner.getSelectedItem().toString());
                    dialogueBoxLoans.show();
                }

            }
        });



    }

    public void estimateDone(View v)
    {
        Intent i = new Intent(getApplicationContext(), loans.class);
        startActivity(i);
    }

}