package com.mm.budgetech.model;

public class User {

    public String email, username, phonenum, bankname, location, loan, savings;
    public String uid;
    public User(String id)
    {
        uid = id;
    }

   public void userInformation(String email, String phonenum, String bankname, String location, String loan,  String savinngs )
    {
        email = this.email;
        phonenum = this.phonenum;
        bankname = this.bankname;
        location = this.location;
        loan = this.loan;
        savinngs = this.savings;
    }

}
