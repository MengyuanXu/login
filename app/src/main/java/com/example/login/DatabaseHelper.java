package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "users";
    private static final String COL1 = "ID";
    private static final String COL2 = "username";
    private static final String COL3 = "password";



    public DatabaseHelper (Context context){
        super(context,TABLE_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL1 +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addUser(String sql){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.execSQL(sql);
            return true;
        }
        catch (SQLException s){
            Log.e(TAG, s.getMessage());
            return false;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
