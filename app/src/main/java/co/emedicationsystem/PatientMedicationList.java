package co.emedicationsystem;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import co.emedicationsystem.utils.Common;
import co.emedicationsystem.utils.Variables;

/**
 * Created by Dharma on 7/17/2015.
 */
public class PatientMedicationList extends AppCompatActivity {
	TextView tvLogout, tvPatientName;
	String patientName, patientPersonalId;
	ListView listMedicationList;
	Button btnNew, btnOnging, btnPast;
	ListView lstOverallMedecines, lstOngoing, lstPastMedicine;
	String patientId;

	// User Session Manager Class
	UserSessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.overall_medication_list);

		// Session class instance
		session = new UserSessionManager(getApplicationContext());
		// listMedicationList=(ListView)findViewById(R.id.listMedication);

		 /* Session Time Logout after 10 mins */
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	       @Override
		public void run() {
	        Intent i = new Intent(PatientMedicationList.this, LoginActivity.class);
	        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        session.logoutUser();
	        startActivity(i);
	        finish();
	        return;
	       }
	    }, 600000);
	    /* Time Logout END */

		lstOverallMedecines = (ListView) findViewById(R.id.listViewMedicines);
		Variables.pastMedicationList.clear();
		Variables.curretMedicationList.clear();
		Common.parseNewPatientMedicationDeatilsJson(getApplicationContext(), Common.returnNewMedicationJson(getApplicationContext()));
		Common.parsePastPatientMedicationDeatilsJson(getApplicationContext(), Common.returnPastMedicationJson(getApplicationContext()));

		Intent iPatient = getIntent();
		patientName = iPatient.getStringExtra(Common.TAG_NAME);
		patientPersonalId = iPatient.getStringExtra(Common.TAG_PERSONALID);
		tvPatientName = (TextView) findViewById(R.id.tvListPatientName);
		tvPatientName.setText(patientName);

		// Check user login
		// If User is not logged in , This will redirect user to LoginActivity.
		if (session.checkLogin())
			finish();

		// get user data from session
		HashMap<String, String> user = session.getUserDetails();

		// get pid
		patientPersonalId = user.get(UserSessionManager.KEY_PERSONAL_ID);

		// get code
		String code = user.get(UserSessionManager.KEY_CODE);

		tvLogout = (TextView) findViewById(R.id.textViewLogout);
		tvLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Log out ", Toast.LENGTH_SHORT).show();
				// Clear the User session data
				// and redirect user to LoginActivity
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(PatientMedicationList.this);

				alertDialog.setTitle("Logout"); // Sets title for your alertbox

				alertDialog.setMessage("Are you sure you want to Logout ?"); // Message

				alertDialog.setIcon(R.drawable.logout32); // Icon for your

				/* When positive (yes/ok) is clicked */
				alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
						Toast.makeText(PatientMedicationList.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
						session.logoutUser();
					}
				});

				/* When negative (No/cancel) button is clicked */
				alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				alertDialog.show();

			}
		});

		// new medicines

		addAllOverAllMedicine();
		// Set The Adapter
		CustomAdapter customAdapter = new CustomAdapter(this, patientPersonalId, Variables.listAllMedicines, Variables.listAllMedicinesIds,
				Variables.listAllMedicinesTypes);
		
		lstOverallMedecines.setAdapter(customAdapter);
	}

	public void addAllOverAllMedicine() {
		Variables.listAllMedicines.clear();
		Variables.listAllMedicinesIds.clear();
		Variables.listAllMedicinesTypes.clear();
		for (int c = 0; c < Variables.curretMedicationList.size(); c++) {
			String cpId = Variables.curretMedicationList.get(c).getPersonalId().toString();
			if (patientPersonalId.equalsIgnoreCase(cpId)) {

				if (Variables.curretMedicationList.get(c).getMedicationList().size() == 0) {
					return;
				}
				for (int cc = 0; cc < Variables.curretMedicationList.get(c).getMedicationList().size(); cc++) {
					Variables.listAllMedicines.add(Variables.curretMedicationList.get(c).getMedicationList().get(cc).getMedicineName().toString());
					Variables.listAllMedicinesIds.add(Variables.curretMedicationList.get(c).getMedicationList().get(cc).getId());
					
					Variables.listAllMedicinesTypes.add(Variables.curretMedicationList.get(c).getMedicationList().get(cc).getStatus());
				}
			}
		}
		for (int p = 0; p < Variables.pastMedicationList.size(); p++) {
			String ppId = Variables.pastMedicationList.get(p).getPersonalId().toString();
			if (patientPersonalId.equalsIgnoreCase(ppId)) {
				if (Variables.pastMedicationList.get(p).getMedicationList().size() == 0) {
					return;
				}
				for (int pp = 0; pp < Variables.pastMedicationList.get(p).getMedicationList().size(); pp++) {
					Variables.listAllMedicines.add(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getMedicinename().toString());
					Variables.listAllMedicinesIds.add(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getId());
					Variables.listAllMedicinesTypes.add("Past");
				}
			}
		}

	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	
}
