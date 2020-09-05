package com.mm.budgetech.views.navigation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mm.budgetech.R;
import com.mm.budgetech.views.savings.DialogueBoxSavings;

import java.util.ArrayList;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;

public class RecyclerViewAdapterRecordsStats extends RecyclerView.Adapter<RecyclerViewAdapterRecordsStats.ViewHolder> {

    ArrayList<String> item_names = new ArrayList<>();
    ArrayList<String> amount_used = new ArrayList<>();
    ArrayList<String> amount_total = new ArrayList<>();




    private Context mContext;

    public RecyclerViewAdapterRecordsStats(ArrayList<String> item_names, ArrayList<String> amount_used,
                                           ArrayList<String> amount_total, Context mContext) {
        this.item_names = item_names;
        this.amount_used = amount_used;
        this.amount_total = amount_total;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems_stats, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        System.out.println("Binderrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr ");



        holder.name.setText(item_names.get(position));
        holder.amount_used.setText(amount_used.get(position));
        holder.total_amount.setText(amount_total.get(position));
        String temp_used = amount_used.get(position);
        String temp_total = amount_total.get(position);

        String[] temp_used_arr = temp_used.split(" ");
        String[] temp_total_arr = temp_total.split(" ");
        holder.progressBarSave.setMax((int)Long.parseLong(temp_total_arr[0]));
        holder.progressBarSave.setProgress((int)Long.parseLong(temp_used_arr[0]));


        if (Integer.parseInt(temp_used_arr[0]) >= Integer.parseInt(temp_total_arr[0]))
        {
            System.out.println(amount_total.get(position));
            System.out.println(amount_used.get(position));
            holder.CA.setBackgroundColor(Color.parseColor("#FFCCCB"));
        }


//
//        holder.CA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  Toast.makeText(mContext, amount_used.get(position), Toast.LENGTH_LONG).show();
////                Bundle args = new Bundle();
////                args.putString("name", item_names.get(position));
//                  DialogueBoxSavings dialogueBox = new DialogueBoxSavings(mContext, amount_saved.get(position), item_name_savings.get(position), position, holder.CA );
//                  dialogueBox.show();
//            }
//        });

//        holder.CA.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                builder.setMessage("Would you like to delete this entry?").setTitle("Delete Saving Goal")
//                        .setCancelable(false) .setNegativeButton("Yes",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                                reference.child(appUserUID).child("Savings").child(item_names.get(position)).setValue(null);
//                                Toast.makeText(mContext,item_names.get(position),
//                                        Toast.LENGTH_SHORT).show();
//                                item_names.remove(position);
//                                timeleft.remove(position);
//                                amount_saved.remove(position);
//                                amount_total.remove(position);
//                                recyclerViewAdapterSavings.notifyDataSetChanged();
//
//
//                            }
//                        })
//                        .setPositiveButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                        Toast.makeText(mContext,"Cancelled",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//                AlertDialog alert = builder.create();
//                alert.show();
//                return true;
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return item_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView name;
        RelativeLayout CA;
        TextView amount_used;
        TextView total_amount;
        ProgressBar progressBarSave;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_recordStats);
            CA = itemView.findViewById(R.id.stats_layout);
            amount_used = itemView.findViewById(R.id.amount_used);
            total_amount = itemView.findViewById(R.id.amount_totalStats);
            progressBarSave = itemView.findViewById(R.id.progress_recordStats);
        }

    }


}
