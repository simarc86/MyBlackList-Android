package com.simarc86.myblacklist;

import android.content.Context;

import java.io.Serializable;

/**
 * Created by marctamaritromero on 12/06/14.
 */
public class Contact implements Serializable{

    private String name;
    private String number;
    private String mail;
    private float owed;
    private float borrowed;

    public Contact(){
        this("","");
    }
    public Contact(String na, String nu){
        name = na;
        number = nu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public float getOwed() {
        return owed;
    }

    public void setOwed(float owed) {
        this.owed = owed;
    }

    public float getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(float borrowed) {
        this.borrowed = borrowed;
    }
}
