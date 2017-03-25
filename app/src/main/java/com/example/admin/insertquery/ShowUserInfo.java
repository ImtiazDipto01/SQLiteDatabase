package com.example.admin.insertquery;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Admin on 3/24/2017.
 */

public class ShowUserInfo extends AppCompatActivity {


    ListView listView ;
    DatabaseHelper databaseHelper ;
    SQLiteDatabase sqLiteDatabase ;
    ShowUserInfoAdapter showUserInfoAdapter ;
    Cursor cursor ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        listView = (ListView) findViewById(R.id.show_user_info_view) ;
        databaseHelper = new DatabaseHelper(this) ;
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        showUserInfoAdapter = new ShowUserInfoAdapter(getApplicationContext(), R.layout.user_info_row) ;
        listView.setAdapter(showUserInfoAdapter);
        cursor = databaseHelper.getData(sqLiteDatabase) ;
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){

                String name = cursor.getString(0) ;
                String pass = cursor.getString(1) ;

                DataProvider dataProvider = new DataProvider(name, pass) ;
                showUserInfoAdapter.add(dataProvider);
            }
        }
    }
}
