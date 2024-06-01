package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float font=30;
    int ch=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1=(TextView) findViewById(R.id.res);
        Button b1=(Button) findViewById(R.id.button);
        Button b2=(Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(font>=50){
                    font=30;
                }
                font+=5;
                t1.setTextSize(font);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch>4){
                    ch=1;
                }
                switch (ch){
                    case 1:t1.setTextColor(Color.RED);
                            ch++;
                            break;
                    case 2:t1.setTextColor(Color.GREEN);
                        ch++;
                        break;
                    case 3:t1.setTextColor(Color.BLUE);
                        ch++;
                        break;
                    case 4:t1.setTextColor(Color.BLACK);
                        ch++;
                        break;

                }
            }
        });
    }
}