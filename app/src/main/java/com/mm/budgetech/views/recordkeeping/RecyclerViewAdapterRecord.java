package com.mm.budgetech.views.recordkeeping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mm.budgetech.R;

import java.util.ArrayList;

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

        }

    }


}
