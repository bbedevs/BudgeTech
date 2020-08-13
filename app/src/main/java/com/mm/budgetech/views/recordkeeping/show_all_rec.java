package com.mm.budgetech.views.recordkeeping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.fragments.RecyclerViewAdapterLoansRec;

import static com.mm.budgetech.static_constants.amount_loans_rec;
import static com.mm.budgetech.static_constants.amount_record;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.date_loans_rec;
import static com.mm.budgetech.static_constants.date_record;
import static com.mm.budgetech.static_constants.des_record;
import static com.mm.budgetech.static_constants.name_loans_rec;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansRec;
import static com.mm.budgetech.static_constants.recyclerViewAdapterRecord;
import static com.mm.budgetech.static_constants.reference;

public class show_all_rec extends Fragment {

    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      final   View root = inflater.inflate(R.layout.fragment_show_all_rec, container, false);


        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                des_record.clear();
                amount_record.clear();
                date_record.clear();
                initRecyclerView(root);
                recyclerViewAdapterRecord.notifyDataSetChanged();
                //long value = dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").getChildrenCount();
                for(DataSnapshot dataSnapshot1: dataSnapshot.child(appUserUID).child("Record_Keeping").getChildren())
                {
                    for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Record_Keeping").child(dataSnapshot1.getKey()).getChildren()) {
                        String name = ds.getKey();
                        System.out.println(name);
                        des_record.add(dataSnapshot.child(appUserUID).child("Record_Keeping").child(dataSnapshot1.getKey()).child(name).child("description").getValue().toString());
                        amount_record.add(dataSnapshot.child(appUserUID).child("Record_Keeping").child(dataSnapshot1.getKey()).child(name).child("amount").getValue().toString() + " PKR");
                        date_record.add(dataSnapshot.child(appUserUID).child("Record_Keeping").child(dataSnapshot1.getKey()).child(name).child("date").getValue().toString());
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        return root;
    }

    private void initRecyclerView(View v)
    {
        progressBar = v.findViewById(R.id.monthlyprogress_allfragrec);
        RecyclerView recyclerView = v.findViewById(R.id.show_data_all_rec);
        recyclerViewAdapterRecord = new RecyclerViewAdapterRecord(des_record, amount_record, date_record, v.getContext());
        recyclerView.setAdapter(recyclerViewAdapterRecord);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        progressBar.setVisibility(View.GONE);

    }
}