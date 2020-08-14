package com.mm.budgetech.views.recordkeeping;

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

import static com.mm.budgetech.static_constants.amount_record;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.childName;
import static com.mm.budgetech.static_constants.date_record;
import static com.mm.budgetech.static_constants.des_record;
import static com.mm.budgetech.static_constants.parentName;
import static com.mm.budgetech.static_constants.recyclerViewAdapterRecord;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;

public class RecyclerViewAdapterRecord extends RecyclerView.Adapter<RecyclerViewAdapterRecord.ViewHolder> {

    ArrayList<String> item_names = new ArrayList<>();
   // ArrayList<String> timeleft = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();




    private Context mContext;

    public RecyclerViewAdapterRecord(ArrayList<String> item_names, ArrayList<String> amount, ArrayList<String> date,
                                     Context mContext) {
        this.item_names = item_names;
        this.amount = amount;
        this.date = date;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems_record, parent, false);
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
                builder.setMessage("Would you like to delete this entry?").setTitle("Delete Record")
                        .setCancelable(false) .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //String parentName = item_names.get(position).replaceAll("[^A-Za-z]","");
                                System.out.println(parentName.get(position));
                                reference.child(appUserUID).child("Record_Keeping").child(parentName.get(position)).child(childName.get(position)).setValue(null);
                                Toast.makeText(mContext,item_names.get(position), Toast.LENGTH_SHORT).show();
                                des_record.remove(position);
                                amount_record.remove(position);
                                date_record.remove(position);
                                parentName.remove(position);
                                childName.remove(position);
                                recyclerViewAdapterRecord.notifyDataSetChanged();


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
            name = itemView.findViewById(R.id.all_rec_des);
            amount = itemView.findViewById(R.id.record_keep_amount);
            date = itemView.findViewById(R.id.rec_time_show);
            CA = itemView.findViewById(R.id.constraintLayout_record_keeping);

        }

    }


}
