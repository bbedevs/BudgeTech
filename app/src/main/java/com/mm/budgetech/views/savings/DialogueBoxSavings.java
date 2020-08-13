package com.mm.budgetech.views.savings;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;

import static com.mm.budgetech.static_constants.amount_saved;
import static com.mm.budgetech.static_constants.amount_total;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.recyclerViewAdapter;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.timeleft;

public class DialogueBoxSavings extends Dialog implements View.OnClickListener {

    public Dialog d;
    public FloatingActionButton done;
    AppCompatEditText amount_to_change;
    Context context;
    String name;
    String amount;
    int pos;
    int updatedAmount;
    RelativeLayout relativeLayout;



    public DialogueBoxSavings(@NonNull Context context, String amount, String name, int pos, RelativeLayout relativeLayout) {
        super(context);
        this.context = context;
        this.name = name;
        this.amount = amount;
        this.pos = pos;
        this.relativeLayout = relativeLayout;



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogue_box_savings);
        done = findViewById(R.id.done_amount_saved);
        amount_to_change = findViewById(R.id.amount_saved);
        done.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if (v.getId() == R.id.done_amount_saved)
            {


                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                            System.out.println();
                        if (!amount_to_change.getText().toString().equals(""))
                        {
                            System.out.println(amount_to_change.getText().toString());
                            amount = dataSnapshot.child(appUserUID).child("Savings").child(name).child("AmountSaved").getValue().toString();
                            String value = amount_to_change.getText().toString();
//                          int intValue = (int)Long.parseLong(amount_to_change.getText().toString());
                            int dbValue = (int)Long.parseLong(dataSnapshot.child(appUserUID).child("Savings").child(name).child("AmountTotal").getValue().toString());
                            updatedAmount = (int)Long.parseLong(amount) + (int)Long.parseLong(value);

                            if(updatedAmount <= dbValue)
                            {
                                reference.child(appUserUID).child("Savings").child(name).child("AmountSaved").setValue(Integer.toString(updatedAmount));
                                amount_saved.set(pos, updatedAmount + " PKR");
                                if (amount_saved.get(pos).equals(amount_total.get(pos)))
                                {
                                    System.out.println(amount_total.get(pos));
                                    System.out.println(amount_saved.get(pos));
                                    relativeLayout.setBackgroundColor(Color.parseColor("#68FF91"));
                                }

                                recyclerViewAdapterSavings.notifyDataSetChanged();
                                System.out.println(amount_saved.get(pos));
                                dismiss();
                            }
                            else
                            {
                                Toast.makeText(context, "Enter a valid amount", Toast.LENGTH_SHORT).show();
                            }


                        }
                        else
                        {
                            Toast.makeText(context, "Enter an amount", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });




            }
    }


    }

