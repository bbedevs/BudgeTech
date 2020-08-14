package com.mm.budgetech.services.budgeting;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class setUserInfo {

    public void setEmailPhone(AppCompatEditText email, AppCompatEditText phonenum)
    {
        if(appUser.email != null )
        {
            email.setText(appUser.email);
            email.setFocusable(false);
        }
        if (appUser.phonenum != null)
        {
            phonenum.setText(appUser.phonenum);
            email.setFocusable(false);
        }
    }
    public void setInfo(AppCompatEditText email, AppCompatEditText phone, AppCompatSpinner bankInformation, AppCompatEditText loan, AppCompatEditText location, AppCompatEditText savings )
    {
        appUser.email = email.getText().toString();
        appUser.phonenum = phone.getText().toString();
        appUser.bankname =  bankInformation.getSelectedItem().toString();
        appUser.loan = loan.getText().toString();
        appUser.location = location.getText().toString();
        appUser.savings = savings.getText().toString();

        reference.child(appUserUID).child("Email").setValue(appUser.email);
        reference.child(appUserUID).child("Phone Number").setValue(appUser.phonenum);
        reference.child(appUserUID).child("Bank").setValue(appUser.bankname);
        reference.child(appUserUID).child("Income").setValue(appUser.loan);
        reference.child(appUserUID).child("Address").setValue(appUser.location);
        reference.child(appUserUID).child("Savings_Total").setValue(appUser.savings);






    }
}
