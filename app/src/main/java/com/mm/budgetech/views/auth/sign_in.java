package com.mm.budgetech.views.auth;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.mm.budgetech.R;
import com.mm.budgetech.services.auth.authentication;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;

import java.util.Objects;

public class sign_in extends AppCompatActivity {
    String email;
    String password;
    FirebaseAuth firebaseAuth;
    authentication auth;

    EditText Email;
    EditText Password;
    Button sign_in;
    Button sign_up;



    public void onStart(){
        super.onStart();


        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
       // System.out.println(Objects.requireNonNull(account).toString());
//        if (account != null ||  accessToken!= null)
//        {
//            Intent new_expense_activity = new Intent(getApplicationContext(), estimated_monthly_expense.class);
//            startActivity(new_expense_activity);
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.hide();



        CircularImageView circularImageView = findViewById(R.id.circularImageView);
        circularImageView.setCircleColor(Color.GRAY);
       // circularImageView.setCircleColorStart(Color.BLUE);
       // circularImageView.setCircleColorEnd(Color.GREEN);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.GRAY);
        //circularImageView.setBorderColorStart(Color.BLACK);
        //circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
        circularImageView.setShadowEnable(true);
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.BLACK);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);
        circularImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

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
                auth.SignInUsingEmailandPassword(email, password, getApplicationContext());
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
