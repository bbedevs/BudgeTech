package com.mm.budgetech.views.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.mm.budgetech.R;
import com.mm.budgetech.services.auth.authentication;

public class sign_in extends AppCompatActivity {
    String email;
    String password;
    FirebaseAuth firebaseAuth;
    authentication auth;

    EditText Email;
    EditText Password;
    Button sign_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sign_in = (Button) findViewById(R.id.button2);
        Email = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        auth = new authentication();

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString();
                password = Password.getText().toString();

                auth.SignInUsingEmailandPassword(email, password, getApplicationContext());

            }
        });




    }
}
