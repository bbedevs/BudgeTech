package com.mm.budgetech.services.budgeting;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.widget.AppCompatEditText;


import com.mm.budgetech.R;



public class monthlyBudget {

    String val = "";
    String val2 = "";
    String val3 = "";
    String val4 = "";

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

    public String amountAddFABaction_rec(View v, AppCompatEditText amount, Context estimateContext) {
        if (v.getId() == R.id.food_rec) {
            val2 = "Food";
        } else if (v.getId() == R.id.housing_rec) {
            val2 = "Housing";
        } else if (v.getId() == R.id.transport_rec) {
            val2 = "Transport";
        } else if (v.getId() == R.id.billutil_rec) {
            val2 = "Bills-Utilities";
        } else if (v.getId() == R.id.insurance_rec) {
            val2 = "Insurance";
        } else if (v.getId() == R.id.health_rec) {
            val2 = "Health";
        } else if (v.getId() == R.id.entertainment_rec) {
            val2 =  "Entertainment";
        } else if (v.getId() == R.id.savings_rec) {
            val2 =  "Savings";
        } else if (v.getId() == R.id.investing_rec) {
            val2 = "Investing";
        }

        amount.requestFocus();
        amount.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) estimateContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(amount, InputMethodManager.SHOW_FORCED);

        return val2;
    }

    public String amountAddFABaction_save(View v, AppCompatEditText amount, Context estimateContext) {
        if (v.getId() == R.id.food_sav) {
            val3 = "Food";
        } else if (v.getId() == R.id.housing_sav) {
            val3 = "Housing";
        } else if (v.getId() == R.id.transport_sav) {
            val3 = "Transport";
        } else if (v.getId() == R.id.billutil_sav) {
            val3 = "Bills-Utilities";
        } else if (v.getId() == R.id.insurance_sav) {
            val3 = "Insurance";
        } else if (v.getId() == R.id.health_sav) {
            val3 = "Health";
        } else if (v.getId() == R.id.entertainment_sav) {
            val3 =  "Entertainment";
        } else if (v.getId() == R.id.savings_sav) {
            val3 =  "Savings";
        } else if (v.getId() == R.id.investing_sav) {
            val3 = "Investing";
        }

        amount.requestFocus();
        amount.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) estimateContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(amount, InputMethodManager.SHOW_FORCED);

        return val3;
    }


    public String amountAddFABaction_loan(View v, AppCompatEditText amount, Context estimateContext) {
        if (v.getId() == R.id.emergency_loan) {
            val4 = "Emergency";
        } else if (v.getId() == R.id.housing_loan) {
            val4 = "Housing";
        } else if (v.getId() == R.id.transport_loan) {
            val4 = "Transport";
        } else if (v.getId() == R.id.billutil_loan) {
            val4 = "Bills-Utilities";
        } else if (v.getId() == R.id.insurance_loan) {
            val4 = "Insurance";
        } else if (v.getId() == R.id.health_loan) {
            val4 = "Health";
        }
        amount.requestFocus();
        amount.setFocusableInTouchMode(true);
        InputMethodManager imm = (InputMethodManager) estimateContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(amount, InputMethodManager.SHOW_FORCED);

        return val4;
    }

}