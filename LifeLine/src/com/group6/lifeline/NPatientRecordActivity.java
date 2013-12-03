package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class NPatientRecordActivity extends Activity {
	
	String patient = WelcomeDoctorActivity.patient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_npatient_record);
		
DbHelper mydb = new DbHelper(this);
		
		
		TextView information = (TextView) findViewById(R.id.n2textView);
		String data = mydb.getName(patient);
		information.setText(data);
		
		TextView information2 = (TextView) findViewById(R.id.insNum2TextView);
		String data2 = mydb.getIns(patient);
		information2.setText(data2);
		
		TextView information3 = (TextView) findViewById(R.id.text2View2);
		String data3 = mydb.getDob(patient);
		information3.setText(data3);
		
		TextView information4 = (TextView) findViewById(R.id.text2View4);
		String data4 = mydb.getWeight(patient);
		information4.setText(data4);
		
		TextView information5 = (TextView) findViewById(R.id.text2View1);
		String data5 = mydb.getHeight(patient);
		information5.setText(data5);
		
		TextView information6 = (TextView) findViewById(R.id.nurseEditTextView);
		String data6 = mydb.getAller(patient);
		information6.setText(data6);
		
		
		
		mydb.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.npatient_record, menu);
		return true;
	}

}
