package com.example.admin.insertquery;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Admin on 3/25/2017.
 */

public class SearchResult extends AppCompatActivity {

    TextView search_username_result, search_password_result ;
    EditText search_user ;
    Button search ;
    DatabaseHelper databaseHelper ;
    SQLiteDatabase sqLiteDatabase ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_result);

        search_password_result = (TextView) findViewById(R.id.search_pass) ;
        search_username_result = (TextView) findViewById(R.id.search_username) ;
        search_user = (EditText) findViewById(R.id.editsearchbar) ;
        search = (Button) findViewById(R.id.btn_search) ;
        search_username_result.setVisibility(View.GONE);
        search_password_result.setVisibility(View.GONE);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = search_user.getText().toString() ;
                databaseHelper = new DatabaseHelper(getApplicationContext()) ;
                sqLiteDatabase = databaseHelper.getReadableDatabase() ;
                Cursor cursor = databaseHelper.getuserinfo(name, sqLiteDatabase) ;
                if(cursor.moveToFirst()){
                    int index1, index2 ;
                    index1 = cursor.getColumnIndex(ColumnName.NAME) ;
                    index2 = cursor.getColumnIndex(ColumnName.PASSWORD);
                    String user_name = cursor.getString(index1) ;
                    String pass = cursor.getString(index2) ;
                    search_username_result.setText(user_name);
                    search_password_result.setText(pass);
                    search_username_result.setVisibility(View.VISIBLE);
                    search_password_result.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
