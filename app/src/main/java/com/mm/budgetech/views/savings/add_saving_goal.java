package com.mm.budgetech.views.savings;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

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
import com.mm.budgetech.views.navigation.bottom_navigation;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static com.mm.budgetech.static_constants.amount_record;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.childName;
import static com.mm.budgetech.static_constants.date_record;
import static com.mm.budgetech.static_constants.des_record;
import static com.mm.budgetech.static_constants.parentName;
import static com.mm.budgetech.static_constants.recyclerViewAdapterRecord;
import static com.mm.budgetech.static_constants.reference;

public class add_saving_goal extends AppCompatActivity {


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

    String ID_child;

    AppCompatEditText amount;
    AppCompatEditText description;

    View view;

    String ID;
    TextView back;
    String currentTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_saving_goal);
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);




        back = findViewById(R.id.back_add_sav);

        foodFAB = findViewById(R.id.food_sav);
        housingFAB = findViewById(R.id.housing_sav);
        transportFAB = findViewById(R.id.transport_sav);
        billFAB = findViewById(R.id.billutil_sav);
        insuranceFAB = findViewById(R.id.insurance_sav);
        healthFAB = findViewById(R.id.health_sav);
        funFAB = findViewById(R.id.entertainment_sav);
        savingsFAB = findViewById(R.id.savings_sav);
        investingFAB = findViewById(R.id.investing_sav);

        save = findViewById(R.id.next_sav);

        estimation = new monthlyBudget();

        amount = findViewById(R.id.add_sav_amount);
        description = findViewById(R.id.add_sav_description);

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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    ID =  estimation.amountAddFABaction_save(v, amount, getApplicationContext());
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
                    try {
                        reference.child(appUserUID)
                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        // get total available quest
                                        int size = (int) dataSnapshot.getChildrenCount();
                                        size = size + 1;
                                        System.out.println(size);
                                        ID_child = ID + size;
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.add(Calendar.MONTH, Integer.parseInt(description.getText().toString()));
                                        currentTime = java.text.DateFormat.getDateTimeInstance().format(calendar.getTime());
                                        if(!description.getText().toString().isEmpty() && !amount.getText().toString().isEmpty())
                                        {
                                            int months = Integer.parseInt(description.getText().toString());
                                            int goalAmount = Integer.parseInt(amount.getText().toString());
                                            int monthlyDivision = goalAmount/months;
                                            float income = Float.parseFloat(dataSnapshot.child("Income").getValue().toString());
                                            float percent =  income * 0.1f;
                                            System.out.println(percent);

                                            if (monthlyDivision <= percent )
                                            {
                                                reference.child(appUserUID).child("Savings").child(ID).child("AmountTotal").setValue(amount.getText().toString());
                                                reference.child(appUserUID).child("Savings").child(ID).child("TimeLeft").setValue(currentTime);
                                                reference.child(appUserUID).child("Savings").child(ID).child("AmountSaved").setValue(0);
                                                reference.child(appUserUID).child("Savings").child(ID).child("MonthlyDivision").setValue(amount.getText().toString());
                                                Toast.makeText(getApplicationContext(),"Saving Goal Added",
                                                        Toast.LENGTH_LONG).show();
                                                Intent i = new Intent(getApplicationContext(), savings_main.class);
                                                startActivity(i);
                                                finish();

                                            }
                                            else
                                            {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(add_saving_goal.this);
                                                builder.setMessage("This goal seems unrealistic (Refer to insights for details), would you still like to add it?").setTitle("Warning")
                                                        .setCancelable(false) .setNegativeButton("Yes",
                                                        new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                dialog.dismiss();
                                                                reference.child(appUserUID).child("Savings").child(ID).child("AmountTotal").setValue(amount.getText().toString());
                                                                reference.child(appUserUID).child("Savings").child(ID).child("TimeLeft").setValue(currentTime);
                                                                reference.child(appUserUID).child("Savings").child(ID).child("AmountSaved").setValue(0);
                                                                reference.child(appUserUID).child("Savings").child(ID).child("MonthlyDivision").setValue(amount.getText().toString());
                                                                Intent i = new Intent(getApplicationContext(), savings_main.class);
                                                                startActivity(i);
                                                                finish();

                                                                Toast.makeText(getApplicationContext(), "Saving Goal Added", Toast.LENGTH_LONG).show();

                                                                //String parentName = item_names.get(position).replaceAll("[^A-Za-z]","");


                                                            }
                                                        })
                                                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                dialog.cancel();
                                                                Toast.makeText(getApplicationContext(),"Saving Goal Not Added",
                                                                        Toast.LENGTH_LONG).show();
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


//                                        reference.child(appUserUID).child("Savings").child(ID).child("AmountTotal").setValue(amount.getText().toString());
//                                        reference.child(appUserUID).child("Savings").child(ID).child("TimeLeft").setValue(currentTime);
//                                        reference.child(appUserUID).child("Savings").child(ID).child("AmountSaved").setValue(0);



                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(), "Enter Fields", Toast.LENGTH_SHORT).show();

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


                    view.setPressed(false);
                    view = null;

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
                Intent i = new Intent(getApplicationContext(), savings_main.class);
                startActivity(i);
             }
        });


    }

    @Override
    public void onBackPressed()
    {

        finish();
    }


}