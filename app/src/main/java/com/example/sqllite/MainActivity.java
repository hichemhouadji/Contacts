package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView contactlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
contactlist=(ListView) findViewById(R.id.contact);
        ArrayList<Contact> contacts= new ArrayList<>();
        contacts.add(new Contact("contact1",113123565));
        contacts.add(new Contact("contact1",113123567));
        contacts.add(new Contact("contact1",113123568));
        contacts.add(new Contact("contact1",113123569));
        contacts.add(new Contact("contact1",113123561));
        contacts.add(new Contact("contact1",113123565));
        contacts.add(new Contact("contact1",113123560));
        contacts.add(new Contact("contact1",113123568));

ContactAdapter contactAdapter=new ContactAdapter(this,R.layout.item_list,contacts);
contactlist.setAdapter(contactAdapter);
    }
}
