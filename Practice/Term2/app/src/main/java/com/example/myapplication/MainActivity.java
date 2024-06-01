package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);
        Button mul=(Button) findViewById(R.id.mul);
        Button div=(Button) findViewById(R.id.div);
        Button clear=(Button) findViewById(R.id.clear);

        EditText num1=(EditText) findViewById(R.id.num1);
        EditText num2=(EditText) findViewById(R.id.num2);
        TextView result=(TextView) findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a= Double.valueOf(num1.getText().toString());
                Double b= Double.valueOf(num2.getText().toString());
                Double out=a+b;
                String res=String.format("%.2f",out);
                result.setText(res);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a= Double.valueOf(num1.getText().toString());
                Double b= Double.valueOf(num2.getText().toString());
                Double out=a-b;
                String res=String.format("%.2f",out);
                result.setText(res);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a= Double.valueOf(num1.getText().toString());
                Double b= Double.valueOf(num2.getText().toString());
                Double out=a*b;
                String res=String.format("%.2f",out);
                result.setText(res);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a= Double.valueOf(num1.getText().toString());
                Double b= Double.valueOf(num2.getText().toString());
                Double out=a/b;
                String res=String.format("%.2f",out);
                result.setText(res);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                result.setText("");
            }
        });


    }
}