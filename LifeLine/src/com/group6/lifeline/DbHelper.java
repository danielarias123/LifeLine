package com.group6.lifeline;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "lifeline.db";
    private static final int DATABASE_VERSION = 6;
    public static final String LOGIN_TABLE_NAME = "login";
    public static final String ROLE_COL = "email";
    public static final String USERNAME_COL = "username";
    public static final String USER_ID = "_id";
    public static final String USER_PASS = "password";
    public static final String USER_WEIGHT = "weight";
    public static final String USER_HEIGHT = "height";
    public static final String INS_NUM = "insNum";
    public static final String USER_ALLER = "allergies";
    public static final String USER_DOB = "DOB";
    public static final String USER_CONCERNS = "concerns";
    public static final String USER_BLOOD = "blood";
    public static final String NEXT_APP = "nextApp";
    
    
    private static final String LIFELINE_TABLE_CREATE =
                    "CREATE TABLE IF NOT EXISTS " + LOGIN_TABLE_NAME + "(" +USER_ID
                   +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    USERNAME_COL+ " TEXT NOT NULL, "+USER_PASS+ " TEXT NOT NULL, "+ROLE_COL+ " TEXT NOT NULL," +INS_NUM+" INTEGER,"+USER_WEIGHT+ " INTEGER, "+USER_HEIGHT+ " INTEGER, "+USER_DOB+" TEXT, "+USER_ALLER+" TEXT,"+USER_CONCERNS+" TEXT, " + USER_BLOOD+" TEXT,"+NEXT_APP+" TEXT);";
    private static final String LIFELINE_DB_ADMIN = "INSERT INTO "+LOGIN_TABLE_NAME+" values(1, admin, password, admin@gmail.com);";
    
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
    
    public List<String> getAllPatients(){
        List<String> patients = new ArrayList<String>();
         
        // Select All Query
        String selectQuery = "SELECT  * FROM " + LOGIN_TABLE_NAME;
      
        SQLiteDatabase db = this.getReadableDatabase();
        
        
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                patients.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
         
        // closing connection
        cursor.close();
        db.close();
         
        
        return patients;
    }
    
    public String getName(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER, USER_CONCERNS, USER_BLOOD, NEXT_APP};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(iname)+"\n";
    	}
    		
    	mydb.close();
    	c.close();
        return result;
    }
    
    public String getDob(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(idob)+"\n";
    	}
    	mydb.close();
    	c.close();
        return result;
    }
    
    public String getHeight(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(iheight)+"\n";
    	}
        mydb.close();
    	c.close();
    	return result;
    }
    
    public String getWeight(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(iweight)+"\n";
    	}
    	mydb.close();
    	c.close();
        return result;
    }
    
    public String getIns(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(iins)+"\n";
    	}
    	mydb.close();
    	c.close();
    	return result;
    }
    
    public String getAller(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result ="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(ialler)+"\n";
    	}
    	mydb.close();
    	c.close();
        return result;
    }
    
    public String getConcerns(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER, USER_CONCERNS, USER_BLOOD, NEXT_APP};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(iconc)+"\n";
    	}
    		
    	mydb.close();
    	c.close();
        return result;
    }
    
    
    public String getBlood(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER, USER_CONCERNS, USER_BLOOD, NEXT_APP};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(iblood)+"\n";
    	}
    		
    	mydb.close();
    	c.close();
        return result;
    }
    
    public String getNextApp(String patient){
    	SQLiteDatabase mydb = this.getWritableDatabase();
    	String[] columns = new String[]{ USERNAME_COL,INS_NUM, USER_DOB,USER_HEIGHT, USER_WEIGHT, USER_ALLER, USER_CONCERNS, USER_BLOOD, NEXT_APP};
    	String clause = USERNAME_COL +" = '"+patient+"'";
    	Cursor c = mydb.query(LOGIN_TABLE_NAME, columns,clause, null, null, null, null, null);
    	
    	String result="";
    	
    	
    	int irow = c.getColumnIndex(USER_ID);
    	int iname = c.getColumnIndex(USERNAME_COL);
    	int idob = c.getColumnIndex(USER_DOB);
    	int iheight = c.getColumnIndex(USER_HEIGHT);
    	int iweight = c.getColumnIndex(USER_WEIGHT);
    	int iins = c.getColumnIndex(INS_NUM);
    	int ialler = c.getColumnIndex(USER_ALLER);
    	int iconc = c.getColumnIndex(USER_CONCERNS);
    	int iblood = c.getColumnIndex(USER_BLOOD);
    	int inextapp = c.getColumnIndex(NEXT_APP);
    	
    	
    	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
    		result = c.getString(inextapp)+"\n";
    	}
    		
    	mydb.close();
    	c.close();
        return result;
    }
    
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	
    	Log.w(DbHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
    	db.execSQL("DROP TABLE IF EXISTS "+ LOGIN_TABLE_NAME);
    	onCreate(db);
            

    }
    
    

}
