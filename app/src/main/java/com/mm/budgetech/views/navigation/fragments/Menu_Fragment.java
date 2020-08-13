package com.mm.budgetech.views.navigation.fragments;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mm.budgetech.R;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;
import com.mm.budgetech.views.budgeting.manageBudget;
import com.mm.budgetech.views.loans.loans;

import com.mm.budgetech.views.recordkeeping.add_record;
import com.mm.budgetech.views.recordkeeping.record_keeping_frags;
import com.mm.budgetech.views.savings.savings_main;
import com.mm.budgetech.views.wallet;


public class Menu_Fragment extends Fragment {

    ImageButton record_diary;
    ImageButton monthly_budget;
    ImageButton savings;
    ImageButton loans;
    ImageButton wallet;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.menu_fragment, container, false);
        monthly_budget = root.findViewById(R.id.monthly_budget_button);
        record_diary = root.findViewById(R.id.record_diary_button);
        savings = root.findViewById(R.id.savings_button);
        loans = root.findViewById(R.id.loans_button);

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
