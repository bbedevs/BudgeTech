package com.mm.budgetech.services.budgeting;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.widget.AppCompatEditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;

import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class monthlyBudget {

    String val = "";
    public String amountAddFABaction(View v, AppCompatEditText amount, Context estimateContext) {
        if (v.getId() == R.id.food) {
            val = "Food";
        } else if (v.getId() == R.id.housing) {
            val = "Housing";
        } else if (v.getId() == R.id.transport) {
            val = "Transport";
        } else if (v.getId() == R.id.billutil) {
            val = "Bills-Utilities";
        } else if (v.getId() == R.id.insurance) {
            val = "Insurance";
        } else if (v.getId() == R.id.health) {
            val = "Health";
        } else if (v.getId() == R.id.entertainment) {
            val =  "Entertainment";
        } else if (v.getId() == R.id.savings) {
            val =  "Savings";
        } else if (v.getId() == R.id.investing) {
            val = "Investing";
        }

        amount.requestFocus();
        amount.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) estimateContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(amount, InputMethodManager.SHOW_FORCED);

       return val;
    }



}