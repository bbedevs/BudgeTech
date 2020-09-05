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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.monthlyBudget;
import com.mm.budgetech.views.navigation.bottom_navigation;

import java.util.Date;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.name_stats;
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

    String nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_loan);



        final ActionBar actionBar = getSupportActionBar();
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
                    ID =  estimation.amountAddFABaction_loan(v, name, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_loan(v, name, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_loan(v, name, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_loan(v, name, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_loan(v, name, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_loan(v, name, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!name.getText().toString().isEmpty() && !amount.getText().toString().isEmpty())
                {

                    try {

                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // get total available quest


                                if(view != null)
                                {

                                    if(loan_spinner.getSelectedItem().toString() == "Select Loan Type") {
                                        Toast.makeText(getApplicationContext(), "Select Loan Type", Toast.LENGTH_SHORT).show();
                                    }
                                    else if (loan_spinner.getSelectedItem().toString() == "Loan Amount To be Paid Back")
                                    {

                                        view.setPressed(false);
                                        view = null;

                                        int amountUser = Integer.parseInt(amount.getText().toString());
                                        int amountCurrentBalance = Integer.parseInt(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                                        int amountNew = amountUser + amountCurrentBalance;

                                        int size = (int) dataSnapshot.child(appUserUID).child("Loans").child("LoansToPaid").getChildrenCount();
                                        size = size + 1;
                                        nameString = name.getText().toString() + "_" + size;


                                        int totalLoan = Integer.parseInt(dataSnapshot.child(appUserUID).child("Loans_Paid_Total").getValue().toString());
                                        totalLoan = totalLoan + amountUser;
                                        reference.child(appUserUID).child("Loans_Paid_Total").setValue(totalLoan);

                                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(nameString).child("Category").setValue(ID);
                                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(nameString).child("Amount").setValue(amount.getText().toString());

                                        DialogueBoxLoans dialogueBoxLoans = new DialogueBoxLoans(add_new_loan.this, nameString, loan_spinner.getSelectedItem().toString(), amountNew);
                                        dialogueBoxLoans.setCancelable(false);
                                        dialogueBoxLoans.show();
                                    }
                                    else if (loan_spinner.getSelectedItem().toString() == "Loan Amount to be Received")
                                    {
                                        int size = (int) dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildrenCount();
                                        size = size + 1;
                                        nameString = name.getText().toString() +"_"+ size;

                                        int amountUser = Integer.parseInt(amount.getText().toString());
                                        int amountCurrentBalance = Integer.parseInt(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                                        int amountNew = amountCurrentBalance - amountUser;

                                        view.setPressed(false);
                                        view = null;

                                        int totalLoan = Integer.parseInt(dataSnapshot.child(appUserUID).child("Loans_Received_Total").getValue().toString());
                                        totalLoan = totalLoan + amountUser;
                                        reference.child(appUserUID).child("Loans_Received_Total").setValue(totalLoan);

                                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(nameString).child("Category").setValue(ID);
                                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(nameString).child("Amount").setValue(amount.getText().toString());
                                        DialogueBoxLoans dialogueBoxLoans = new DialogueBoxLoans(add_new_loan.this, nameString, loan_spinner.getSelectedItem().toString(), amountNew);
                                        dialogueBoxLoans.setCancelable(false);
                                        dialogueBoxLoans.show();
                                    }


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

                                        int amountUser = Integer.parseInt(amount.getText().toString());
                                        int amountCurrentBalance = Integer.parseInt(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                                        int amountNew = amountUser + amountCurrentBalance;

                                        int size = (int) dataSnapshot.child(appUserUID).child("Loans").child("LoansToPaid").getChildrenCount();
                                        size = size + 1;
                                        String nameString = name.getText().toString() + "_" + size;

                                        int totalLoan = Integer.parseInt(dataSnapshot.child(appUserUID).child("Loans_Paid_Total").getValue().toString());
                                        totalLoan = totalLoan + amountUser;
                                        reference.child(appUserUID).child("Loans_Paid_Total").setValue(totalLoan);

                                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(nameString).child("Category").setValue("Custom");
                                        reference.child(appUserUID).child("Loans").child("LoansToPaid").child(nameString).child("Amount").setValue(amount.getText().toString());
                                        DialogueBoxLoans dialogueBoxLoans = new DialogueBoxLoans(add_new_loan.this, nameString, loan_spinner.getSelectedItem().toString(), amountNew);
                                        dialogueBoxLoans.setCancelable(false);
                                        dialogueBoxLoans.show();


                                    }
                                    else if (loan_spinner.getSelectedItem().toString() == "Loan Amount to be Received")
                                    {
                                        //  view.setPressed(false);
                                        //view = null;
                                        int size = (int) dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildrenCount();
                                        size = size + 1;
                                        nameString = name.getText().toString() +"_"+ size;

                                        int amountUser = Integer.parseInt(amount.getText().toString());
                                        int amountCurrentBalance = Integer.parseInt(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                                        int amountNew = amountCurrentBalance - amountUser;

                                        int totalLoan = Integer.parseInt(dataSnapshot.child(appUserUID).child("Loans_Received_Total").getValue().toString());
                                        totalLoan = totalLoan + amountUser;
                                        reference.child(appUserUID).child("Loans_Received_Total").setValue(totalLoan);

                                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(nameString).child("Category").setValue("Custom");
                                        reference.child(appUserUID).child("Loans").child("LoansToReceive").child(nameString).child("Amount").setValue(amount.getText().toString());
                                        DialogueBoxLoans dialogueBoxLoans = new DialogueBoxLoans(add_new_loan.this, nameString, loan_spinner.getSelectedItem().toString(), amountNew);
                                        dialogueBoxLoans.setCancelable(false);
                                        dialogueBoxLoans.show();
                                    }


                                }


                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                    }
                    catch (Exception e)
                    {

                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Enter All Fields", Toast.LENGTH_SHORT).show();
                }



            }
        });



    }
    @Override
     public void onBackPressed()
    {

        this.finish();
    }

    public void estimateDone(View v)
    {
        Intent i = new Intent(getApplicationContext(), loans.class);
        startActivity(i);
        this.finish();
    }



}