package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView t1=(TextView) findViewById(R.id.rname);
        TextView t2=(TextView) findViewById(R.id.rroll);
        TextView t3=(TextView) findViewById(R.id.rdept);

        Intent intent=getIntent();
        t1.setText(intent.getStringExtra("name"));
        t2.setText(intent.getStringExtra("usn"));
        t3.setText(intent.getStringExtra("dept"));
    }
}