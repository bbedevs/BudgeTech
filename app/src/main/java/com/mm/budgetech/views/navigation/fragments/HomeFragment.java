package com.mm.budgetech.views.navigation.fragments;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    TextView nts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


    final  View root = inflater.inflate(R.layout.home_fragment, container, false);
    nts = root.findViewById(R.id.NTS);
    progressBar = root.findViewById(R.id.monthlyprogress_home);


        insights_list.clear();
        initRecyclerView(root);
        recyclerViewAdapterInsights.notifyDataSetChanged();


        try {
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


                    for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Record_Keeping_Totals").getChildren()){
                        String name = ds.getKey();

                        if(dataSnapshot.child(appUserUID).child("Budgeting").hasChild(name))
                        {
                            int totalAmountSpent = Integer.parseInt(dataSnapshot.child(appUserUID).child("Record_Keeping_Totals")
                                    .child(name).child("Total_Amount").getValue().toString());
                            int totalMonthlyCut = Integer.parseInt(dataSnapshot.child(appUserUID).child("Budgeting").child(name).getValue().toString());
                            float percent =  totalMonthlyCut*0.75f;
                            System.out.println("Record Percent" + percent);

                            if(totalAmountSpent >= totalMonthlyCut)
                            {
                                insights_list.add("You have already spent 100% from the allotted amount to the " + name.toUpperCase() + " category.");
                                recyclerViewAdapterInsights.notifyDataSetChanged();

                            }
                            else if (totalAmountSpent >= percent)
                            {
                                insights_list.add("You have already spent 75% from the allotted amount to the " + name.toUpperCase() + " category.");
                                recyclerViewAdapterInsights.notifyDataSetChanged();

                            }

                        }

                    }

                    int remainingAmount = Integer.parseInt(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                    if (remainingAmount < 0)
                    {
                        insights_list.add("Your remaining balance is below 0, please update your balance from settings or slow down your spending activities");
                    }

                    if(insights_list.isEmpty())
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        nts.setVisibility(View.VISIBLE);

                    }
                    else {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
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



        return root;


    }

    private void initRecyclerView(View v)
    {

        RecyclerView recyclerView = v.findViewById(R.id.home_recyclerView);
        recyclerViewAdapterInsights = new RecyclerViewAdapterInsights(insights_list, v.getContext());
        recyclerView.setAdapter(recyclerViewAdapterInsights);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

    }

}
