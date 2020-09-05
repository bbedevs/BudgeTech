package com.mm.budgetech.views.budgeting;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.services.RecyclerViewAdapter;
import com.mm.budgetech.views.navigation.bottom_navigation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.recyclerViewAdapter;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.item_name;

public class manageBudget extends AppCompatActivity {


    Button addnew;
    ProgressBar progressBar;
    TextView month;
    TextView nts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_budget);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);

        addnew = (Button)findViewById(R.id.add_new);

        month = findViewById(R.id.month);

        nts = findViewById(R.id.NTS_Budget);

        progressBar = findViewById(R.id.monthlyprogress);


        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String month1 = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

        DateFormat dateFormat2 = new SimpleDateFormat("YYYY");

        String monthYear = month1 + " " + dateFormat2.format(date);

        month.setText(monthYear);




        try
        {

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.

                    item_name.clear();
                    item_amount.clear();
                    initRecyclerView();
                    recyclerViewAdapter.notifyDataSetChanged();
                    long value = dataSnapshot.child(appUserUID).child("Budgeting").getChildrenCount();
                    for(DataSnapshot ds : dataSnapshot.child(appUserUID).child("Budgeting").getChildren()) {
                        String name = ds.getKey();
                        item_name.add(name);
                        item_amount.add(dataSnapshot.child(appUserUID).child("Budgeting").child(name).getValue().toString());
                        // System.out.println(item_amount.get(0));
                    }

                    if (item_name.isEmpty())
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        nts.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                    }

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
                Intent i = new Intent(getApplicationContext(), estimated_monthly_expense.class);
                startActivity(i);
            }
        });

    }

    private void initRecyclerView()
    {

        RecyclerView recyclerView = findViewById(R.id.show_data);
        recyclerViewAdapter = new RecyclerViewAdapter(item_name, item_amount,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    public void estimateDone(View v)
    {
        Intent i = new Intent(getApplicationContext(), bottom_navigation.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}