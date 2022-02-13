package com.example.speedpayprojet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class User {

    public  String fullname, age, email;
    public int money;






    public User(){


    }

    public User(String fullname, String age, String email,int money) {
        this.fullname = fullname;
        this.age = age;
        this.email = email;
        this.money=money;


    }
}
