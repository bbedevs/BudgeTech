package com.mm.budgetech.views.loans;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.R;
import com.mm.budgetech.services.BroadCastReceiver;
import com.mm.budgetech.services.services;

import java.sql.Date;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static com.facebook.FacebookSdk.getApplicationContext;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.item_amount;
import static com.mm.budgetech.static_constants.recyclerViewAdapter;
import static com.mm.budgetech.static_constants.reference;

public class DialogueBoxLoans extends Dialog implements View.OnClickListener {


    FloatingActionButton done_loan;
    DatePicker datePicker;
    Context context;
    String name;
    String loanType;



    public DialogueBoxLoans(@NonNull Context context, String name, String loanType) {
        super(context);
        this.context = context;
        this.name = name;
        this.loanType = loanType;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogue_box_loans);
        CreateNotificationChannel();
        done_loan = findViewById(R.id.done_loan_reminder);
        datePicker = findViewById(R.id.date_loan);
        done_loan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            if (v.getId() == R.id.done_loan_reminder)
            {
                String date = datePicker.getDayOfMonth() + "/" +datePicker.getMonth()+"/"+ datePicker.getYear();


                if(loanType == "Loan Amount To be Paid Back")
                {
                    reference.child(appUserUID).child("Loans").child("LoansToPaid").child(name).child("Date").setValue(date);
                    createNotification();



                }
                else if (loanType == "Loan Amount to be Received")
                {
                    reference.child(appUserUID).child("Loans").child("LoansToReceive").child(name).child("Date").setValue(date);
                    createNotification();


                }
            dismiss();

            }
    }

    public void createNotification () {
        Intent myIntent = new Intent(getApplicationContext() , BroadCastReceiver.class ) ;
        myIntent.putExtra("title", loanType);
        myIntent.putExtra("content", "To "+name);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0 , myIntent , 0 ) ;
        Calendar calendar = Calendar.getInstance () ;
//        calendar.set(Calendar. SECOND , 0 ) ;
//        calendar.set(Calendar. MINUTE , 0 ) ;
//        calendar.set(Calendar. HOUR , 0 ) ;
//        calendar.set(Calendar. AM_PM , Calendar. AM ) ;

        calendar.set(Calendar.DAY_OF_MONTH , datePicker.getDayOfMonth());
        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        calendar.set(Calendar.MINUTE, 14);

        long click = System.currentTimeMillis();
        long inc = 1000*15;
        alarmManager.set(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis(), pendingIntent) ;
        System.out.println("Noti bn gyeeeeeeeeee");
    }

    public void CreateNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            System.out.println("Oreooooooooooo");
            CharSequence name = "BudgeTechChannel";
            String des = "Channel for Loans Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("notifyLoan", name, importance);
            notificationChannel.setDescription(des);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    }

