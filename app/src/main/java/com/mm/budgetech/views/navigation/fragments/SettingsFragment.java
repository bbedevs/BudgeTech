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
import com.mm.budgetech.R;
import com.mm.budgetech.views.auth.sign_in;
import com.mm.budgetech.views.user_info.user_information;

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
        HelpBtn = root.findViewById(R.id.help_button);
        ContactBtn = root.findViewById(R.id.contact_button);
        LogOutBtn = root.findViewById(R.id.logout_button);

        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(),  user_information.class );
                startActivity(i);
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
