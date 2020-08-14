package com.mm.budgetech.views.navigation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
import static com.mm.budgetech.static_constants.reference;

public class RecyclerViewAdapterInsights extends RecyclerView.Adapter<RecyclerViewAdapterInsights.ViewHolder> {

    ArrayList<String> insights = new ArrayList<>();


    private Context mContext;

    public RecyclerViewAdapterInsights(ArrayList<String> insights,
                                       Context mContext) {
        this.insights = insights;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitems_insights, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {
        System.out.println("Binderrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr ");
        holder.msg.setText(insights.get(position));
    }

    @Override
    public int getItemCount() {
        return insights.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView msg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msg = itemView.findViewById(R.id.insights_tv);

        }

    }


}
