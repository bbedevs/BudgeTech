package com.mm.budgetech.model;

public class User {

    public String email, username, phonenum, bankname, location, income, currentBalance , savings;
    public String uid;
    public User(String id)
    {
        uid = id;
    }
    public User() {}

   public void userInformation(String email, String phonenum, String bankname, String location, String income, String currentBalance, String savinngs )
    {
        email = this.email;
        phonenum = this.phonenum;
        bankname = this.bankname;
        location = this.location;
        income = this.income;
        currentBalance = this.currentBalance;
        savinngs = this.savings;
    }

}
