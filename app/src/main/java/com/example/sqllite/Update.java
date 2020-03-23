package com.example.sqllite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
DBContact db;
EditText editname,editphone;
Button btnUpdate;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
         id=getIntent().getIntExtra("id",0);
        db=new DBContact(this);


        Contact contact=db.getContactById(id);
        editname=(EditText)findViewById(R.id.edit_name);
        editphone=(EditText)findViewById(R.id.edit_phone);
        editphone.setText(String.valueOf(contact.getPhone()));
        editname.setText(contact.getName());
        btnUpdate=(Button)findViewById(R.id.btnadd);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editname.getText().toString();
                int phone=Integer.parseInt(editphone.getText().toString());
                Contact newcontact=new Contact(name,phone);
                db.updatecontact(newcontact);
                Toast.makeText(Update.this,"contact updated with succes",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

getMenuInflater().inflate(R.menu.deletmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.itemdelet:
                showAlert();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void showAlert() {
        AlertDialog.Builder allertBuilder= new AlertDialog.Builder(this);
       allertBuilder.setTitle("confirmation")
               .setMessage("Are You Sur?").setPositiveButton("yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               //delet contact
               db.deletContact(id);
               finish();
           }
       })
               .setNegativeButton("no", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
           }
       });
        AlertDialog dialog = allertBuilder.create();
        dialog.show();
    }

}
