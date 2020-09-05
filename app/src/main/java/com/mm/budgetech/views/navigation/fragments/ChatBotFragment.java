package com.mm.budgetech.views.navigation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mm.budgetech.R;
import com.mm.budgetech.views.navigation.bottom_navigation;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class ChatBotFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Intent i = new Intent(getActivity().getApplicationContext(), ChatBotActivity.class );
        startActivity(i);

        return inflater.inflate(R.layout.chatbot_fragment, container, false);
    }
}
