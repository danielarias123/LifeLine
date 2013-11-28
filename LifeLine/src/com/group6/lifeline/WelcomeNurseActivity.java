package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WelcomeNurseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_nurse);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_nurse, menu);
		return true;
	}

}
