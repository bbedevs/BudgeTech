package com.mm.budgetech.views.user_info;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.mm.budgetech.model.User;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.setUserInfo;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;


public class user_information extends AppCompatActivity {
    

    AppCompatSpinner bankInformation;
    AppCompatEditText email, phone, loan, location, savings;
    ArrayAdapter<String> adapter;
    String[] banks = {"Select Your Bank", "Habib Bank Limited", "Bank of Punjab", "Faysal Bank", "National Bank of Pakistan", "Meezan Bank"};

    String emailtext, phonetext, loantext, locationtext, savingstext, banktext;

    FloatingActionButton next;

    setUserInfo info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);

        info = new setUserInfo();

        email = findViewById(R.id.info_email);
        phone = findViewById(R.id.info_phone);
        loan = findViewById(R.id.info_loan);
        savings = findViewById(R.id.info_Savings);
        location = findViewById(R.id.info_location);
        bankInformation =  findViewById(R.id.BankInfo);

        next = findViewById(R.id.next);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, banks);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankInformation.setAdapter(adapter);

        info.setEmailPhone(email, phone);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            info.setInfo(email, phone, bankInformation, loan, location, savings);
            Intent estimated_monthly_expense = new Intent(getApplicationContext(), estimated_monthly_expense.class);
            startActivity(estimated_monthly_expense);

            }
        });


    }
}
