package com.simarc86.myblacklist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marctamaritromero on 12/06/14.
 */
public class ContactListActivity extends Activity{

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_layout);

        ArrayList<String> list_name = (ArrayList<String>) getIntent().getSerializableExtra("contacts_information");

        listView = (ListView) findViewById(R.id.contact_list);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = list_name;


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        listView.setAdapter(arrayAdapter);

    }

}
