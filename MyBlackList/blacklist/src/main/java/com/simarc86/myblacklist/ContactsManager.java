package com.simarc86.myblacklist;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by marctamaritromero on 12/06/14.
 */

public class ContactsManager {

    private static ArrayList<Contact> all_contacts;
    private static Context context;

    public ContactsManager(Context ctx){
        context = ctx;
        all_contacts = new ArrayList<Contact>();
    }

    public void loadContacts(){
        String name = "";
        String number = "";
        String name_old = "";


        Cursor phones = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            Contact contact = new Contact();

            name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            contact.setName(name);
            contact.setNumber(number);

            if (!number.isEmpty() && !name.equals(name_old))
                all_contacts.add(contact);

            name_old = name;
        }
        phones.close();
    }

    public ArrayList<String> getNameList (){
        ArrayList<String> namesList = new ArrayList<String>();


        Iterator<Contact> it = all_contacts.iterator();
        while(it.hasNext()){
            Contact contact = it.next();
            namesList.add(contact.getName());
        }

        Collections.sort(namesList.subList(1, namesList.size()));

        return namesList;
    }

    public ArrayList<Contact> getAll_contacts() {
        return all_contacts;
    }

    public void setAll_contacts(ArrayList<Contact> all_contacts) {
        this.all_contacts = all_contacts;
    }

    public int contactsCount(){
        return all_contacts.size();
    }
}

