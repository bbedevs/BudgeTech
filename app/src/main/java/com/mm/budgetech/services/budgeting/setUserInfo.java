package com.mm.budgetech.services.budgeting;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class setUserInfo {

    public void setEmailPhone(AppCompatEditText email, AppCompatEditText phonenum,  AppCompatEditText income, AppCompatEditText currentBalance, AppCompatEditText savings)
    {
        if(appUser.email != null )
        {
            email.setText(appUser.email);
            email.setFocusable(false);
        }
        if (appUser.phonenum != null)
        {
            phonenum.setText(appUser.phonenum);
            phonenum.setFocusable(false);
        }

        if (appUser.currentBalance != null)
        {

            currentBalance.setText(appUser.currentBalance);

        }

        if (appUser.savings != null)
        {
            savings.setText(appUser.savings);
        }

        if (appUser.income != null)
        {
            income.setText(appUser.income);
        }

    }
    public void setInfo(AppCompatEditText email, AppCompatEditText phone, AppCompatSpinner bankInformation, AppCompatEditText income, AppCompatEditText currentBalance, AppCompatEditText location, AppCompatEditText savings )
    {
        appUser.email = email.getText().toString();
        appUser.phonenum = phone.getText().toString();
        appUser.bankname =  bankInformation.getSelectedItem().toString();
        appUser.income = income.getText().toString();
        appUser.currentBalance = currentBalance.getText().toString();
        appUser.location = location.getText().toString();
        appUser.savings = savings.getText().toString();



        reference.child(appUserUID).child("Email").setValue(appUser.email);
        reference.child(appUserUID).child("Phone Number").setValue(appUser.phonenum);
        reference.child(appUserUID).child("Bank").setValue(appUser.bankname);
        reference.child(appUserUID).child("Income").setValue(appUser.income);
        reference.child(appUserUID).child("Address").setValue(appUser.location);
        reference.child(appUserUID).child("Loans_Paid_Total").setValue(0);
        reference.child(appUserUID).child("Loans_Received_Total").setValue(0);

        if(appUser.currentBalance.isEmpty())
        {
            reference.child(appUserUID).child("Remaining").setValue(appUser.income);
        }
        else
        {
            reference.child(appUserUID).child("Remaining").setValue(appUser.currentBalance);

        }

        if(appUser.savings.isEmpty())
        {
            reference.child(appUserUID).child("Savings_Total").setValue(0);
        }
        else
        {
            reference.child(appUserUID).child("Savings_Total").setValue(Integer.parseInt(appUser.savings));
        }



    }


}
