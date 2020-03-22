package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView contactlist;
    Button btnadd;
    DBContact db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = (Button) findViewById(R.id.btnadd);
        db = new DBContact(this);
        contactlist = (ListView) findViewById(R.id.contact);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addintent = new Intent(MainActivity.this, AddContact.class);
                startActivity(addintent);
            }
        });
        contactlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selected_contact = (Contact) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, Update.class);
                intent.putExtra("id",selected_contact.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Contact> contacts = db.getAllContact();
        ContactAdapter contactAdapter = new ContactAdapter(this, R.layout.item_list, contacts);
        contactlist.setAdapter(contactAdapter);
    }
}
