package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
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

public class AdminLoginActivity extends Activity implements OnClickListener{
	
	Button loginButton;
	Button cancelButton;
	EditText adminPassword;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);
		
		loginButton = (Button)findViewById(R.id.adminLoginButton);
        loginButton.setOnClickListener(this);
        
        cancelButton = (Button)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(this);
	}
        public void onClick(View v) {
            
            switch(v.getId()){
            
            case R.id.adminLoginButton:
                    adminPassword = (EditText)findViewById(R.id.adminPasswordEditText);
                    
                    String pass = adminPassword.getText().toString();
                    if(pass.equals("") || pass == null){
                            
                            Toast.makeText(getApplicationContext(), "Password Missing", Toast.LENGTH_SHORT).show();
                            
                    }else{
                            
                            if(pass.equals("admin")){
                                    Toast.makeText(getApplicationContext(), "Retrieving Data", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AdminLoginActivity.this, AdminWelcomeActivity.class);
                                    startActivity(intent);
                                    finish();
                            }else{
                                    Toast.makeText(getApplicationContext(), "Admin Login Failed", Toast.LENGTH_SHORT).show();
                            }
                    }
                    
                    break;
                    
            case R.id.cancelButton:
                    Intent i = new Intent(AdminLoginActivity.this, LifeLineActivity.class);
                    startActivity(i);
                    finish();
                    break;
            }
        }
        
       
    
  

    /* (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
            super.onBackPressed();
            
            Intent i = new Intent(AdminLoginActivity.this, LifeLineActivity.class);
            startActivity(i);
            finish();
    }
	
        
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_login, menu);
		return true;
	}
	}


