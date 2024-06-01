package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1=(EditText) findViewById(R.id.name);
        EditText e2=(EditText) findViewById(R.id.usn);
        Spinner e3=(Spinner) findViewById(R.id.dept);
        Button b1=(Button) findViewById(R.id.button);
        String arr[]={"CSE","ECE","EEE","ME"};
        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item,arr);
        e3.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String usn=e2.getText().toString();
                String dept=e3.getSelectedItem().toString();

                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",name);
                intent.putExtra("usn",usn);
                intent.putExtra("dept",dept);
                startActivity(intent);
            }
        });

    }
}