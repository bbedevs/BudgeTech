package com.mm.budgetech.views.loans.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.add_new_loan;
import com.mm.budgetech.views.navigation.bottom_navigation;

import static com.mm.budgetech.static_constants.amount_loans_paid;
import static com.mm.budgetech.static_constants.amount_loans_rec;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.date_loans_paid;
import static com.mm.budgetech.static_constants.date_loans_rec;
import static com.mm.budgetech.static_constants.name_loans_paid;
import static com.mm.budgetech.static_constants.name_loans_rec;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansPaid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansRec;
import static com.mm.budgetech.static_constants.reference;

public class received_Fragment extends Fragment {


    ProgressBar progressBar;
    Button addnew;
    TextView done;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root =  inflater.inflate(R.layout.fragment_received, container, false);

        addnew = root.findViewById(R.id.add_new_loan_rec);
        done = root.findViewById(R.id.done_rec);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                name_loans_rec.clear();
                amount_loans_rec.clear();
                date_loans_rec.clear();
                initRecyclerView(root);
                recyclerViewAdapterLoansRec.notifyDataSetChanged();
                long value = dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildrenCount();
                for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildren()) {
                    String name = ds.getKey();
                    name_loans_rec.add("To Be Received From "+ name);
                    amount_loans_rec.add(dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(name).child("Amount").getValue().toString() + " PKR");
                    date_loans_rec.add("Reminder is set to "+ dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(name).child("Date").getValue().toString());
                }

                //   recyclerViewAdapterSavings.notifyDataSetChanged();
                System.out.println(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), add_new_loan.class);
                startActivity(i);
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), bottom_navigation.class);
                startActivity(i);
            }
        });

        return root;

    }

    private void initRecyclerView(View v)
    {
        progressBar = v.findViewById(R.id.monthlyprogress_fragrec);
        RecyclerView recyclerView = v.findViewById(R.id.show_data_rec);
        recyclerViewAdapterLoansRec = new RecyclerViewAdapterLoansRec(name_loans_rec, amount_loans_rec, date_loans_rec, v.getContext());
        recyclerView.setAdapter(recyclerViewAdapterLoansRec);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        progressBar.setVisibility(View.GONE);

    }
}