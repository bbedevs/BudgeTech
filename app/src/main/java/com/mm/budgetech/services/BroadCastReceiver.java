package com.mm.budgetech.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.mm.budgetech.R;

public class BroadCastReceiver extends BroadcastReceiver {

    String title;
    String content;



    @Override
    public void onReceive(Context context, Intent intent) {
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyLoan")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManagerCompat.notify(200, builder.build());
    }
}
