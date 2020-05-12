package com.mm.budgetech.views.budgeting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import android.view.View;
import android.widget.Button;
import com.google.gson.reflect.TypeToken;
import com.mm.budgetech.ExpenseGoals;
import com.mm.budgetech.R;
import com.mm.budgetech.model.UserSavingData;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class Expense_Savings extends AppCompatActivity {
    ArrayList<UserSavingData> value=new ArrayList<>();
    RecyclerView recyclerView;
    AdapterClass adapterClass;
    String text1,text2;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense__savings);
        load_data_into_Array();
        saving_dataInto_sharedpref();
        add_button=(Button)findViewById(R.id.Add_new_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ExpenseGoals.class);
                startActivity(i);
            }
        });
    }

    public void load_data_into_Array()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("mode",Context.MODE_PRIVATE);
        Gson gson=new Gson();
        String json=sharedPreferences.getString("values",null);
        Type type=new TypeToken<ArrayList<UserSavingData>>(){}.getType();
        value=gson.fromJson(json,type);
        if(value==null){
            value=new ArrayList<>();
        }
    }

    public void saving_dataInto_sharedpref(){

        Intent i=getIntent();
        UserSavingData userSavingData=(UserSavingData)i.getSerializableExtra("myClass");
        value.add(userSavingData);
        SharedPreferences sharedPreferences=getSharedPreferences("mode", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Gson gson=new Gson();
        String json=gson.toJson(value);
        editor.putString("values",json);
        editor.apply();

        //function calling
        calling_to_recyclerview();

    }

    public void calling_to_recyclerview(){
        recyclerView= findViewById(R.id.card_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterClass= new AdapterClass(this,value);
        recyclerView.setAdapter(adapterClass);
    }
}
