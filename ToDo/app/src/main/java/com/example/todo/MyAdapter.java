package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> list;
    public MyAdapter(Context context, int textViewResourceId, ArrayList<String> list) {
        super(context, textViewResourceId, list);
        this.context = context;
        this.list = list;
    }
    private class ViewHolder {
        TextView name;
        CheckBox check;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;


        if (convertView == null) {
            LayoutInflater view = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
            convertView = view.inflate(R.layout.list_view, null);

            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.tx_name);
            holder.check = (CheckBox) convertView.findViewById(R.id.check);
            convertView.setTag(holder);


        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.name.setText(list.get(position));
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(list.get(position));
                notifyDataSetChanged();
            }
        });

        return convertView;

    }
}
