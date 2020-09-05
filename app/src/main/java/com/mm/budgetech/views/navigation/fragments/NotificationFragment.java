package com.mm.budgetech.views.navigation.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.hadiidbouk.charts.BarData;
import com.hadiidbouk.charts.ChartProgressBar;
import com.mm.budgetech.R;
import com.mm.budgetech.views.navigation.RecyclerViewAdapterRecordsStats;
import com.mm.budgetech.views.savings.RecyclerViewAdapterSavings;

import java.util.ArrayList;

import static com.mm.budgetech.static_constants.amount_saved;
import static com.mm.budgetech.static_constants.amount_total;
import static com.mm.budgetech.static_constants.amount_totalStats;
import static com.mm.budgetech.static_constants.amount_usedStats;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.item_name;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.name_stats;
import static com.mm.budgetech.static_constants.recyclerViewAdapterRecordsStats;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.timeleft;

public class NotificationFragment extends Fragment {

    PieChart pieChart;
    ChartProgressBar mChart;
    ArrayList<PieEntry> pieEntries;
    TextView nts;
    boolean check = false ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.notification_fragment, container, false);

       pieChart = root.findViewById(R.id.piechart);
       nts = root.findViewById(R.id.NTS_ME);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(getResources().getColor(R.color.appPrimaryColor));
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.setEntryLabelColor(getResources().getColor(R.color.appPrimaryColor));

        pieEntries  = new ArrayList<>();


        name_stats.clear();
        amount_usedStats.clear();
        amount_totalStats.clear();

        initRecyclerView(root);

        recyclerViewAdapterRecordsStats.notifyDataSetChanged();

        try {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds : dataSnapshot.child(appUserUID).child("Budgeting").getChildren()) {
                        String name = ds.getKey();
                        try {
                            pieEntries.add(new PieEntry(Float.parseFloat(dataSnapshot.child(appUserUID).child("Budgeting").child(name).getValue().toString()), name));

                        }
                        catch (Exception e)
                        {
                            System.out.println("Error: "+ e);
                        }

                    }

                    pieChart.setCenterText("Income: " + dataSnapshot.child(appUserUID).child("Income").getValue().toString()
                            + "\n" + "Remaining: " + dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                    PieDataSet pieDataSet = new PieDataSet(pieEntries, "Monthly Budget");
                    pieDataSet.setSliceSpace(3f);
                    pieDataSet.setSelectionShift(5f);
                    pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
                    PieData pieData = new PieData(pieDataSet);
                    pieData.setValueTextSize(10f);
                    pieData.setValueTextColor(getResources().getColor(R.color.appPrimaryColor));

                    pieChart.setData(pieData);


                    for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Record_Keeping_Totals").getChildren()) {
                        String name = ds.getKey();
                        if(dataSnapshot.child(appUserUID).child("Budgeting").hasChild(name))
                        {

                            name_stats.add(name);
                            amount_usedStats.add(dataSnapshot.child(appUserUID).child("Record_Keeping_Totals").child(name).child("Total_Amount").getValue().toString() + " PKR");
                            amount_totalStats.add(dataSnapshot.child(appUserUID).child("Budgeting").child(name).getValue().toString() + " PKR");
                            recyclerViewAdapterRecordsStats.notifyDataSetChanged();
                            check = true;
                        }


                    }

                if(check)
                {
                    nts.setVisibility(View.INVISIBLE);
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
      //  progressBar = findViewById(R.id.monthlyprogress_save);
        RecyclerView recyclerView = v.findViewById(R.id.statsRecycler);
        recyclerViewAdapterRecordsStats = new RecyclerViewAdapterRecordsStats(name_stats, amount_usedStats, amount_totalStats, getActivity().getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapterRecordsStats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
      //  progressBar.setVisibility(View.GONE);

    }
}
