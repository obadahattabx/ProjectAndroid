package com.hattab.testproject;

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
    int resources;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(resources,parent,false);
        TextView name=convertView.findViewById(R.id.name);
        TextView phone= convertView.findViewById(R.id.phone);
        Contact current=getItem(position);
        name.setText(current.getName().toString());
        phone.setText(String.valueOf(current.getPhone()));
        return convertView;
    }
}
