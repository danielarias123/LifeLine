package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DPatientRecordActivity extends Activity {
	
	String patient = WelcomeDoctorActivity.patient;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_record);
		DbHelper mydb = new DbHelper(this);
		
		
		TextView information = (TextView) findViewById(R.id.ntextView);
		String data = mydb.getName(patient);
		information.setText(data);
		
		TextView information2 = (TextView) findViewById(R.id.insNumTextView);
		String data2 = mydb.getIns(patient);
		information2.setText(data2);
		
		TextView information3 = (TextView) findViewById(R.id.textView2);
		String data3 = mydb.getDob(patient);
		information3.setText(data3);
		
		TextView information4 = (TextView) findViewById(R.id.textView4);
		String data4 = mydb.getWeight(patient);
		information4.setText(data4);
		
		TextView information5 = (TextView) findViewById(R.id.textView1);
		String data5 = mydb.getHeight(patient);
		information5.setText(data5);
		
		TextView information6 = (TextView) findViewById(R.id.editTitleTextView);
		String data6 = mydb.getAller(patient);
		information6.setText(data6);
		
		TextView information7 = (TextView) findViewById(R.id.textView3);
		String data7 = mydb.getConcerns(patient);
		information7.setText(data7);
		
		TextView information8 = (TextView) findViewById(R.id.textView5);
		String data8 = mydb.getBlood(patient);
		information8.setText(data8);
		
		TextView information9 = (TextView) findViewById(R.id.textView7);
		String data9 = mydb.getNextApp(patient);
		information9.setText(data9);
		
		mydb.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_record, menu);
		
		return true;
	}

}
