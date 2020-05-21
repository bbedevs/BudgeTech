package com.mm.budgetech.views.auth;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.mm.budgetech.R;
import com.mm.budgetech.model.User;
import com.mm.budgetech.services.auth.authentication;

import java.util.Objects;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static com.mm.budgetech.static_constants.RC_SIGN_IN;


public class sign_up extends AppCompatActivity {

    String email;
    String password;
    String username;
    FirebaseAuth firebaseAuth;
    authentication auth;

    LoginButton loginButton;
    FloatingActionButton sign_up_google;
    EditText Email;
    EditText Password;
    EditText Username;
    FloatingActionButton sign_up_facebook;
    TextView alreadyHaveAnAccount;
    FloatingActionButton sign_up_Email;
    CallbackManager callbackManager;
    boolean facebook_check = false;


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.appPrimaryColor)));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);



        sign_up_Email = (FloatingActionButton) findViewById(R.id.signup_floating_button);
        sign_up_facebook = (FloatingActionButton) findViewById(R.id.facebook_button);
        sign_up_google = (FloatingActionButton) findViewById(R.id.google_button);
        Email = findViewById(R.id.email_sign_up);
        Password =  findViewById(R.id.email_sign_up);
        Username = findViewById(R.id.username);
        auth = new authentication();

//        sign_up_facebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             callbackManager =   auth.SignInUsingFacebook(loginButton);
//            }
//        });

        sign_up_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInGoogle(getApplicationContext());
            }
        });


        sign_up_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString();
                password = Password.getText().toString();
                username = Username.getText().toString();
                auth.SignUpUsingEmailandPassword(email, password, username, getApplicationContext());

            }
        });


   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (facebook_check == true) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            auth.handleSignInResult(task, this);
            String userGoogleEmail = auth.getGoogleUserData(getApplicationContext());
            System.out.println(userGoogleEmail);
        }

    }

//    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
//        @Override
//        protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken1) {
//            auth.loadUserProfile(accessToken1);
//        }
//    };

public void change_screen_to_signin(View v)
{
//    alreadyHaveAnAccount = findViewById(R.id.already_account);
//    alreadyHaveAnAccount.setBackgroundColor(getResources().getColor(R.color.white));
    Intent signin = new Intent(getApplicationContext(), sign_in.class);
    startActivity(signin);
}

    public void onClickFacebookButton(View view) {
        sign_up_facebook= findViewById(R.id.facebook_button);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        auth = new authentication();
        if (view == sign_up_facebook) {
            System.out.println("Hyaaai");
            facebook_check = true;
           callbackManager = auth.SignInUsingFacebook(loginButton, this);
        }
    }

    public void signInGoogle(Context SignInGoogleContext) {

        GoogleSignInClient mGoogleSignInClient = auth.SignUsingGoogleSettings(SignInGoogleContext);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
