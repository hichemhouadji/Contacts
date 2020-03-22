package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {
EditText editname,editphone;
Button btnconfirm;
DBContact db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        editname=(EditText)findViewById(R.id.edit_name1);
        editphone=(EditText)findViewById(R.id. edit_phone1);
        btnconfirm=(Button)findViewById(R.id.btnadd1);

        db=new DBContact(this);

    btnconfirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=editname.getText().toString();
            int phone=Integer.parseInt( editphone.getText().toString());
            int id=Integer.parseInt( editphone.getText().toString());
            Contact contact=new Contact(id,name,phone);
            db.Addcontact(contact);
            Toast.makeText(AddContact.this,"contact added",Toast.LENGTH_LONG).show();
        }
    });

    }

}
