package com.mm.budgetech.services.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.mm.budgetech.R;
import com.mm.budgetech.views.auth.sign_up;
import com.mm.budgetech.views.budgeting.estimated_monthly_expense;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.Executor;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static com.facebook.FacebookSdk.getApplicationContext;

public class authentication {

    //   String Email;
    // String Password;

    public static final String EMAIL = "email";
    public static final int RC_SIGN_IN = 1;
    sign_up new_sign_up_instance = new sign_up();


    //SignInAnonymously

    public void SignInAnonymously(final Context SignInAnonymousContext) {
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInAnonymously()
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success", "signInAnonymously:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Failed", "signInAnonymously:failure", task.getException());
                            Toast.makeText(SignInAnonymousContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    //SignUpusingEmailandPassword

    public void SignUpUsingEmailandPassword(final String email, final String password, final Context SignUpContext) {
        System.out.println(email);
        System.out.println(password);
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

        if (password.length() >= 6) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Successful", "createUserWithEmail:success");
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                SignInUsingEmailandPassword(email, password, SignUpContext);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Fail", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUpContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }

                            // ...
                        }
                    });
        } else {
            Toast.makeText(SignUpContext, "Password length should be greater than six", Toast.LENGTH_LONG).show();
        }


    }


    //SignInUsingEmailandPassword

    public void SignInUsingEmailandPassword(String email, String password, final Context authentication_context) {
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("success", "signInWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(authentication_context, "Signed In", Toast.LENGTH_SHORT).show();

                            //  updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("fail", "signInWithEmail:failure", task.getException());
                            Toast.makeText(authentication_context, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }
                    }
                }));
    }


    //SignInUsingFacebook

    public CallbackManager SignInUsingFacebook (LoginButton FBloginButton, final Activity FBcontext) {

         final LoginButton loginButton = FBloginButton ;
        System.out.println("Fbbbbbbb");
        final CallbackManager callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions(EMAIL);
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                    System.out.println("Success_FB");
                    AccessToken accessToken = loginResult.getAccessToken();
                    handleFacebookAccessToken(accessToken, FBcontext);
                    getFacebookUserData(accessToken);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                System.out.println("Failed_FB: " + exception);
            }

        });
        System.out.println("Bye Fb");
        loginButton.performClick();
        return callbackManager;
    }

    public void handleFacebookAccessToken(AccessToken token, final Activity FBContext) {
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        Log.d("FacebookIntoFirebase", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success_FBintoFB", "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent new_expense_activity = new Intent(FBContext, estimated_monthly_expense.class);
                            FBContext.startActivity(new_expense_activity);
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Fail_FBintoFB", "signInWithCredential:failure", task.getException());
                          //  Toast.makeText(FacebookLoginActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }


    private void getFacebookUserData(AccessToken accessToken)
    {
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.v("LoginActivity", response.toString());

                        // Application code
                        try {
                            String email = object.getString("email");
                            System.out.println(email);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "email");
        request.setParameters(parameters);
        request.executeAsync();

    }


    /**************************************** SIGN_UP_USING_GOOGLE_METHODS*************************/

    // SignInUsingGoogleSettings

    public GoogleSignInClient SignUsingGoogleSettings(Context SignInGoogleContext) {


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("600098811576-tcdu4okf2cq46fedb2gf65v89t33u17q.apps.googleusercontent.com")
                .requestEmail()
                .build();
       GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(SignInGoogleContext, gso);
       return mGoogleSignInClient;


    }
    public void handleSignInResult(Task<GoogleSignInAccount> completedTask, final Activity GoogleContext) {
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            System.out.println("Signed In");


            // Signed in successfully, show authenticated UI.

            AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
            firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("FirebaseAuth Successful", "signInWithCredential:success");
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                Intent new_expense_activity = new Intent(GoogleContext, estimated_monthly_expense.class);
                                GoogleContext.startActivity(new_expense_activity);
                             //   updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Firebase Auth Failed", "signInWithCredential:failure", task.getException());
                                //Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });

          //  updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("failed", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }


public String getGoogleUserData(Context GoogleContext)
{
    GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(GoogleContext);
    if (acct != null) {
        String personEmail = acct.getEmail();
        return personEmail;
    }
    else
    {
        return "Error";
    }

}

}


