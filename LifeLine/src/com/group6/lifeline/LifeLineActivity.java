package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;

public class LifeLineActivity extends Activity implements OnClickListener{

	TextView titleTextView;
	
	Button LogInButton;
	Button AdminLoginButton;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_line);
		
		SQLiteDatabase.loadLibs(this);
		
		LogInButton = (Button) findViewById(R.id.LogInbutton);
		LogInButton.setOnClickListener(this);
		
		AdminLoginButton = (Button) findViewById(R.id.enterAdminButton);
		AdminLoginButton.setOnClickListener(this);
		}
	
	public void onClick(View v) {
        
        switch(v.getId()){
        
        case R.id.LogInbutton:
        	Intent intent = new Intent(LifeLineActivity.this, LogInActivity.class);
            startActivity(intent);
            finish();
            break;
                
                
        case R.id.enterAdminButton:
                Intent i = new Intent(LifeLineActivity.this, AdminLoginActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.life_line, menu);
		return true;
	}

}
