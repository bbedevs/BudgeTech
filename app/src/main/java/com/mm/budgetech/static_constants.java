package com.mm.budgetech;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mm.budgetech.model.User;

public class static_constants {
    public static User appUser;
    public static final String EMAIL = "email";
    public static DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
    public static String appUserUID;
    public static final int RC_SIGN_IN = 1;
}
