package com.mm.budgetech.views.navigation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.auth.sign_in;
import com.mm.budgetech.views.user_info.user_information;

import static com.mm.budgetech.static_constants.appUser;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class SettingsFragment extends Fragment {

    ImageButton ProfileBtn;
    ImageButton HelpBtn;
    ImageButton ContactBtn;
    ImageButton LogOutBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.settings_fragment, container, false);
        ProfileBtn = root.findViewById(R.id.profile_button);
        //HelpBtn = root.findViewById(R.id.help_button);
       // ContactBtn = root.findViewById(R.id.contact_button);
        LogOutBtn = root.findViewById(R.id.logout_button);

        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                reference.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot)
//                    {
//                        if (dataSnapshot.child(appUserUID).hasChild("Income")) {
//                            appUser.income =  dataSnapshot.child(appUserUID).child("Income").getValue().toString();
//                        }
//                        if (dataSnapshot.child(appUserUID).hasChild("Remaining")) {
//                            appUser.currentBalance = dataSnapshot.child(appUserUID).child("Remaining").getValue().toString();
//                        }
//                        if (dataSnapshot.child(appUserUID).hasChild("Savings_Total")) {
//                            appUser.savings = dataSnapshot.child(appUserUID).child("Savings_Total").getValue().toString();
//                        }

                        Intent i = new Intent(getActivity().getApplicationContext(),  user_information.class );
                        i.putExtra("fromSettings", true);
                        startActivity(i);

//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//                    }
//                });



            }
        });

        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                GoogleSignInOptions gso = new GoogleSignInOptions.
                        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                        build();

                GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(getActivity().getApplicationContext(),gso);
                googleSignInClient.signOut();

                Intent i = new Intent(getActivity().getApplicationContext(), sign_in.class);
                startActivity(i);

            }
        });
        return root;
    }
}
