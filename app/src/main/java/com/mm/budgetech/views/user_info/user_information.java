package com.mm.budgetech.views.user_info;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.mm.budgetech.model.User;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;

public class user_information extends AppCompatActivity {
    

    AppCompatSpinner bankInformation;
    AppCompatEditText email, phone, loan, location, savings;
    ArrayAdapter<String> adapter;
    String[] banks = {"Select Your Bank", "Habib Bank Limited", "Bank of Punjab", "Faysal Bank", "National Bank of Pakistan", "Meezan Bank"};

    String emailtext, phonetext, loantext, locationtext, savingstext, banktext;

    FloatingActionButton next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);


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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailtext = email.getText().toString();
                phonetext = phone.getText().toString();
                banktext =  bankInformation.getSelectedItem().toString();
                loantext = loan.getText().toString();
                locationtext = location.getText().toString();
                savingstext = savings.getText().toString();

                System.out.println(emailtext);
                System.out.println(phonetext);
                System.out.println(banktext);
                System.out.println(loantext);
                System.out.println(locationtext);
                System.out.println(savingstext);

            }
        });


    }
}
