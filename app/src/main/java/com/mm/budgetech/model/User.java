package com.mm.budgetech.model;

public class User {

    String email, phonemum, bankname, location, loan, savings;
    String uid;
    User(String id)
    {
        uid = id;
    }

    void userInformation(String email, String phonenum, String bankname, String location, String loan,  String savinngs )
    {
        email = this.email;
        phonenum = this.phonemum;
        bankname = this.bankname;
        location = this.location;
        loan = this.loan;
        savinngs = this.savings;
    }

}
