package com.group6.lifeline;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NurseEditRecordActivity extends Activity implements OnClickListener {
	private Button makeNurseChanges;
	
	private EditText editHeight;
	private EditText editAller;
	private EditText editWeight;
	private DbHelper myDb = new DbHelper(NurseEditRecordActivity.this);

	String patient = WelcomeDoctorActivity.patient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nurse_edit_record);
		
		makeNurseChanges = (Button) findViewById(R.id.makeNurseChangesButton);
		makeNurseChanges.setOnClickListener(this);
	}
	
public void onClick(View v) {
        
        switch(v.getId()){
        
        case R.id.makeNurseChangesButton:
        	editAller = (EditText)findViewById(R.id.nurseAeditText);
    		editHeight = (EditText)findViewById(R.id.NurseHEditText);
            editWeight = (EditText)findViewById(R.id.NureWEditText);
            
            
            String ialler = editAller.getText().toString();
            String weight = editWeight.getText().toString();
            String height = editHeight.getText().toString();
           
            
       
            
            if(weight.equals("")){
            	
            }else{
            	updateInfo2(patient, DbHelper.USER_WEIGHT, weight);
            }
            if(height.equals("")){
            	
            }else{
            	updateInfo2(patient, DbHelper.USER_HEIGHT, height);
            }
            if(ialler.equals("")){
            	
            }else{
            	updateInfo2(patient, DbHelper.USER_ALLER, ialler);
            }
            
            
            Intent i = new Intent(NurseEditRecordActivity.this, WelcomeNurseActivity .class);
            startActivity(i);
            finish();
 
            
            break;
        }
   }

	public void updateInfo2(String patient,String update, String value){
		SQLiteDatabase db = myDb.getWritableDatabase();
		String where = DbHelper.USERNAME_COL +" = '"+patient+"'";
		ContentValues values = new ContentValues();
		values.put(update, value);
		db.update(DbHelper.LOGIN_TABLE_NAME, values, where,null);
	
		db.close();
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nurse_edit_record, menu);
		return true;
	}

}
