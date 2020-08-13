package com.mm.budgetech.views.budgeting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.services.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Objects;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.recyclerViewAdapter;
import static com.mm.budgetech.static_constants.reference;
import static com.mm.budgetech.static_constants.item_name;

public class manageBudget extends AppCompatActivity {


    Button addnew;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_budget);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);

        addnew = (Button)findViewById(R.id.add_new);

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
                Intent i = new Intent(getApplicationContext(), estimated_monthly_expense.class);
                startActivity(i);
            }
        });

    }

    private void initRecyclerView()
    {
        progressBar = findViewById(R.id.monthlyprogress);
        RecyclerView recyclerView = findViewById(R.id.show_data);
        recyclerViewAdapter = new RecyclerViewAdapter(item_name, item_amount,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.GONE);

    }
}