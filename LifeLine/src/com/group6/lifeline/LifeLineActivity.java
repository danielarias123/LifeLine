package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LifeLineActivity extends Activity {

	TextView titleTextView;
	
	Button LogInButton;
	Button AdminLoginButton;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_line);
		
		LogInButton = (Button) findViewById(R.id.LogInbutton);
		
		AdminLoginButton = (Button) findViewById(R.id.adminLoginButton);
	
		
		LogInButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), LogInActivity.class);
				startActivity(intent);
			}
		});
		
		AdminLoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), LogInActivity.class);
				startActivity(i);
			}
		});
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.life_line, menu);
		return true;
	}

}
