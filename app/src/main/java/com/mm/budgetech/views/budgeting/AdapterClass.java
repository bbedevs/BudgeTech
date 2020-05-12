package com.mm.budgetech.views.budgeting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mm.budgetech.R;
import com.mm.budgetech.model.UserSavingData;

import java.util.ArrayList;
import java.util.List;


public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<UserSavingData> mExampleList;


    AdapterClass(Context context,ArrayList<UserSavingData> listvalue)
    {
        this.layoutInflater=LayoutInflater.from(context);
        mExampleList=listvalue;

    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.saving_card_design, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        UserSavingData currentItem=mExampleList.get(position);
        holder.textView1.setText(currentItem.getAm());
        holder.textView2.setText(currentItem.getDur());
        holder.progressBar.setProgress(20);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      TextView textView1,textView2;
      ProgressBar progressBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar=itemView.findViewById(R.id.saving_progress);
            textView1=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
        }
    }
}
