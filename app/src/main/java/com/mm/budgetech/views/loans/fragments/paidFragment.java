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
import android.widget.TextClock;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.add_new_loan;
import com.mm.budgetech.views.navigation.bottom_navigation;
import com.mm.budgetech.views.savings.RecyclerViewAdapterSavings;

import static com.mm.budgetech.static_constants.amount_loans_paid;
import static com.mm.budgetech.static_constants.amount_saved;
import static com.mm.budgetech.static_constants.amount_total;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.date_loans_paid;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.name_loans_paid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansPaid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.timeleft;


public class paidFragment extends Fragment {


ProgressBar progressBar;
Button addnew;
TextView done;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root =  inflater.inflate(R.layout.fragment_paid, container, false);

        addnew = root.findViewById(R.id.add_new_loan_paid);
        done = root.findViewById(R.id.done_paid);



        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                name_loans_paid.clear();
                amount_loans_paid.clear();
                date_loans_paid.clear();
                initRecyclerView(root);
                recyclerViewAdapterLoansPaid.notifyDataSetChanged();
//                long value = dataSnapshot.child(appUserUID).child("Loans").child("LoansToPaid").getChildrenCount();
                for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Loans").child("LoansToPaid").getChildren()) {
                    String name = ds.getKey();
                    name_loans_paid.add("To Be Paid To "+ name);
                    amount_loans_paid.add(dataSnapshot.child(appUserUID).child("Loans").child("LoansToPaid").child(name).child("Amount").getValue().toString() + " PKR");
                    date_loans_paid.add("Reminder is set to "+ dataSnapshot.child(appUserUID).child("Loans").child("LoansToPaid").child(name).child("Date").getValue().toString());
                }

                //   recyclerViewAdapterSavings.notifyDataSetChanged();
            //     System.out.println(value);

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
       progressBar = v.findViewById(R.id.monthlyprogress_fragpaid);
        RecyclerView recyclerView = v.findViewById(R.id.show_data_paid);
        recyclerViewAdapterLoansPaid = new RecyclerViewAdapterLoansPaid(name_loans_paid, amount_loans_paid, date_loans_paid, v.getContext());
        recyclerView.setAdapter(recyclerViewAdapterLoansPaid);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        progressBar.setVisibility(View.GONE);

    }

}