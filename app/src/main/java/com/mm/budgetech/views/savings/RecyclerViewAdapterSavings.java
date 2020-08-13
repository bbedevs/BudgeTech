package com.mm.budgetech.views.savings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mm.budgetech.R;
import com.mm.budgetech.services.budgeting.DialogueBox;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_name;
import static com.mm.budgetech.static_constants.item_name_savings;
import static com.mm.budgetech.static_constants.recyclerViewAdapterSavings;
import static com.mm.budgetech.static_constants.reference;

public class RecyclerViewAdapterSavings extends RecyclerView.Adapter<RecyclerViewAdapterSavings.ViewHolder> {

    ArrayList<String> item_names = new ArrayList<>();
    ArrayList<String> timeleft = new ArrayList<>();
    ArrayList<String> amount_saved = new ArrayList<>();
    ArrayList<String> amount_total = new ArrayList<>();




    private Context mContext;

    public RecyclerViewAdapterSavings(ArrayList<String> item_names, ArrayList<String> timeleft, ArrayList<String> amount_saved,
                                      ArrayList<String> amount_total,  Context mContext) {
        this.item_names = item_names;
        this.timeleft = timeleft;
        this.amount_saved = amount_saved;
        this.amount_total = amount_total;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems_savings, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        System.out.println("Binderrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr ");



        holder.name.setText(item_names.get(position));
        holder.timeleft.setText(timeleft.get(position));
        holder.amount_saved.setText(amount_saved.get(position));
        holder.total_amount.setText(amount_total.get(position));
        String temp_saved = amount_saved.get(position);

        String temp_total = amount_total.get(position);
        String[] temp_saved_arr = temp_saved.split(" ");
        String[] temp_total_arr = temp_total.split(" ");
        holder.progressBarSave.setMax((int)Long.parseLong(temp_total_arr[0]));
        holder.progressBarSave.setProgress((int)Long.parseLong(temp_saved_arr[0]));



        if (amount_saved.get(position).equals(amount_total.get(position)))
        {
            System.out.println(amount_total.get(position));
            System.out.println(amount_saved.get(position));
            holder.CA.setBackgroundColor(Color.parseColor("#68FF91"));
        }



        holder.CA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText(mContext, amount_saved.get(position), Toast.LENGTH_LONG).show();
//                Bundle args = new Bundle();
//                args.putString("name", item_names.get(position));
                  DialogueBoxSavings dialogueBox = new DialogueBoxSavings(mContext, amount_saved.get(position), item_name_savings.get(position), position, holder.CA );
                  dialogueBox.show();
            }
        });

        holder.CA.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Would you like to delete this entry?").setTitle("Delete Saving Goal")
                        .setCancelable(false) .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                reference.child(appUserUID).child("Savings").child(item_names.get(position)).setValue(null);
                                Toast.makeText(mContext,item_names.get(position),
                                        Toast.LENGTH_SHORT).show();
                                item_names.remove(position);
                                timeleft.remove(position);
                                amount_saved.remove(position);
                                amount_total.remove(position);
                                recyclerViewAdapterSavings.notifyDataSetChanged();


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
        TextView timeleft;
        RelativeLayout CA;
        TextView amount_saved;
        TextView total_amount;
        ProgressBar progressBarSave;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_saving);
            timeleft = itemView.findViewById(R.id.time_left);
            CA = itemView.findViewById(R.id.savings_layout);
            amount_saved = itemView.findViewById(R.id.amount_saved);
            total_amount = itemView.findViewById(R.id.amount_total);
            progressBarSave = itemView.findViewById(R.id.progress_save);
        }

    }


}
