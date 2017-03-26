package com.example.admin.insertquery;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText username, password ;
    Button btn_showuser, btn_search_user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.uid) ;
        password = (EditText) findViewById(R.id.pass) ;


        btn_showuser = (Button) findViewById(R.id.btn_show_user_info) ;
        btn_search_user = (Button) findViewById(R.id.btn_3) ;

        btn_search_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent secondintent = new Intent(getApplicationContext(), SearchResult.class) ;
                startActivity(secondintent);
            }
        });

        btn_showuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ShowUserInfo.class) ;
                startActivity(intent);
            }
        });
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
