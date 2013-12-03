package com.group6.lifeline;



import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Toast;

public class WelcomeDoctorActivity extends Activity implements OnItemSelectedListener, OnClickListener {
	String username = LogInActivity.username;
	Spinner doctorPatientListSpinner = null;
	DbHelper mydb = null;
	DbHelper mydatabase = new DbHelper(this);
	Button viewPatientRecord;
	Button editPatientRecord;
	public static String patient;
	
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_doctor);
		
		
		
		viewPatientRecord = (Button)findViewById(R.id.viewPatientRecordButton);
        viewPatientRecord.setOnClickListener(this);
        
        editPatientRecord = (Button)findViewById(R.id.editPatientRecordButton);
        editPatientRecord.setOnClickListener(this);
		
		doctorPatientListSpinner = (Spinner) findViewById(R.id.doctorPatientListSpinner);
		doctorPatientListSpinner.setOnItemSelectedListener(this);
		loadSpinnerData();
		
		TextView information = (TextView) findViewById(R.id.usernametextView1);
		String data = mydatabase.getName(username);
		information.setText(data);
	}
	
	public void onClick(View v) {
        
        switch(v.getId()){
        
        case R.id.viewPatientRecordButton:
        	Intent i = new Intent(WelcomeDoctorActivity.this,DPatientRecordActivity.class);
        	startActivity(i);
        	DbHelper db = new DbHelper(getApplicationContext());
        	db.getReadableDatabase();
        	
        	
        	
            
            
        	break;
        case R.id.editPatientRecordButton:
        	Intent i2 = new Intent(WelcomeDoctorActivity.this,DoctorEditRecordActivity.class);
        	startActivity(i2);
        	
        	break;
        }
        
        
        }
    
	private void loadSpinnerData() {
        // database handler
        DbHelper db = new DbHelper(getApplicationContext());
 
        // Spinner Drop down elements
        
        List<String> patients = db.getAllPatients();
 
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, patients);
 
        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // attaching data adapter to spinner
        doctorPatientListSpinner.setAdapter(dataAdapter);
        db.close();
    }
	 @Override
	    public void onItemSelected(AdapterView<?> parent, View view, int position,
	            long id) {
	        // On selecting a spinner item
	        patient = parent.getItemAtPosition(position).toString();
	 
	        // Showing selected spinner item
	        Toast.makeText(parent.getContext(), "You selected: " + patient,
	                Toast.LENGTH_LONG).show();
	 
	    }
	 
	 
	 
	    @Override
	    public void onNothingSelected(AdapterView<?> arg0) {
	        // TODO Auto-generated method stub
	 
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
