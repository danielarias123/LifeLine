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

public class DoctorEditRecordActivity extends Activity implements OnClickListener{
	
	private Button makeChanges;
	private DbHelper myDb = new DbHelper(DoctorEditRecordActivity.this);
	private EditText editInsNum;
	private EditText editDob;
	private EditText editWeight;
	private EditText editHeight;
	private EditText editAller;
	private EditText editConc;
	private EditText editBlood;
	private EditText editNextApp;
	
	String patient = WelcomeDoctorActivity.patient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_edit_record);
		
		makeChanges = (Button) findViewById(R.id.makeChangesButton);
		makeChanges.setOnClickListener(this);
	}
	
	public void onClick(View v) {
        
        switch(v.getId()){
        
        case R.id.makeChangesButton:
        	editInsNum = (EditText)findViewById(R.id.editText1);
    		editDob = (EditText)findViewById(R.id.editText2);
            editWeight = (EditText)findViewById(R.id.editText3);
            editHeight = (EditText)findViewById(R.id.editText4);
            editAller = (EditText)findViewById(R.id.editText5);
            editConc = (EditText)findViewById(R.id.editText6);
            editBlood = (EditText)findViewById(R.id.editText7);
            editNextApp = (EditText)findViewById(R.id.editText8);
            
            String insnum = editInsNum.getText().toString();
            String dob = editDob.getText().toString();
            String weight = editWeight.getText().toString();
            String height = editHeight.getText().toString();
            String aller = editAller.getText().toString();
            String conc = editConc.getText().toString();
            String blood = editBlood.getText().toString();
            String nextapp = editNextApp.getText().toString();
            
            if(insnum.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.INS_NUM, insnum);
            }
            
            if(dob.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.USER_DOB, dob);
            }
            
            if(weight.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.USER_WEIGHT, weight);
            }
            if(height.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.USER_HEIGHT, height);
            }
            if(aller.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.USER_ALLER, aller);
            }
            if(conc.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.USER_CONCERNS, conc);
            }
            if(blood.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.USER_BLOOD, blood);
            }
            if(nextapp.equals("")){
            	
            }else{
            	updateInfo(patient, DbHelper.NEXT_APP, nextapp);
            }
            
            Intent i = new Intent(DoctorEditRecordActivity.this, WelcomeDoctorActivity .class);
            startActivity(i);
            finish();
 
            
            break;
        }
   }
	
	
	public void updateInfo(String patient,String update, String value){
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
		getMenuInflater().inflate(R.menu.doctor_edit_record, menu);
		return true;
	}

}
