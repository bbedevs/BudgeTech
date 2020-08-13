package com.mm.budgetech.views.loans.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mm.budgetech.R;

import java.util.ArrayList;

import static com.mm.budgetech.static_constants.amount_loans_paid;
import static com.mm.budgetech.static_constants.amount_loans_rec;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.date_loans_paid;
import static com.mm.budgetech.static_constants.date_loans_rec;
import static com.mm.budgetech.static_constants.name_loans_paid;
import static com.mm.budgetech.static_constants.name_loans_rec;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansPaid;
import static com.mm.budgetech.static_constants.recyclerViewAdapterLoansRec;
import static com.mm.budgetech.static_constants.reference;

public class RecyclerViewAdapterLoansRec extends RecyclerView.Adapter<RecyclerViewAdapterLoansRec.ViewHolder> {

    ArrayList<String> item_names = new ArrayList<>();
   // ArrayList<String> timeleft = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();




    private Context mContext;

    public RecyclerViewAdapterLoansRec(ArrayList<String> item_names, ArrayList<String> amount, ArrayList<String> date,
                                       Context mContext) {
        this.item_names = item_names;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {
        System.out.println("Binderrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr ");



        holder.name.setText(item_names.get(position));
     //   holder.timeleft.setText(timeleft.get(position));
        holder.amount.setText(amount.get(position));
        holder.date.setText(date.get(position));
//        String temp_saved = amount_saved.get(position);
//
//        String temp_total = amount_total.get(position);
//        String[] temp_saved_arr = temp_saved.split(" ");
//        String[] temp_total_arr = temp_total.split(" ");
//        holder.progressBarSave.setMax((int)Long.parseLong(temp_total_arr[0]));
//        holder.progressBarSave.setProgress((int)Long.parseLong(temp_saved_arr[0]));



//        holder.CA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  Toast.makeText(mContext, item_names.get(position), Toast.LENGTH_LONG).show();
////                Bundle args = new Bundle();
////                args.putString("name", item_names.get(position));
//                  DialogueBox dialogueBox = new DialogueBox(mContext, item_names.get(position), position);
//                  dialogueBox.show();
//            }
//        });



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
                                String[] name = item_names.get(position).split("To Be Received From ");
                                reference.child(appUserUID).child("Loans").child("LoansToReceive").child(name[1]).setValue(null);
                                Toast.makeText(mContext,item_names.get(position),
                                        Toast.LENGTH_SHORT).show();
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
