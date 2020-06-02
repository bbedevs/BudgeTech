package com.mm.budgetech;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mm.budgetech.model.User;
import com.mm.budgetech.services.RecyclerViewAdapter;

import java.util.ArrayList;

public class static_constants {
    public static User appUser = new User();
    public static final String EMAIL = "email";
    public static DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
    public static String appUserUID;
    public static final int RC_SIGN_IN = 1;
    public static RecyclerViewAdapter recyclerViewAdapter;
    public static ArrayList<String> item_name = new ArrayList<>();
    public static   ArrayList<String> item_amount = new ArrayList<>();

}
