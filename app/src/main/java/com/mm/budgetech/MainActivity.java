package com.mm.budgetech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;

import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.mm.budgetech.services.LocationService;
import com.mm.budgetech.views.auth.sign_in;
import com.mm.budgetech.views.navigation.bottom_navigation;

import static com.mm.budgetech.static_constants.Prefs;
import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;

public class MainActivity extends AppCompatActivity {

    Intent myintent;
    ProgressBar progressBar;

    SharedPreferences sharedPreferences;

    boolean fbcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.hide();

        startService(new Intent(this, LocationService.class));

        sharedPreferences = getSharedPreferences(Prefs, MODE_PRIVATE);

        fbcheck = sharedPreferences.getBoolean("FireBaseCheck", true);

//        if(fbcheck)
//        {
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//            sharedPreferences.edit().putBoolean("FireBaseCheck", false).apply();
//
//        }

        progressBar = findViewById(R.id.progress_barSplash);


        myintent = new Intent(this, sign_in.class);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                AccessToken accessToken = AccessToken.getCurrentAccessToken();

//            System.out.println(Objects.requireNonNull(account).toString());
                if (account != null ||  accessToken!= null || user != null)
                {
                    appUserUID = sharedPreferences.getString("id", "");
                    appUser.username = sharedPreferences.getString("username", "");
                    appUser.email = sharedPreferences.getString("email", "");
                    appUser.phonenum = sharedPreferences.getString("phone", "");
                    System.out.println(appUserUID);
                    System.out.println(appUser.username);
                    System.out.println(appUser.phonenum);
                    System.out.println(appUser.email);
                    Intent new_expense_activity = new Intent(getApplicationContext(), bottom_navigation.class);
                    new_expense_activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(new_expense_activity);
                } else {
                    // User is signed out
                    startActivity(myintent) ;
                    Log.d("Ho", "onAuthStateChanged:signed_out");
                }

                finish();
            }
        }, 2000);
    }

}
