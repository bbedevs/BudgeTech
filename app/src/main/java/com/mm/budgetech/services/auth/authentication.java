package com.mm.budgetech.services.auth;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class authentication {

 //   String Email;
   // String Password;


    //SignUpusingEmailandPassword

    public void SignUpUsingEmailandPassword (String email, String password, final Context SignUpContext)
    {
        System.out.println(email);
        System.out.println(password);
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

        if (password.length() >= 6)
        {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("Successful", "createUserWithEmail:success");
                                FirebaseUser user = firebaseAuth.getCurrentUser();
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
        }
        else
        {
            Toast.makeText(SignUpContext, "Password length should be greater than six", Toast.LENGTH_LONG).show();
        }


    }



    //SignInUsingEmailandPassword

    public void SignInUsingEmailandPassword (String email, String password, final Context authentication_context)
    {
        final FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("success", "signInWithEmail:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
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
}
