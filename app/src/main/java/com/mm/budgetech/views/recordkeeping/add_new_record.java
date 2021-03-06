package com.mm.budgetech.views.recordkeeping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.monthlyBudget;
import com.mm.budgetech.views.loans.loans;

import java.util.Calendar;
import java.util.Date;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class add_new_record extends AppCompatActivity {


    FloatingActionButton foodFAB;
    FloatingActionButton housingFAB;
    FloatingActionButton transportFAB;
    FloatingActionButton billFAB;
    FloatingActionButton insuranceFAB;
    FloatingActionButton healthFAB;
    FloatingActionButton funFAB;
    FloatingActionButton savingsFAB;
    FloatingActionButton investingFAB;

    TextView back;

    View view;

    monthlyBudget estimation;

    FloatingActionButton done;

    String ID;

    String ID_child;

    AppCompatEditText amount;
    AppCompatEditText description;

    double balance;
    String currentTime;

    double current_Amount;
    double amountText;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_record);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.hide();



        foodFAB = findViewById(R.id.food_rec);
        housingFAB = findViewById(R.id.housing_rec);
        transportFAB = findViewById(R.id.transport_rec);
        billFAB = findViewById(R.id.billutil_rec);
        insuranceFAB = findViewById(R.id.insurance_rec);
        healthFAB = findViewById(R.id.health_rec);
        funFAB = findViewById(R.id.entertainment_rec);
        savingsFAB = findViewById(R.id.savings_rec);
        investingFAB = findViewById(R.id.investing_rec);

        back = findViewById(R.id.gobackrec);

        done = findViewById(R.id.next_rec);

        amount = findViewById(R.id.add_rec_amount);
        description = findViewById(R.id.add_rec_description);

        estimation = new monthlyBudget();


        foodFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        housingFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        transportFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        billFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        insuranceFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        healthFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        funFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        savingsFAB.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        investingFAB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (view != null) {
                        view.setPressed(false);
                    }
                    v.setPressed(true);
                    ID = estimation.amountAddFABaction_rec(v, amount, getApplicationContext());
                    view = v;
                }
                return true;
            }

        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view != null && !description.getText().toString().isEmpty() && !amount.getText().toString().isEmpty()) {


                    try {
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // get total available quest

                                size = (int) dataSnapshot.child(appUserUID).child("Record_Keeping").child(ID).getChildrenCount();
                                System.out.println(size);
                                size = size + 1;
                                System.out.println(ID);
                                System.out.println(size);
                                ID_child = ID + size;
                                amountText = Double.parseDouble(amount.getText().toString());

                                if (dataSnapshot.child(appUserUID).hasChild("Record_Keeping_Totals")) {

                                    if (dataSnapshot.child(appUserUID).child("Record_Keeping_Totals").hasChild(ID)) {
                                        current_Amount = Double.parseDouble(dataSnapshot.child(appUserUID).child("Record_Keeping_Totals").child(ID).
                                                child("Total_Amount").getValue().toString());
                                        current_Amount = current_Amount + amountText;
                                        reference.child(appUserUID).child("Record_Keeping_Totals").child(ID).child("Total_Amount").setValue(current_Amount);


                                    }
                                    else
                                    {
                                        reference.child(appUserUID).child("Record_Keeping_Totals").child(ID).child("Total_Amount").setValue(amountText);

                                    }

                                }
                                else
                                {
                                    reference.child(appUserUID).child("Record_Keeping_Totals").child(ID).child("Total_Amount").setValue(amountText);
                                }

                                currentTime = java.text.DateFormat.getDateTimeInstance().format(new Date());
                                System.out.println(currentTime);
                                balance = Double.parseDouble(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());

                                if (balance >= amountText)
                                {
                                    double updated_balance = balance - amountText;
                                    reference.child(appUserUID).child("Remaining").setValue(updated_balance);
                                    reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("amount").setValue(amount.getText().toString());
                                    reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("date").setValue(currentTime);
                                    if (!description.getText().toString().isEmpty())
                                    {
                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("description").setValue(description.getText().toString());
                                    }
                                    Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplicationContext(), record_keeping_frags.class);
                                    startActivity(i);
                                    finish();
                                }
                                else
                                {

                                    AlertDialog.Builder builder = new AlertDialog.Builder(add_new_record.this);
                                    builder.setMessage("Adding this record will render your current balance in a negative amount. Would you still " +
                                            "like to proceed?").setTitle("Add Record Warning")
                                            .setCancelable(false) .setNegativeButton("Yes",
                                            new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                    Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();
                                                    double updated_balance = balance - amountText;
                                                    reference.child(appUserUID).child("Remaining").setValue(updated_balance);
                                                    reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("amount").setValue(amount.getText().toString());
                                                    reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("date").setValue(currentTime);
                                                    if (!description.getText().toString().isEmpty())
                                                    {
                                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("description").setValue(description.getText().toString());
                                                    }
                                                    Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getApplicationContext(), record_keeping_frags.class);
                                                    startActivity(i);
                                                    finish();


                                                }
                                            })
                                            .setPositiveButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();
                                                    Toast.makeText(add_new_record.this,"Cancelled",
                                                            Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                    final AlertDialog alert = builder.create();
                                    alert.setOnShowListener( new DialogInterface.OnShowListener() {
                                        @Override
                                        public void onShow(DialogInterface arg0) {
                                            alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.appPrimaryColor));
                                            alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.appPrimaryColor));
                                        }
                                    });
                                    alert.show();

                                }

                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error: "+ e);
                    }


                    view.setPressed(false);
                    view = null;



                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Select a Category and Fill All Fields", Toast.LENGTH_SHORT).show();
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
        Intent i = new Intent(getApplicationContext(), record_keeping_frags.class);
        startActivity(i);
    }

}
