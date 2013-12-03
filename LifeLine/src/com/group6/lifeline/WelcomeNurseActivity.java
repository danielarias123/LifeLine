package com.group6.lifeline;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class WelcomeNurseActivity extends Activity implements OnItemSelectedListener, OnClickListener{
	
	Spinner nursePatientListSpinner = null;
	DbHelper mydb = null;
	DbHelper mydatabase = new DbHelper(this);
	Button NviewPatientRecord;
	Button NeditPatientRecord;
	public static String patient;
	WelcomeDoctorActivity tool = new WelcomeDoctorActivity();
	String username = LogInActivity.username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_nurse);
		
		
		
		NviewPatientRecord = (Button)findViewById(R.id.nurseViewRecordButton);
        NviewPatientRecord.setOnClickListener(this);
        
        NeditPatientRecord = (Button)findViewById(R.id.nurseEditRecordbutton);
        NeditPatientRecord.setOnClickListener(this);
		
		nursePatientListSpinner = (Spinner) findViewById(R.id.nursePatientListSpinner);
		nursePatientListSpinner.setOnItemSelectedListener(this);
		load2SpinnerData();
		
		TextView information = (TextView) findViewById(R.id.usernametextView2);
		String data = mydatabase.getName(username);
		information.setText(data);
	}
	
public void onClick(View v) {
        
        switch(v.getId()){
        
        case R.id.nurseViewRecordButton:
        	Intent i = new Intent(WelcomeNurseActivity.this,NPatientRecordActivity.class);
        	startActivity(i);
        	DbHelper db = new DbHelper(getApplicationContext());
        	db.getReadableDatabase();
        	
        	
        	
          
            
        	break;
        case R.id.nurseEditRecordbutton:
        	Intent i2 = new Intent(WelcomeNurseActivity.this,NurseEditRecordActivity.class);
        	startActivity(i2);
        	
        	break;
        }
        
        
    }
	
	private void load2SpinnerData() {
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
    nursePatientListSpinner.setAdapter(dataAdapter);
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
            
            Intent i = new Intent(WelcomeNurseActivity.this, LifeLineActivity.class);
            startActivity(i);
            finish();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_nurse, menu);
		return true;
	}

}
