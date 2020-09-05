package com.mm.budgetech.views.loans.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.loans;

import java.util.ArrayList;

import static com.mm.budgetech.static_constants.amount_loans_paid;
import static com.mm.budgetech.static_constants.amount_loans_rec;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.date_loans_paid;
import static com.mm.budgetech.static_constants.date_loans_rec;
import static com.mm.budgetech.static_constants.name_loans_paid;
import static com.mm.budgetech.static_constants.name_loans_rec;
import static com.mm.budgetech.static_constants.nametemps_loans_paid;
import static com.mm.budgetech.static_constants.nametemps_loans_rec;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansPaid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansRec;
import static com.mm.budgetech.static_constants.reference;

public class RecyclerViewAdapterLoansRec extends RecyclerView.Adapter<RecyclerViewAdapterLoansRec.ViewHolder> {

    ArrayList<String> item_names = new ArrayList<>();
    ArrayList<String> item_namesTemp = new ArrayList<>();
   // ArrayList<String> timeleft = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();




    private Context mContext;

    public RecyclerViewAdapterLoansRec(ArrayList<String> item_names, ArrayList<String> item_namesTemp, ArrayList<String> amount, ArrayList<String> date,
                                       Context mContext) {
        this.item_names = item_names;
        this.item_namesTemp = item_namesTemp;
        //this.timeleft = timeleft;
        this.amount = amount;
        this.date = date;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems_loans_rec, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        System.out.println("Binderrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr ");



        holder.name.setText(item_names.get(position));
        holder.amount.setText(amount.get(position));
        holder.date.setText(date.get(position));


        try
        {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(final DataSnapshot dataSnapshot) {

                    if(dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(nametemps_loans_rec.get(position)).hasChild("Done"))
                    {
                        holder.CA.setBackgroundColor(Color.parseColor("#68FF91"));

                    }
                    holder.CA.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(!dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(nametemps_loans_rec.get(position)).hasChild("Done"))
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("Would you like to update your current balance?").setTitle("Have you received this amount back?")
                                        .setCancelable(false) .setNegativeButton("Yes",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                Intent i = new Intent(mContext, loans.class);
                                                holder.CA.setBackgroundColor(Color.parseColor("#68FF91"));
                                                int amountUser = Integer.parseInt(dataSnapshot.child(appUserUID).child("Loans").child("LoansToReceive").child(nametemps_loans_rec.get(position)).child("Amount").getValue().toString());
                                                int amountCurrentBalance = Integer.parseInt(dataSnapshot.child(appUserUID).child("Remaining").getValue().toString());
                                                int amountNew = amountCurrentBalance + amountUser ;
                                                reference.child(appUserUID).child("Remaining").setValue(amountNew);
                                                reference.child(appUserUID).child("Loans").child("LoansToReceive").child(nametemps_loans_rec.get(position)).child("Done").setValue("1");

                                                try
                                                {
                                                    int totalpayamount = Integer.parseInt(dataSnapshot.child(appUserUID).child("Loans_Received_Total").getValue().toString());
                                                    totalpayamount = totalpayamount - amountUser;
                                                    reference.child(appUserUID).child("Loans_Received_Total").setValue(totalpayamount);
                                                }
                                                catch (Exception e)
                                                {

                                                }


                                                mContext.startActivity(i);

                                            }
                                        })
                                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                                Toast.makeText(mContext,"Cancelled",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();

                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("You have already received this amount").setTitle("Loan Received")
                                        .setCancelable(false) .setPositiveButton("Ok",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();

                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();

                            }
                        }

                    });




                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });

        }
        catch (Exception e)
        {

        }



        holder.CA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Would you like to delete this entry?").setTitle("Delete Loans")
                        .setCancelable(false) .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                holder.CA.setBackgroundColor(mContext.getResources().getColor(R.color.recycleviewcolor));
                                reference.child(appUserUID).child("Loans").child("LoansToReceive").child(item_namesTemp.get(position)).setValue(null);
                                Toast.makeText(mContext,item_names.get(position),
                                        Toast.LENGTH_SHORT).show();
                                nametemps_loans_rec.remove(position);
                                name_loans_rec.remove(position);
                                amount_loans_rec.remove(position);
                                date_loans_rec.remove(position);
                                recyclerViewAdapterLoansRec.notifyDataSetChanged();


                            }
                        })
                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(mContext,"Cancelled",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return item_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView name;
        //TextView timeleft;
        ConstraintLayout CA;
        TextView amount;
        TextView date;
      //  ProgressBar progressBarSave;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.loan_rec_name);
           // timeleft = itemView.findViewById(R.id.time_left);
            CA = itemView.findViewById(R.id.constraintLayout_rec);
            amount = itemView.findViewById(R.id.loan_rec_Amount);
            date = itemView.findViewById(R.id.reminder_rec);
            //progressBarSave = itemView.findViewById(R.id.progress_save);
        }

    }


}
