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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.model.User;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.setUserInfo;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;
import com.mm.budgetech.views.navigation.bottom_navigation;

import static com.mm.budgetech.static_constants.amount_loans_paid;
import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.date_loans_paid;
import static com.mm.budgetech.static_constants.name_loans_paid;
import static com.mm.budgetech.static_constants.nametemps_loans_paid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansPaid;
import static com.mm.budgetech.static_constants.reference;


public class user_information extends AppCompatActivity {
    

    AppCompatSpinner bankInformation;
    AppCompatEditText email, phone, income, currentBalance ,location, savings;
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
        income = findViewById(R.id.info_income);
        currentBalance = findViewById(R.id.info_CurrentBalance);
        savings = findViewById(R.id.info_Savings);
        location = findViewById(R.id.info_location);
        bankInformation =  findViewById(R.id.BankInfo);

        next = findViewById(R.id.next);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, banks);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankInformation.setAdapter(adapter);

        info.setEmailPhone(email, phone, income, currentBalance, savings);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           boolean fromSettings = getIntent().getBooleanExtra("fromSettings", false);
           System.out.println(fromSettings);

            if(!fromSettings) {
                if ((!income.getText().toString().isEmpty() || !savings.getText().toString().isEmpty())) {
                      info.setInfo(email, phone, bankInformation, income, currentBalance, location, savings);
//                    System.out.println("Hiiiiiiiiiiiiiiiiiii");
                    Intent i = new Intent(user_information.this, estimated_monthly_expense.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "You must enter your Income and Current Savings", Toast.LENGTH_LONG).show();
                }

            }
            else if (fromSettings)
            {
                System.out.println("yooooooooooooo");
                info.setInfo(email, phone, bankInformation, income, currentBalance, location, savings);
                Intent estimated_monthly_expense = new Intent(user_information.this, bottom_navigation.class);
                estimated_monthly_expense.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(estimated_monthly_expense);


            }


           }
        });


    }
}
