package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class WelcomeDoctorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_doctor);
	}
	
	@Override
    public void onBackPressed() {
            super.onBackPressed();
            Intent i = new Intent(WelcomeDoctorActivity.this, LogInActivity.class);
            startActivity(i);
            finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_doctor, menu);
		return true;
	}

}
