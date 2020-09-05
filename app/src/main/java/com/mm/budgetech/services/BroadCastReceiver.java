package com.mm.budgetech.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.mm.budgetech.R;
import com.mm.budgetech.views.loans.loans;
import com.mm.budgetech.views.recordkeeping.record_keeping_frags;

public class BroadCastReceiver extends BroadcastReceiver {

    String title;
    String content;



    @Override
    public void onReceive(Context context, Intent intent) {
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");

        Intent i = new Intent(context, loans.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyLoan")
                .setSmallIcon(R.drawable.logo2)
                .setContentTitle(title)
                .setContentText(content)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify(200, builder.build());
    }
}
