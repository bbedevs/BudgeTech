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
import static com.mm.budgetech.static_constants.item_name;
import static com.mm.budgetech.static_constants.name_loans_paid;
import static com.mm.budgetech.static_constants.name_loans_rec;
import static com.mm.budgetech.static_constants.nametemps_loans_rec;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansPaid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansRec;
import static com.mm.budgetech.static_constants.reference;

public class received_Fragment extends Fragment {


    ProgressBar progressBar;
    Button addnew;
    TextView done;
    TextView nts;
    TextView clr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root =  inflater.inflate(R.layout.fragment_received, container, false);

        addnew = root.findViewById(R.id.add_new_loan_rec);
        done = root.findViewById(R.id.done_rec);
        progressBar = root.findViewById(R.id.monthlyprogress_fragrec);
        nts = root.findViewById(R.id.NTS_LR);
        clr = root.findViewById(R.id.clr);

        try {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    if(dataSnapshot.child(appUserUID).hasChild("Loans_Received_Total"))
                    {
                        clr.setText("Total Amount to Receive: " + dataSnapshot.child(appUserUID).child("Loans_Received_Total").getValue() + " PKR");
                    }
                    else
                    {
                        clr.setText("Total Amount to Pay: 0 PKR" );

                    }

                    name_loans_rec.clear();
                    amount_loans_rec.clear();
                    date_loans_rec.clear();
                    nametemps_loans_rec.clear();
                    initRecyclerView(root);
                    recyclerViewAdapterLoansRec.notifyDataSetChanged();
                    long value = dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildren()) {
                        String name = ds.getKey();
                        String[] nameSplit = name.split("_");
                        System.out.println(nameSplit[0]);
                        nametemps_loans_rec.add(name);
                        name_loans_rec.add("To Be Received From "+ nameSplit[0]);
                        amount_loans_rec.add(dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(name).child("Amount").getValue().toString() + " PKR");
                        if(dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(name).hasChild("Date"))
                        {
                            date_loans_rec.add("Reminder is set to "+ dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(name).child("Date").getValue().toString());

                        }
                        else
                        {
                            date_loans_rec.add("Reminder is not set");

                        }
                    }


                    if (name_loans_rec.isEmpty())
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        nts.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                    //   recyclerViewAdapterSavings.notifyDataSetChanged();
                    System.out.println(value);

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
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        return root;

    }

    private void initRecyclerView(View v)
    {

        RecyclerView recyclerView = v.findViewById(R.id.show_data_rec);
        recyclerViewAdapterLoansRec = new RecyclerViewAdapterLoansRec(name_loans_rec, nametemps_loans_rec ,amount_loans_rec, date_loans_rec, v.getContext());
        recyclerView.setAdapter(recyclerViewAdapterLoansRec);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        progressBar.setVisibility(View.GONE);

    }
}