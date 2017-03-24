package com.example.admin.insertquery;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.uid) ;
        password = (EditText) findViewById(R.id.pass) ;
    }

    public void adduser(View view){
        String user = username.getText().toString() ;
        String pass = password.getText().toString() ;

        DatabaseHelper databaseHelper = new DatabaseHelper(this) ;
        SQLiteDatabase db = databaseHelper.getWritableDatabase() ;
        databaseHelper.addData(user, pass, db);
        databaseHelper.close();
    }
}
