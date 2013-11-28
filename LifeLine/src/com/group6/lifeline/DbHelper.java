package com.group6.lifeline;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class DbHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "lifeline.db";
    private static final int DATABASE_VERSION = 1;
    public static final String LOGIN_TABLE_NAME = "login";
    private static final String LIFELINE_TABLE_CREATE =
                    "CREATE TABLE " + LOGIN_TABLE_NAME + "(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "username TEXT NOT NULL, password TEXT NOT NULL, email TEXT NOT NULL);";
    private static final String LIFELINE_DB_ADMIN = "INSERT INTO "+LOGIN_TABLE_NAME+"values(1, admin, password, admin@gmail.com);";
    
    public DbHelper(Context context) {
        
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("In constructor");
        
    }

    /* (non-Javadoc)
     * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        
        try{
                //Create Database
                db.execSQL(LIFELINE_TABLE_CREATE);
                
                //create admin account
                db.execSQL(LIFELINE_DB_ADMIN);
                System.out.println("In onCreate");
        }catch(Exception e){
                e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
            

    }

}
