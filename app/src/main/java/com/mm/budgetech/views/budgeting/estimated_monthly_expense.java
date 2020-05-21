package com.mm.budgetech.views.budgeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;

public class estimated_monthly_expense extends AppCompatActivity {

    FloatingActionButton foodFAB;
    FloatingActionButton housingFAB;
    FloatingActionButton transportFAB;
    FloatingActionButton billFAB;
    FloatingActionButton insuranceFAB;
    FloatingActionButton healthFAB;
    FloatingActionButton funFAB;
    FloatingActionButton savingsFAB;
    FloatingActionButton investingFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimated_monthly_expense);

        foodFAB = findViewById(R.id.food);
        housingFAB = findViewById(R.id.housing);
        transportFAB = findViewById(R.id.transport);
        billFAB = findViewById(R.id.billutil);
        insuranceFAB = findViewById(R.id.insurance);
        healthFAB = findViewById(R.id.health);
        funFAB = findViewById(R.id.entertainment);
        savingsFAB = findViewById(R.id.savings);
        investingFAB = findViewById(R.id.investing);







    }
}
