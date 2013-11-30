package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminWelcomeActivity extends Activity implements OnClickListener {
	
	 private Button registerButton;
     private Button cancelButton;
     private Button databaseEnterButton;
     private EditText newUnameEditText;
     private EditText newPassEditText;
     private EditText roleNewEditText;
     private DbHelper myDb = new DbHelper(AdminWelcomeActivity.this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_welcome);
		
		 registerButton = (Button)findViewById(R.id.registerButton);
         registerButton.setOnClickListener(this);
         
         cancelButton = (Button)findViewById(R.id.buttonCancel);
         cancelButton.setOnClickListener(this);
         
         databaseEnterButton=(Button)findViewById(R.id.dataBaseEnterButton);
         databaseEnterButton.setOnClickListener(this);
         
	}
	
	public void onClick(View v) {
        
        switch(v.getId()){
                
                case R.id.buttonCancel:
                        Intent i = new Intent(AdminWelcomeActivity.this, LifeLineActivity.class);
                        startActivity(i);
                        finish();
                        break;
                        
                case R.id.registerButton:
                        
                		newUnameEditText = (EditText)findViewById(R.id.newUnameEditText);
                		newPassEditText = (EditText)findViewById(R.id.newPassEditText);
                        roleNewEditText = (EditText)findViewById(R.id.roleNewEditText);
                        
                        String uname = newUnameEditText.getText().toString();
                        String pass = newPassEditText.getText().toString();
                        String role = roleNewEditText.getText().toString();
                        boolean invalid = false;
                        
                        if(uname.equals("")){
                                invalid = true;
                                Toast.makeText(getApplicationContext(), "Username Missing", Toast.LENGTH_SHORT).show();
                        }else if(pass.equals("")){
                                invalid = true;
                                Toast.makeText(getApplicationContext(), "Password Missing", Toast.LENGTH_SHORT).show();
                        }else if(role.equals("")){
                                invalid = true;
                                Toast.makeText(getApplicationContext(), "Role Missing", Toast.LENGTH_SHORT).show();
                        }
                        
                        if(invalid == false){
                                addEntry(uname, pass, role);
                                Intent i_register = new Intent(AdminWelcomeActivity.this, LogInActivity.class);
                                startActivity(i_register);
                                finish();
                        }
                        
                        break;
                case R.id.dataBaseEnterButton:
                	
                	retrieveEntries();
                	break;
        	}
	}

	

	public void addEntry(String uname, String pass, String role){
        
        SQLiteDatabase db = myDb.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        values.put("username", uname);
        values.put("password", pass);
        values.put("email", role);
        
        try{
                db.insert(DbHelper.LIFELINE_TABLE_NAME, null, values);
                Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
                e.printStackTrace();
        }
	}
	 @SuppressWarnings("deprecation")
		public void retrieveEntries(){
         try{
                 
                 SQLiteDatabase db = myDb.getReadableDatabase();
                 
                 String[] columns = {"username","email"};
                 
                 Cursor cursor = db.query(DbHelper.LIFELINE_TABLE_NAME, columns, null, null, null, null, null);
                 if(cursor != null){
                         System.out.println("database showing");
                         startManagingCursor(cursor);
                         showDatabase(cursor);
                 }
                 System.out.println("Cursor NuLL");
                 
         }catch(Exception e){
                 e.printStackTrace();
         }
     }
     
     public void showDatabase(Cursor cursor) {
         StringBuilder ret = new StringBuilder("Database Values\n\n");
     ret.append("\nUsername\t Role\n");
         while (cursor.moveToNext()) {
       
       String uname = cursor.getString(0);
       
       String role = cursor.getString(1);
       
       ret.append(uname+"\t\t\t"+role+"\n");
     }
         
         TextView result = new TextView(this);
         result.setText(ret);
         setContentView(result);
 }
	
	
	 @Override
	    public void onBackPressed() {
	            super.onBackPressed();
	            
	            Intent i = new Intent(AdminWelcomeActivity.this, AdminLoginActivity.class);
	            startActivity(i);
	            finish();
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_welcome, menu);
		return true;
	}

}
