package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class LogInActivity extends Activity implements OnClickListener {
	
	
	Button enterProfileButton;
	EditText usernameEditText;
	EditText passwordEditText;
	EditText roleEditText;
	DbHelper mydb = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		
		enterProfileButton = (Button) findViewById(R.id.enterProfileButton);
		enterProfileButton.setOnClickListener(this);
	}
	public void onClick(View v){
		
		 usernameEditText = (EditText)findViewById(R.id.usernameEditText);
         passwordEditText = (EditText)findViewById(R.id.passwordEditText);
         roleEditText = (EditText)findViewById(R.id.roleEditText);
         
         String username = usernameEditText.getText().toString();
         String password = passwordEditText.getText().toString();
         String role = roleEditText.getText().toString();
        
         
         if(username.equals("") || username == null){
                 Toast.makeText(getApplicationContext(), "Username Empty", Toast.LENGTH_SHORT).show();
         }else if(password.equals("") || password == null){
                 Toast.makeText(getApplicationContext(), "Password Empty", Toast.LENGTH_SHORT).show();
         }else if(role.equals("") || password == null){
             Toast.makeText(getApplicationContext(), "Role Empty", Toast.LENGTH_SHORT).show();
         }else{
                 boolean validLogin = validateLogin(username, password, role, LogInActivity.this);
                 
                 if((validLogin) && (role.equals("doctor"))){
                         System.out.println("In Valid");
                         Intent i = new Intent(LogInActivity.this, WelcomeDoctorActivity.class);
                         startActivity(i);
                         finish();
                 }else if((validLogin) && (role.equals("patient"))){
                	 	 System.out.println("In Valid");
                	 	 Intent i = new Intent(LogInActivity.this, WelcomePatientActivity.class);
                	 	 startActivity(i);
                	 	 finish();
                	 
                 }else if((validLogin) && (role.equals("nurse"))){
            	 	 System.out.println("In Valid");
            	 	 Intent i = new Intent(LogInActivity.this, WelcomeNurseActivity.class);
            	 	 startActivity(i);
            	 	 finish();
                 }
         }
		
	}
	
	 @SuppressWarnings("deprecation")
	public boolean validateLogin(String username, String password, String role, Context context) {
         
         mydb = new DbHelper(context);
         SQLiteDatabase db = mydb.getReadableDatabase();
         //SELECT
         String[] columns = {"_id"};
         
         //WHERE clause
         String selection = "username=? AND password=? AND email=?";
         
         //WHERE clause arguments
         String[] selectionArgs = {username,password,role};
         
         Cursor cursor = null;
         try{
         //SELECT _id FROM login WHERE username=username AND password=password
         cursor = db.query(DbHelper.LOGIN_TABLE_NAME, columns, selection, selectionArgs, null, null, null);
         
         startManagingCursor(cursor);
         }catch(Exception e){
                 e.printStackTrace();
         }
         int numberOfRows = cursor.getCount();
         
         if(numberOfRows <= 0){
        	 Toast.makeText(getApplicationContext(), "Login Failed..\nTry Again", Toast.LENGTH_SHORT).show();
             return false;
     }
     
     db.close();
     cursor.close();
     return true;
	 }
	 @Override
	    public void onBackPressed() {
	            super.onBackPressed();
	            
	            Intent i = new Intent(LogInActivity.this, LifeLineActivity.class);
	            startActivity(i);
	            finish();
	    }
	

         
         

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

}
