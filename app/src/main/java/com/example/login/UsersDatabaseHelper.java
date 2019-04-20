package com.example.login;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UsersDatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String TAG = "UsersDatabaseHelper";
    private static final String TABLE_NAME = "users";
    private static final String ID = "User_ID";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String POSTAL_CODE = "postal_code";


    public UsersDatabaseHelper(Context context){
        super(context,TABLE_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //create USERS database table
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USERNAME + " TEXT, " + PASSWORD + " TEXT," + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," +
                EMAIL + " TEXT, " + PHONE + " TEXT, " + ADDRESS + " TEXT, " + CITY + " TEXT, " +
                STATE + " TEXT ," + POSTAL_CODE + " TEXT" + ")";
        db.execSQL(createTable);

        //create LOCATION database table
        createTable = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USERNAME + " TEXT, " + PASSWORD + " TEXT," + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," +
                EMAIL + " TEXT, " + PHONE + " TEXT, " + ADDRESS + " TEXT, " + CITY + " TEXT, " +
                STATE + " TEXT ," + POSTAL_CODE + " TEXT" + ")";
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
