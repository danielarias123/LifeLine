package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WelcomePatientActivity extends Activity implements OnClickListener {
	Button ownRecordButton;
	String username = LogInActivity.username;
	DbHelper mydb = new DbHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_patient);
		
		ownRecordButton = (Button) findViewById(R.id.viewOwnRecordButton);
		ownRecordButton.setOnClickListener(this);
		
		TextView information = (TextView) findViewById(R.id.usernametextView3);
		String data = mydb.getName(username);
		information.setText(data);
		
	}
		
	public void onClick(View v) {
	        
	        switch(v.getId()){
	                
	        case R.id.viewOwnRecordButton:
	            Intent i = new Intent(WelcomePatientActivity.this, OwnRecordActivity.class);
	            startActivity(i);
	            finish();
	            break;
	        }
		}
	
	@Override
    public void onBackPressed() {
            super.onBackPressed();
            Intent i = new Intent(WelcomePatientActivity.this, LifeLineActivity.class);
            startActivity(i);
            finish();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
