package com.example.admin.insertquery;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase" ;
    private static final int DATABASE_VERSION = 1 ;
    /*private static final String TABLE_NAME = "mytable" ;
    private static final String UID =  "_id" ;
    private static final String NAME = "Name" ;
    private static final String PASSWORD = "Password" ;*/
    private static final String CREATE_TABLE = "CREATE TABLE "+ColumnName.TABLE_NAME+"("
            +ColumnName.UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ColumnName.NAME+" VARCHAR(255), "
            +ColumnName.PASSWORD+" VARCHAR(255));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ColumnName.TABLE_NAME ;


    Context context ;

    public DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION) ;
        this.context = context ;
        Message.message(context, "constructor called!");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            Message.message(context, "OnCreate called!");
        }
        catch (SQLException e){
            Message.message(context, ""+ e);
        }
    }

    public void addData(String name, String password, SQLiteDatabase db){

        try{
            ContentValues contentValues = new ContentValues() ;
            contentValues.put(ColumnName.NAME, name) ;
            contentValues.put(ColumnName.PASSWORD, password) ;
            db.insert(ColumnName.TABLE_NAME, null, contentValues);
            Message.message(context, "data added");
        }
        catch(SQLiteException e){
            Message.message(context, ""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Message.message(context, "OnUpgarde called!");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        catch (SQLException e){
            Message.message(context, ""+ e);
        }

    }
}
