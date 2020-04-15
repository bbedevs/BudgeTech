package com.mm.budgetech.views.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.mm.budgetech.R;
import com.mm.budgetech.services.auth.authentication;

public class sign_up extends AppCompatActivity {

    String email;
    String password;
    FirebaseAuth firebaseAuth;
    authentication auth;

    EditText Email;
    EditText Password;
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign_up = (Button) findViewById(R.id.button);
        Email = (EditText) findViewById(R.id.editText3);
        Password = (EditText) findViewById(R.id.editText4);
        auth = new authentication();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = Email.getText().toString();
                password = Password.getText().toString();


                auth.SignUpUsingEmailandPassword(email, password, getApplicationContext());

            }
        });



    }
}
