package com.example.sqllite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Update extends AppCompatActivity {
DBContact db;
EditText editname,editphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        int id=getIntent().getIntExtra("id",0);
        db=new DBContact(this);


        Contact contact=db.getContactById(id);
        editname=(EditText)findViewById(R.id.edit_name);
        editphone=(EditText)findViewById(R.id.edit_phone);
        editphone.setText(String.valueOf(contact.getPhone()));
        editname.setText(contact.getName());
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
               /*

                */
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
