package com.mm.budgetech.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;

import org.w3c.dom.Text;

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

        current_balance = findViewById(R.id.current_balance);
        total_savings = findViewById(R.id.total_savings);
        loans_paid = findViewById(R.id.total_loans_paid);
        loans_receive = findViewById(R.id.total_loans_rec);


        current_balance_button = findViewById(R.id.manage_records_button);
        savings_button = findViewById(R.id.total_savings_button);
        loans_button = findViewById(R.id.total_loans_button);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                current_balance.setText(dataSnapshot.child(appUserUID).child("Current_Balance").getValue().toString() + " PKR");
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

    public void records_button_func(View v)
    {

    }
}