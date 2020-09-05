package com.mm.budgetech.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class SmsReceiver extends BroadCastReceiver {

    String ID_child;
    String ID;
    int num;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        ID = "SMS";

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        System.out.println(msg_from);
                        final String msgBody = msgs[i].getMessageBody();
                        if (msgBody.contains("debited") || msgBody.contains("bill") || msgBody.contains("Bill") ||
                                msgBody.contains("Debited") ||  msgBody.contains("transferred") || msgBody.contains("Recharge")
                                || msgBody.contains("Transferred")  ||  msgBody.contains("Charged") ||  msgBody.contains("charged"))
                        {
                            //String number  = msgBody.replaceAll("[^0-9]", "");
                           // System.out.println(number);
                             String[] msgSplit = msgBody.split(" ");
                            for (int j = 0; j < msgSplit.length; j++)
                            {
                                if(!msgSplit[j].contains("*"))
                                {
                                    NumberFormat format = NumberFormat.getInstance(Locale.US);
                                    try {
                                        Number number = format.parse(msgSplit[j]);
                                        num = number.intValue();
                                        System.out.println("Success: " + num);
                                        reference.child(appUserUID).child("Record_Keeping").child(ID)
                                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        // get total available quest
                                                        int size = (int) dataSnapshot.getChildrenCount();
                                                        size = size + 1;
                                                        System.out.println(size);
                                                        ID_child = ID + size;
                                                        String currentTime = java.text.DateFormat.getDateTimeInstance().format(new Date());
                                                        System.out.println(currentTime);
                                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("amount").setValue(num);
                                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("date").setValue(currentTime);
                                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("description").setValue("SMS Automatic Record");
                                                        reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("detail_description").setValue(msgBody);


                                                    }
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {

                                                    }
                                                });

                                        Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();



                                        break;
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                        System.out.println(msgBody);
                    }

                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }


            }
        }
    }

    public boolean stringContainsNumber( String s )
    {
        return Pattern.compile( "[0-9]" ).matcher( s ).find();
    }
}
