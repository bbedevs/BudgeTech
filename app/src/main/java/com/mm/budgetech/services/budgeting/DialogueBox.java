package com.mm.budgetech.services.budgeting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.services.RecyclerViewAdapter;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.item_name;
import static com.mm.budgetech.static_constants.recyclerViewAdapter;
import static com.mm.budgetech.static_constants.reference;

public class DialogueBox extends Dialog implements android.view.View.OnClickListener {

    public Dialog d;
    public FloatingActionButton done;
    AppCompatEditText amount_to_change;
    Context context;
    String name;
    int pos;



    public DialogueBox(@NonNull Context context, String name, int pos) {
        super(context);
        this.context = context;
        this.name = name;
        this.pos = pos;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogue_box);
        done = findViewById(R.id.done_amount_change);
        amount_to_change = findViewById(R.id.amount_to_change);
        done.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if (v.getId() == R.id.done_amount_change)
            {
                String value = amount_to_change.getText().toString();
                if (amount_to_change.getText() != null)
                {
                    reference.child(appUserUID).child("Budgeting").child(name).setValue(value);
                    item_amount.set(pos, value);
                    recyclerViewAdapter.notifyDataSetChanged();
                    System.out.println(item_amount.get(pos));
                    dismiss();
                }
                else
                {
                    Toast.makeText(context, "Enter an amount", Toast.LENGTH_SHORT).show();
                }

            }
    }


    }
}
