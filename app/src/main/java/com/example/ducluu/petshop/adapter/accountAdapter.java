package com.example.ducluu.petshop.adapter;

import android.content.Context;

import com.example.ducluu.petshop.model.account;

import java.util.ArrayList;

public class accountAdapter {
    Context context;
    ArrayList<account> accountArrayList;

    public accountAdapter(Context context, ArrayList<account> accountArrayList) {
        this.context = context;
        this.accountArrayList = accountArrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(ArrayList<account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }
}
