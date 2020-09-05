package com.mm.budgetech.views.savings;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.navigation.bottom_navigation;

import java.util.Objects;

import static com.mm.budgetech.static_constants.amount_saved;
import static com.mm.budgetech.static_constants.amount_total;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.item_name;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.recyclerViewAdapter;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.timeleft;

public class savings_main extends AppCompatActivity {

    Button addnew;
    ProgressBar progressBar;
    TextView nts;
    TextView cs;
  //  TextView total_savings;
    //private RecyclerViewAdapterSavings recyclerViewAdapterSavings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_main);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);


        nts = findViewById(R.id.NTS_Saving);
        progressBar = findViewById(R.id.monthlyprogress_save);
        addnew = (Button) findViewById(R.id.Add_new_button);
        cs = findViewById(R.id.cs);
       // total_savings = findViewById(R.id.Amount_textview);

        fetchSavings();


        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), add_saving_goal.class);
                startActivity(i);
            }
        });

    }

    private void initRecyclerView()
    {

        RecyclerView recyclerView = findViewById(R.id.card_recyclerView);
        recyclerViewAdapterSavings = new RecyclerViewAdapterSavings(item_name_savings, timeleft, amount_saved, amount_total,this);
        recyclerView.setAdapter(recyclerViewAdapterSavings);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void fetchSavings()
    {
        try {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    if(dataSnapshot.child(appUserUID).hasChild("Savings_Total"))
                    {
                        cs.setText("Total Savings: " + dataSnapshot.child(appUserUID).child("Savings_Total").getValue() + " PKR");
                    }
                    else
                    {
                        cs.setText("Total Savings: 0 PKR" );

                    }
                    item_name_savings.clear();
                    amount_total.clear();
                    amount_saved.clear();
                    timeleft.clear();
                    initRecyclerView();
                    recyclerViewAdapterSavings.notifyDataSetChanged();
                    //  total_savings.setText(dataSnapshot.child(appUserUID).child("Savings_Total").getValue().toString());
                    // long value = dataSnapshot.child(appUserUID).child("Savings").getChildrenCount();
                    for (DataSnapshot ds : dataSnapshot.child(appUserUID).child("Savings").getChildren()) {
                        String name = ds.getKey();
                        item_name_savings.add(name);
                        amount_saved.add(dataSnapshot.child(appUserUID).child("Savings").child(name).child("AmountSaved").getValue().toString() + " PKR");
                        amount_total.add(dataSnapshot.child(appUserUID).child("Savings").child(name).child("AmountTotal").getValue().toString() + " PKR");
                        timeleft.add("Due: " + dataSnapshot.child(appUserUID).child("Savings").child(name).child("TimeLeft").getValue().toString());

                    }

                    if (item_name_savings.isEmpty())
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        nts.setVisibility(View.VISIBLE);
                    }
                    else
                    {
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


    }

    public void estimateDoneSavings(View v)
    {
        Intent i = new Intent(getApplicationContext(), bottom_navigation.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}

