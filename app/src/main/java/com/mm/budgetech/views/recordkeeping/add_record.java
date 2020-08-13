package com.mm.budgetech.views.recordkeeping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.mm.budgetech.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

import static android.app.Activity.RESULT_OK;
import static com.facebook.FacebookSdk.getApplicationContext;
import static com.mm.budgetech.static_constants.appUserUID;
import static com.mm.budgetech.static_constants.reference;

public class add_record extends Fragment {

    Button addFirstRec;
    Button scanImagebtn;
    private int IMAGE_RESULT_CODE = 534;
    private EditText mScannedText;
    String ID_child;
    String ID;
    String total_amount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {

        final View root =  inflater.inflate(R.layout.add_record, container, false);


        addFirstRec = root.findViewById(R.id.add_first_rec);
        scanImagebtn = root.findViewById(R.id.scan_img);

        ID = "Scanned";

        addFirstRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), add_new_record.class);
                startActivity(i);
            }
        });


        scanImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, IMAGE_RESULT_CODE);
            }
        });
        return root;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream inputStream = getApplicationContext().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(inputStream);
                Frame frame = new Frame.Builder().setBitmap(selectedImage).build();
                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                SparseArray<TextBlock> items = recognizer.detect(frame);

                if (items.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < items.size(); i++) {
                        stringBuilder.append(items.valueAt(i).getValue());
                        stringBuilder.append("\n");
                    }
                   // mScannedText.setText(stringBuilder.toString());
                   // System.out.println(stringBuilder.toString());
                    categoryRecordDefine(stringBuilder.toString().toLowerCase());

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(), "No Image Picked", Toast.LENGTH_SHORT).show();
        }
    }

    void categoryRecordDefine(String scannedText)
    {
//        if (scannedText.contains("Food") || scannedText.contains("Burger") || scannedText.contains("food") || scannedText.contains("burger")
//                || scannedText.contains("Chicken") || scannedText.contains("chicken") || scannedText.contains("fries") || scannedText.contains("Fries")
//                || scannedText.contains("pizza") || scannedText.contains("bbq") || scannedText.contains("karahi") || scannedText.contains("boti")
//                || scannedText.contains("drink") || scannedText.contains("daal")
//        )
//        {
//
//        }

        if (scannedText.contains("total") || scannedText.contains("bill") || scannedText.contains("amount")
                )
        {
            String[] split = scannedText.split("total");
            //String number  = scannedText.replaceAll("[^0-9]", "");
         //   System.out.println(split[1]);
            final String[] total = split[1].split("\n");
            for (int i = 0; i < total.length; i++)
            {
                System.out.println(total[i]);
                if (stringContainsNumber(total[i]))
                {
                    System.out.println("hiyyya22");
                    System.out.println(total[i]);
                    total_amount = total[i];
                    break;
                }
            }


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
                            reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("amount").setValue(total_amount);
                            reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("date").setValue(currentTime);
                            reference.child(appUserUID).child("Record_Keeping").child(ID).child(ID_child).child("description").setValue("Scanned Record");


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(getApplicationContext(), "Not A Valid Image", Toast.LENGTH_SHORT).show();

        }
    }

    public boolean stringContainsNumber( String s )
    {
        return Pattern.compile( "[0-9]" ).matcher( s ).find();
    }
}