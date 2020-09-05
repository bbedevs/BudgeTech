package com.mm.budgetech.views.budgeting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.monthlyBudget;
import com.mm.budgetech.views.navigation.bottom_navigation;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class estimated_monthly_expense extends AppCompatActivity {

    FloatingActionButton foodFAB;
    FloatingActionButton housingFAB;
    FloatingActionButton transportFAB;
    FloatingActionButton billFAB;
    FloatingActionButton insuranceFAB;
    FloatingActionButton healthFAB;
    FloatingActionButton funFAB;
    FloatingActionButton savingsFAB;
    FloatingActionButton investingFAB;

    FloatingActionButton save;

    monthlyBudget estimation;

    AppCompatEditText amount;

    View view;

    String ID;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimated_monthly_expense);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.hide();


        foodFAB = findViewById(R.id.food);
        housingFAB = findViewById(R.id.housing);
        transportFAB = findViewById(R.id.transport);
        billFAB = findViewById(R.id.billutil);
        insuranceFAB = findViewById(R.id.insurance);
        healthFAB = findViewById(R.id.health);
        funFAB = findViewById(R.id.entertainment);
        savingsFAB = findViewById(R.id.savings);
        investingFAB = findViewById(R.id.investing);

        save = findViewById(R.id.next_estimate);

        estimation = new monthlyBudget();

        amount = findViewById(R.id.amount);



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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        funFAB.setOnTouchListener(new View.OnTouchListener() {
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        savingsFAB.setOnTouchListener(new View.OnTouchListener() {
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        investingFAB.setOnTouchListener(new View.OnTouchListener() {
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
                    ID =  estimation.amountAddFABaction(v, amount, getApplicationContext());
                    view = v;
                }
                return  true;
            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amountStr = amount.getText().toString();
                System.out.println(amountStr + "hiiiii");
            if(view != null  && !amountStr.isEmpty())
            {
                view.setPressed(false);
                view = null;
                System.out.println(amount.getText().toString());
                reference.child(appUserUID).child("Budgeting").child(ID).setValue(amount.getText().toString());
                Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Select a category and add an amount", Toast.LENGTH_SHORT).show();
            }

            }
        });


    }

    public void estimateDone(View v)
    {
        Intent i = new Intent(estimated_monthly_expense.this, bottom_navigation.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        this.finish();
    }
}
