package com.mm.budgetech.views;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.loans;
import com.mm.budgetech.views.navigation.bottom_navigation;
import com.mm.budgetech.views.recordkeeping.record_keeping_frags;
import com.mm.budgetech.views.savings.savings_main;

import org.w3c.dom.Text;

import java.util.Objects;

import static com.mm.budgetech.static_constants.amount_saved;
import static com.mm.budgetech.static_constants.amount_total;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.timeleft;

public class wallet extends AppCompatActivity {

    TextView current_balance;
    TextView total_savings;
    TextView loans_paid;
    TextView loans_receive;

    TextView current_balance_button;
    TextView savings_button;
    TextView loans_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);

        current_balance = findViewById(R.id.current_balance);
        total_savings = findViewById(R.id.total_savings);
        loans_paid = findViewById(R.id.total_loans_paid);
        loans_receive = findViewById(R.id.total_loans_rec);


        current_balance_button = findViewById(R.id.manage_records_button);
        savings_button = findViewById(R.id.total_savings_button);
        loans_button = findViewById(R.id.total_loans_button);

        try {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    current_balance.setText(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString() + " PKR");
                    total_savings.setText(dataSnapshot.child(appUserUID).child("Savings_Total").getValue().toString() + " PKR");
                    loans_paid.setText(dataSnapshot.child(appUserUID).child("Loans_Paid_Total").getValue().toString() + " PKR");
                    loans_receive.setText(dataSnapshot.child(appUserUID).child("Loans_Received_Total").getValue().toString() + " PKR");

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });

        }
        catch (Exception e)
        {

        }


    }

    public void records_button_func(View v)
    {
        Intent i = new Intent(getApplicationContext(), record_keeping_frags.class );
        startActivity(i);
    }
    public void savings_button_func(View v)
    {
        Intent i = new Intent(getApplicationContext(), savings_main.class );
        startActivity(i);
    }
    public void loans_button_func(View v)
    {
        Intent i = new Intent(getApplicationContext(), loans.class );
        startActivity(i);
    }

    public void estimateDone(View v)
    {
        Intent i = new Intent(getApplicationContext(), bottom_navigation.class);
        startActivity(i);
    }

}