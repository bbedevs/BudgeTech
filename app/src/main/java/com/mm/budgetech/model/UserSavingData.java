package com.mm.budgetech.model;

import android.widget.ProgressBar;

import java.io.Serializable;

public class UserSavingData implements Serializable {
    String am;
    String dur;
    ProgressBar progressBar;


public UserSavingData(String amount,String duration, ProgressBar progressBar)
{
    this.am=amount;
    this.dur=duration;
    this.progressBar=progressBar;
}

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public String getAm() {
        return am;
    }

    public String getDur() {
        return dur;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }
}
