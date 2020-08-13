package com.mm.budgetech.views.recordkeeping;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.monthlyBudget;

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

    ImageButton back;

    View view;

    monthlyBudget estimation;

    FloatingActionButton done;

    String ID;

    String ID_child;

    AppCompatEditText amount;
    AppCompatEditText description;

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

        back = findViewById(R.id.back_add_rec);

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
                if (view != null) {

                    reference.child(appUserUID).child("Record_Keeping").child(ID)
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    // get total available quest
                                    int size = (int) dataSnapshot.getChildrenCount();
                                    size = size + 1;
                                    System.out.println(size);
                                    ID_child = ID + size;
                                    String currentTime = java.text.DateFormat.getDateTimeInstance().format(new Date());
                                    System.out.println(currentTime);
                                    reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("amount").setValue(amount.getText().toString());
                                    reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("date").setValue(currentTime);
                                    if(!description.getText().toString().isEmpty())
                                    {
                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("description").setValue(description.getText().toString());
                                    }

                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                    view.setPressed(false);
                    view = null;
                    Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();


                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Select a Category First", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), record_keeping_frags.class);
                startActivity(i);
            }
        });
    }
}
