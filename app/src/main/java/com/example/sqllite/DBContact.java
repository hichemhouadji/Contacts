package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBContact extends SQLiteOpenHelper {
    final private static String DB_name = "MyphoneDb";
    final private static int Db_version = 1;
    final private static String KEY_id = "id";
    final private static String KEY_name = "name";
    final private static String KEY_phone = "phone";
    final private static String KEY_img = "image";
    final private static String TABLE_contacts = "contacts";


    public DBContact(@Nullable Context context) {
        super(context, DB_name, null, Db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "create table " + TABLE_contacts + "(" + KEY_id + " integer  primary key," + KEY_name + " varchar(30)," + KEY_phone + " integer,"+KEY_img+" blob)";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delet_query = "DROP TABLE IF EXISTS " + TABLE_contacts + "";
        db.execSQL(delet_query);
        onCreate(db);
    }

    public void Addcontact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_name, contact.getName());
        values.put(KEY_phone, contact.getPhone());




        db.insert(TABLE_contacts, null, values);
    }

    public ArrayList<Contact> getAllContact() {

        ArrayList<Contact> contacts = new ArrayList<>();
        String selectquery = "select * from " + TABLE_contacts ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectquery, null);
        if (cursor.moveToFirst()) {
            do {
                int id =cursor.getInt(cursor.getColumnIndex(KEY_id));
                String name = cursor.getString(cursor.getColumnIndex(KEY_name));
                int phone = cursor.getInt(cursor.getColumnIndex(KEY_phone));
                byte[] img=cursor.getBlob(cursor.getColumnIndex(KEY_img));
                Contact contact=new Contact(id, name, phone,img);

                contacts.add(contact);

            } while (cursor.moveToNext());
        }
        return contacts;
    }

    //methode one to get contact by id
public Contact getContactById(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        String selectquery="select * from "+TABLE_contacts+" where id = "+id;
        Cursor cursor=db.rawQuery(selectquery,null);

    Contact contact=null;
    if (cursor.moveToFirst()) {
        int idcontact =cursor.getInt(cursor.getColumnIndex(KEY_id));
        String name =cursor.getString(cursor.getColumnIndex(KEY_name));
        int phone =cursor.getInt(cursor.getColumnIndex(KEY_phone));
        byte[] img=cursor.getBlob(cursor.getColumnIndex(KEY_img));


        contact = new Contact(idcontact,name, phone,img);
    }
    return contact;
}

public void updatecontact(Contact contact){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_name,contact.getName());
        values.put(KEY_phone,contact.getPhone());

    db.update(TABLE_contacts,values,"id=?",new String[]{String.valueOf(contact.getId())});
}
public  void  deletContact(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_contacts,"id=?",new String[]{String.valueOf(id)});
}


}
