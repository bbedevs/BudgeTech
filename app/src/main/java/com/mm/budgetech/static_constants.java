package com.mm.budgetech;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mm.budgetech.model.User;
import com.mm.budgetech.services.RecyclerViewAdapter;
import com.mm.budgetech.views.loans.fragments.RecyclerViewAdapterLoansPaid;
import com.mm.budgetech.views.loans.fragments.RecyclerViewAdapterLoansRec;
import com.mm.budgetech.views.navigation.RecyclerViewAdapterRecordsStats;
import com.mm.budgetech.views.navigation.fragments.RecyclerViewAdapterInsights;
import com.mm.budgetech.views.recordkeeping.RecyclerViewAdapterRecord;
import com.mm.budgetech.views.savings.RecyclerViewAdapterSavings;

import java.util.ArrayList;

public class static_constants {
    public static User appUser = new User();
    public static final String EMAIL = "email";
    public static DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
    public static String appUserUID;
    public static final int RC_SIGN_IN = 1;


    public static ArrayList<String> item_name = new ArrayList<>();
    public static  ArrayList<String> item_amount = new ArrayList<>();
    public static RecyclerViewAdapter recyclerViewAdapter;

    public static  ArrayList<String> item_name_savings = new ArrayList<>();
    public static  ArrayList<String> timeleft = new ArrayList<>();
    public static  ArrayList<String> amount_saved = new ArrayList<>();
    public static  ArrayList<String> amount_total = new ArrayList<>();
    public static RecyclerViewAdapterSavings recyclerViewAdapterSavings;


    public static  ArrayList<String> name_loans_paid = new ArrayList<>();
    public static  ArrayList<String> amount_loans_paid = new ArrayList<>();
    public static  ArrayList<String> date_loans_paid = new ArrayList<>();
    public static  ArrayList<String> nametemps_loans_paid = new ArrayList<>();
    public static RecyclerViewAdapterLoansPaid recyclerViewAdapterLoansPaid;

    public static  ArrayList<String> name_loans_rec = new ArrayList<>();
    public static  ArrayList<String> amount_loans_rec = new ArrayList<>();
    public static  ArrayList<String> date_loans_rec = new ArrayList<>();
    public static  ArrayList<String> nametemps_loans_rec = new ArrayList<>();
    public static RecyclerViewAdapterLoansRec recyclerViewAdapterLoansRec;

    public static  ArrayList<String> des_record = new ArrayList<>();
    public static  ArrayList<String> amount_record = new ArrayList<>();
    public static  ArrayList<String> date_record = new ArrayList<>();
    public static  ArrayList<String> parentName = new ArrayList<>();
    public static  ArrayList<String> childName = new ArrayList<>();
    public static RecyclerViewAdapterRecord recyclerViewAdapterRecord;

    public static ArrayList<String> insights_list = new ArrayList<>();
    public static RecyclerViewAdapterInsights recyclerViewAdapterInsights;

    public static ArrayList<String> name_stats = new ArrayList<>();
    public static ArrayList<String> amount_usedStats = new ArrayList<>();
    public static ArrayList<String> amount_totalStats = new ArrayList<>();
    public static RecyclerViewAdapterRecordsStats recyclerViewAdapterRecordsStats;


    public static final String Prefs = "myprefs";


}
