package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView contactlist;
Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd=(Button)findViewById(R.id.btnadd);
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
btnadd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent addintent=new Intent(MainActivity.this,AddContact .class);
        startActivity(addintent);
    }
});
contactlist.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent updateintent= new Intent(MainActivity.this,Update.class);
        startActivity(updateintent);
    }
});
    }

}
