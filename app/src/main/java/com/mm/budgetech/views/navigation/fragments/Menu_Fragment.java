package com.mm.budgetech.views.navigation.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;
import com.mm.budgetech.views.budgeting.manageBudget;
import com.mm.budgetech.views.loans.loans;

import com.mm.budgetech.views.recordkeeping.add_record;
import com.mm.budgetech.views.recordkeeping.record_keeping_frags;
import com.mm.budgetech.views.savings.savings_main;
import com.mm.budgetech.views.wallet;

import static com.mm.budgetech.static_constants.amount_totalStats;
import static com.mm.budgetech.static_constants.amount_usedStats;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.name_stats;
import static com.mm.budgetech.static_constants.recyclerViewAdapterRecordsStats;
import static com.mm.budgetech.static_constants.reference;


public class Menu_Fragment extends Fragment {

    ImageButton record_diary;
    ImageButton monthly_budget;
    ImageButton savings;
    ImageButton loans;
    ImageButton wallet;
    TextView name;
    TextView currb;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.menu_fragment, container, false);
        monthly_budget = root.findViewById(R.id.monthly_budget_button);
        record_diary = root.findViewById(R.id.record_diary_button);
        savings = root.findViewById(R.id.savings_button);
        loans = root.findViewById(R.id.loans_button);
        wallet = root.findViewById(R.id.wallet_button);

        name = root.findViewById(R.id.name);
        currb = root.findViewById(R.id.current_balance_m);



        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.child(appUserUID).hasChild("Username"))
                {
                    name.setText("Welcome, " + dataSnapshot.child(appUserUID).child("Username").getValue());
                }
                if(dataSnapshot.child(appUserUID).hasChild("Remaining"))
                {
                    currb.setText("Current Balance: " + dataSnapshot.child(appUserUID).child("Remaining").getValue());
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });




        monthly_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), manageBudget.class );
                startActivity(i);
            }
        });

        record_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), record_keeping_frags.class );
                startActivity(i);
            }
        });

        savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), savings_main.class );
                startActivity(i);
            }
        });

    loans.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getActivity().getApplicationContext(), com.mm.budgetech.views.loans.loans.class );
            startActivity(i);
        }
    });

    wallet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getActivity().getApplicationContext(), com.mm.budgetech.views.wallet.class );
            startActivity(i);
        }
    });
        return root;





    }
}
