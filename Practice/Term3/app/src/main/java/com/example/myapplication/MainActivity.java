package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Rollno,Name,Marks;

    Button insert,delete,update,view,viewall;

    SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rollno = (EditText) findViewById(R.id.rollno);
        Name = (EditText) findViewById(R.id.name);
        Marks = (EditText) findViewById(R.id.marks);

        insert = (Button) findViewById(R.id.insert);
        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);
        view = (Button) findViewById(R.id.view);
        viewall = (Button) findViewById(R.id.viewall);

        db = openOrCreateDatabase("Studentdb", Context.MODE_PRIVATE,null);
        db.execSQL("Create Table IF NOT EXISTS student(rollno VARCHAR(100),name VARCHAR(100),marks VARCHAR(100))");

        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        view.setOnClickListener(this);
        viewall.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == insert) {

            String r = Rollno.getText().toString().trim();
            String n = Name.getText().toString().trim();
            String m = Marks.getText().toString().trim();

            if (r.length() == 0 || n.length() == 0 || m.length() == 0) {
                showMessage("Error", "Enter Fields");
                return;
            }

            db.execSQL("INSERT INTO student VALUES('"+r+"','"+n+"','"+m+"')");
            showMessage("Success", "Inserted");
            clearTxt();

        }

        if(v == delete)
        {
            String r = Rollno.getText().toString().trim();
            if(r.length()==0)
            {
                showMessage("Error","Enter Rollno");
                clearTxt();
                return;
            }

            else{
                Cursor c = db.rawQuery("SELECT * from student where rollno = '"+r+"'",null);
                if(c.moveToFirst())
                {
                    db.execSQL("DELETE from student where rollno = '"+r+"'");
                    showMessage("Success","Deleted");
                }

                else {
                    showMessage("Error","Rollno invalid");
                    clearTxt();
                    return;
                }
            }

        }

        if(v == update)
        {

            String r = Rollno.getText().toString().trim();
            String n = Name.getText().toString().trim();
            String m = Marks.getText().toString().trim();


            if(Rollno.getText().toString().trim().length()==0)
            {
                showMessage("Error","Enter Rollno");
                return;
            }

            else{
                Cursor c = db.rawQuery("SELECT * from student where rollno = '"+r+"'",null);
                if(c.moveToFirst())
                {
                    db.execSQL("UPDATE student set name='"+n+"',marks='"+m+"' where rollno = '"+r+"'");
                    showMessage("Success","Deleted");
                    clearTxt();
                }

                else {
                    showMessage("Error","Rollno invalid");
                    clearTxt();
                }
            }

        }

        if(v == view)
        {

            String r = Rollno.getText().toString().trim();
            String n = Name.getText().toString().trim();
            String m = Marks.getText().toString().trim();

            if(Rollno.getText().toString().trim().length()==0)
            {
                showMessage("Error","Enter Rollno");
                return;
            }

            else {
                Cursor c = db.rawQuery("SELECT * from student where rollno ='"+r+"'",null);

                if(c.moveToFirst())
                {

                    showMessage("Data",r+"\n"+n+"\n"+m);
                    clearTxt();
                }

                else {
                    showMessage("Error", "Rollno invalid");
                    clearTxt();
                }
            }
        }

        if(v == viewall){

            Cursor c = db.rawQuery("SELECT * from student",null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No Fields");
                return;
            }

            StringBuffer buffer = new StringBuffer();

            while(c.moveToNext())
            {
                buffer.append(c.getString(0)+"\t");
                buffer.append(c.getString(1)+"\t");
                buffer.append(c.getString(2)+"\t");

            }
            showMessage("Student Details",buffer.toString());

        }
    }

    public void clearTxt(){

        Rollno.setText("");
        Name.setText("");
        Marks.setText("");
        Rollno.requestFocus();

    }

    private void showMessage(String title,String msg) {

        Builder build = new Builder(this);
        build.setCancelable(true);
        build.setTitle(title);
        build.setMessage(msg);
        build.show();
    }
}