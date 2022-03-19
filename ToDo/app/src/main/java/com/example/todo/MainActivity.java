package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_todo;
    Button btn_add;
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_todo = findViewById(R.id.edt_to_do);
        btn_add = findViewById(R.id.btn_add);
        listView = findViewById(R.id.listview);
        list = new ArrayList<>();



        myAdapter = new MyAdapter(this,R.layout.list_view,list);
        listView.setAdapter(myAdapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = edt_todo.getText().toString();
                if (!TextUtils.isEmpty(value)){
                    list.add(value);
                    edt_todo.setText("");
                    myAdapter.notifyDataSetChanged();
                }else{
                    edt_todo.setError("Required");
                }
            }
        });

    }
}