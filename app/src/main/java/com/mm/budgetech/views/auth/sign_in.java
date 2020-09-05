package com.mm.budgetech.views.auth;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.mm.budgetech.R;
import com.mm.budgetech.services.LocationService;
import com.mm.budgetech.services.auth.authentication;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;
import com.mm.budgetech.views.navigation.bottom_navigation;

import java.util.Objects;

import static com.mm.budgetech.static_constants.Prefs;
import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;

public class sign_in extends AppCompatActivity {
    String email;
    String password;
    FirebaseAuth firebaseAuth;
    authentication auth;

    EditText Email;
    EditText Password;
    Button sign_in;
    Button sign_up;
    SharedPreferences sharedPreferences;


    public void onStart() {
        super.onStart();

        int p = ContextCompat.checkSelfPermission(

                this,

                Manifest.permission.ACCESS_FINE_LOCATION) + ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if (p != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECEIVE_SMS}, 1);
//Explicitly ask for permission
        } else {
//TODO
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.hide();




        CircularImageView circularImageView = findViewById(R.id.circularImageView);
        circularImageView.setCircleColor(Color.WHITE);
       // circularImageView.setCircleColorStart(Color.BLUE);
       // circularImageView.setCircleColorEnd(Color.GREEN);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(getResources().getColor(R.color.appPrimaryColor));
        //circularImageView.setBorderColorStart(Color.BLACK);
        //circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
        circularImageView.setShadowEnable(true);
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.BLACK);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);
        //circularImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        sign_in = (Button) findViewById(R.id.login);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        auth = new authentication();
        sign_up = (Button) findViewById(R.id.signup);


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString();
                password = Password.getText().toString();
                System.out.println(email);
                System.out.println(password);
                if(!email.isEmpty() && !password.isEmpty())
                {
                    auth.SignInUsingEmailandPassword(email, password, getApplicationContext());
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Fill All Enteries", Toast.LENGTH_LONG).show();
                }

            }
        });


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign_up_activity = new Intent(getApplicationContext(), com.mm.budgetech.views.auth.sign_up.class);
                startActivity(sign_up_activity);
            }
        });

    }


}
