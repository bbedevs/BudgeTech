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
import com.mm.budgetech.views.recordkeeping.add_record;


public class Menu_Fragment extends Fragment {

    ImageButton record_diary;
    ImageButton monthly_budget;
    ImageButton savings;
    ImageButton loans;
    ImageButton insights;
    ImageButton wallet;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.menu_fragment, container, false);
        monthly_budget = root.findViewById(R.id.monthly_budget_button);
        record_diary = root.findViewById(R.id.record_diary_button);

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
                Intent i = new Intent(getActivity().getApplicationContext(), add_record.class );
                startActivity(i);
            }
        });

        return root;





    }
}