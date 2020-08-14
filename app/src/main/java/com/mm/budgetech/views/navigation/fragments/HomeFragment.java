package com.mm.budgetech.views.navigation.fragments;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.recordkeeping.RecyclerViewAdapterRecord;

import static com.mm.budgetech.static_constants.amount_record;
import static com.mm.budgetech.static_constants.amount_saved;
import static com.mm.budgetech.static_constants.amount_total;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.childName;
import static com.mm.budgetech.static_constants.date_record;
import static com.mm.budgetech.static_constants.des_record;
import static com.mm.budgetech.static_constants.insights_list;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.recyclerViewAdapterInsights;
import static com.mm.budgetech.static_constants.recyclerViewAdapterRecord;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.timeleft;

public class HomeFragment extends Fragment {
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    final  View root = inflater.inflate(R.layout.home_fragment, container, false);


        insights_list.clear();
        initRecyclerView(root);
        recyclerViewAdapterInsights.notifyDataSetChanged();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Savings").getChildren()){
                    String name = ds.getKey();
                    int monthlyDivision = Integer.parseInt(dataSnapshot.child(appUserUID).child("Savings").child(name).child("MonthlyDivision").getValue().toString());
                    System.out.println(monthlyDivision);
                    float income = Float.parseFloat(dataSnapshot.child(appUserUID).child("Income").getValue().toString());
                    float percent =  income * 0.1f;
                    System.out.println(percent);

                    if (monthlyDivision > percent )
                    {
                        System.out.println("hmmmmmmm");
                        // Spannable nameRed = new SpannableString(name);
                        //  nameRed.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        insights_list.add("It is suggested to increase the time frame of the Saving goal " + name.toUpperCase() +
                                " because your monthly budget, income, and spending activity does not allow you to save this much this month.");
                        System.out.println(insights_list.get(0));
                        recyclerViewAdapterInsights.notifyDataSetChanged();
                    }

                }


                for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Record_Keeping").getChildren()){
                    String name = ds.getKey();
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
        progressBar = v.findViewById(R.id.monthlyprogress_home);
        RecyclerView recyclerView = v.findViewById(R.id.home_recyclerView);
        recyclerViewAdapterInsights = new RecyclerViewAdapterInsights(insights_list, v.getContext());
        recyclerView.setAdapter(recyclerViewAdapterInsights);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        progressBar.setVisibility(View.GONE);

    }

}
