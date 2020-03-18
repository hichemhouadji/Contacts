package com.example.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Context context;
     int resource;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
    this.context=context;
    this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView tvname= (TextView) convertView.findViewById(R.id.tvname);
        TextView tvphone= (TextView) convertView.findViewById(R.id.tvphone);
        Contact currentcontact=getItem(position);
        tvname.setText(currentcontact.getName());
        tvphone.setText(String.valueOf(currentcontact.getPhone()));
        return  convertView;


    }
}


