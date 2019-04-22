package com.example.login;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LocationDatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String TAG = "UsersDatabaseHelper";
    private static final String TABLE_NAME = "location";
    private static final String ID = "location_id";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String ROOM = "room";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String POSTAL_CODE = "postal_code";


    public LocationDatabaseHelper(Context context){
        super(context,TABLE_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //create USERS database table
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LATITUDE + " TEXT, " + LONGITUDE + " TEXT," + ROOM + " TEXT," + ADDRESS + " TEXT, " +
                CITY + " TEXT, " + STATE + " TEXT ," + POSTAL_CODE + " TEXT" + ")";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addLocation(String sql){
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
