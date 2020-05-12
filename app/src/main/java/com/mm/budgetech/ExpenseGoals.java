package com.mm.budgetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mm.budgetech.model.UserSavingData;
import com.mm.budgetech.views.budgeting.Expense_Savings;

public class ExpenseGoals extends AppCompatActivity implements View.OnClickListener {
    ImageView imView1,imView2,imView3,imView4,imView5,imView6,imView7,imView8,imView9;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    String get_amount,get_duration;
    UserSavingData userSavingData;
    ProgressBar progressBar;
    int i=0;
    FloatingActionButton fab;
    EditText addamount,addduration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_goals);
        initialize_fields();
        get_Textfield_Values();

    }
    @Override
    public void onClick(View v) {
        if(i==0)
        {
            if(imView1.isPressed())
            {
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView1.startAnimation(animation);
                i=1;
                return;
            }
            else if(imView2.isPressed())
            {
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView2.startAnimation(animation);
                i=1;
                return;
            }
            else if(imView3.isPressed())
            {
                Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView3.startAnimation(animation);
                i=1;
                return;

            }
            else if(imView4.isPressed())
            {
                Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView4.startAnimation(animation);
                i=1;
                return;

            }
            else if(imView5.isPressed())
            {
                Toast.makeText(getApplicationContext(),s5,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView5.startAnimation(animation);
                i=1;
                return;

            }
            else if(imView6.isPressed())
            {
                Toast.makeText(getApplicationContext(),s6,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView6.startAnimation(animation);
                i=1;
                return;

            }
            else if(imView7.isPressed())
            {
                Toast.makeText(getApplicationContext(),s7,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView7.startAnimation(animation);
                i=1;
                return;

            }
            else if(imView8.isPressed())
            {
                Toast.makeText(getApplicationContext(),s8,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView8.startAnimation(animation);
                i=1;
                return;

            }
            else if(imView9.isPressed())
            {
                Toast.makeText(getApplicationContext(),s9,Toast.LENGTH_LONG).show();
                Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade);
                imView9.startAnimation(animation);
                i=1;
                return;

            }

        }else {
            Toast.makeText(getApplicationContext(),"You cannot press the button",Toast.LENGTH_LONG).show();
        }

    }

    //Initializing the fields
    public void initialize_fields(){
        addamount=(EditText)findViewById(R.id.addamount);
        addduration=(EditText)findViewById(R.id.add_duration);

        fab=(FloatingActionButton)findViewById(R.id.floating2);

        imView1=findViewById(R.id.personal_id);
        imView2=findViewById(R.id.food_id);
        imView3=findViewById(R.id.medicine_id);
        imView4=findViewById(R.id.housing_id);
        imView5=findViewById(R.id.utilities_bills_id);
        imView6=findViewById(R.id.transport_id);
        imView7=findViewById(R.id.debt_payment_id);
        imView8=findViewById(R.id.savings_id);
        imView9=findViewById(R.id.investing_id);

        imView1.setOnClickListener(this);
        imView2.setOnClickListener(this);
        imView3.setOnClickListener(this);
        imView4.setOnClickListener(this);
        imView5.setOnClickListener(this);
        imView6.setOnClickListener(this);
        imView7.setOnClickListener(this);
        imView8.setOnClickListener(this);
        imView9.setOnClickListener(this);

        t1=(TextView)findViewById(R.id.personal_text);
        t2=(TextView)findViewById(R.id.food_text);
        t3=(TextView)findViewById(R.id.medicine_text);
        t4=(TextView)findViewById(R.id.housing_text);
        t5=(TextView)findViewById(R.id.utilities_bills_text);
        t6=(TextView)findViewById(R.id.transport_text);
        t7=(TextView)findViewById(R.id.debt_payment_text);
        t8=(TextView)findViewById(R.id.savings_text);
        t9=(TextView)findViewById(R.id.investing_text);

        s1=t1.getText().toString();
        s2=t2.getText().toString();
        s3=t3.getText().toString();
        s4=t4.getText().toString();
        s5=t5.getText().toString();
        s6=t6.getText().toString();
        s7=t7.getText().toString();
        s8=t8.getText().toString();
        s9=t9.getText().toString();
    }

    //geting values from text fields
    public void settingModelClassValue()
    {
        get_amount=addamount.getText().toString();
        get_duration=addduration.getText().toString();
        UserSavingData userSavingData=new UserSavingData(get_amount,get_duration,progressBar);
        userSavingData.setAm(get_amount);
        userSavingData.setDur(get_duration);
        userSavingData.setProgressBar(progressBar);
        Intent intent=new Intent(getApplicationContext(), Expense_Savings.class);
        intent.putExtra("myClass",userSavingData);
        startActivity(intent);

    }

    public void get_Textfield_Values(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                check();


            }
        });
    }

    public void check(){
        if(addamount.length()==0 )
        {
            addamount.setError("Amount field is empty");
        }
        if(addduration.length()==0 )
        {
            addduration.setError("Duration Field is empty");
        }
        if(addamount.length()!=0 & addduration.length()!=0 )
        {

            settingModelClassValue();

        }
    }
}
