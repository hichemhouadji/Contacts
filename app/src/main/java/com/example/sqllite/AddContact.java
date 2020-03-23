package com.example.sqllite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URI;

public class AddContact extends AppCompatActivity {
EditText editname,editphone;
Button btnconfirm;
DBContact db;
ImageButton pickcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        editname=(EditText)findViewById(R.id.edit_name1);
        editphone=(EditText)findViewById(R.id. edit_phone1);
        btnconfirm=(Button)findViewById(R.id.btnadd1);
        pickcontact=(ImageButton)findViewById(R.id.pickcontact);

        db=new DBContact(this);

    btnconfirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=editname.getText().toString();
            int phone=Integer.parseInt( editphone.getText().toString());

            Contact contact=new Contact( name, phone);
            db.Addcontact(contact);
            Toast.makeText(AddContact.this,"contact added",Toast.LENGTH_LONG).show();
        }
    });

    }
public void openGallery(View view){
    Intent intentcontact=new Intent(Intent.ACTION_GET_CONTENT);
    intentcontact.setType("image/*");
    startActivityForResult(intentcontact,100);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK&& requestCode==100){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap decodestream= BitmapFactory.decodeStream(inputStream);
                pickcontact.setImageBitmap(decodestream);
            }catch (Exception ex){
                Log.e("ex",ex.getMessage());
            }


        }
    }
}
