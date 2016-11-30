package co.emedicationsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import co.emedicationsystem.utils.Common;
import co.emedicationsystem.utils.Variables;

/**
 * Created by Dharma on 7/28/2015.
 */
public class NewMedicationList extends AppCompatActivity {

	String patientId, id;
	TextView tvPatientName, tvDoase, tvMedicinName, tvTime, tvDiagnosis, tvInitiatedon, tvStatus, tvRemarks,textViewOvernewOng;
	TextView tvLogout,tvTitleInstructionLink;
	LinearLayout linearLayoutInstruction;
	// User Session Manager Class
		UserSessionManager session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ongoing_medication_details);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		findViewByIds();
		// Session class instance
				session = new UserSessionManager(getApplicationContext());
		Intent iPatient = getIntent();
		patientId = iPatient.getStringExtra(Common.TAG_PERSONALID);
		id = iPatient.getStringExtra(Variables.TAG_ID);
		// Check user login
				// If User is not logged in , This will redirect user to LoginActivity.
				if (session.checkLogin())
					finish();
				// get user data from session
				HashMap<String, String> user = session.getUserDetails();
				// get pid
				patientId = user.get(UserSessionManager.KEY_PERSONAL_ID);
				// get code
				String code = user.get(UserSessionManager.KEY_CODE);
		// Common.parsePastPatientMedicationDeatilsJson(getApplicationContext(),
		// Common.returnPastMedicationJson(getApplicationContext()));

		for (int p = 0; p < Variables.curretMedicationList.size(); p++) {
			if (patientId.equalsIgnoreCase(Variables.curretMedicationList.get(p).getPersonalId().toString())) {
				tvPatientName.setText(Variables.curretMedicationList.get(p).getName().toString());
				int pp=(Integer.parseInt(id)-1);
						tvMedicinName.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getMedicineName());
						tvDoase.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getDosage());
						tvTime.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getTime());
						tvDiagnosis.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getDiagnosis());
						tvInitiatedon.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getInitiatedOn());
						tvStatus.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getStatus());
						tvRemarks.setText(Variables.curretMedicationList.get(p).getMedicationList().get(pp).getRemarks());
						tvTitleInstructionLink.setText(getResources().getString(R.string.urlllink)+Variables.curretMedicationList.get(p).getMedicationList().get(pp).getMedicineName());
					
						if (Variables.curretMedicationList.get(p).getMedicationList().get(pp).getStatus().equalsIgnoreCase(Variables.typeNew)) {
							textViewOvernewOng.setText(getResources().getString(R.string.new_medication_details));
						}
						if (Variables.curretMedicationList.get(p).getMedicationList().get(pp).getStatus().equalsIgnoreCase(Variables.typeOngoing)) {
							textViewOvernewOng.setText(getResources().getString(R.string.ongoing_medication_details));
						}
						//}

				//}

			}

		}
		
		tvLogout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Log out ", Toast.LENGTH_SHORT).show();
				// Clear the User session data
				// and redirect user to LoginActivity
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(NewMedicationList.this);

				alertDialog.setTitle("Logout"); // Sets title for your alertbox

				alertDialog.setMessage("Are you sure you want to Logout ?"); // Message

				alertDialog.setIcon(R.drawable.logout32); // Icon for your

				/* When positive (yes/ok) is clicked */
				alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
						Toast.makeText(NewMedicationList.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
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

	}

	/**
	 * @Author: Dharma Kshetri(dharma.kshetri@gmail.com)
	 * @Date: Aug 1, 2015
	 * @Purpose:
	 */
	private void findViewByIds() {
		// TODO Auto-generated method stub
		textViewOvernewOng=(TextView) findViewById(R.id.textViewOvernewOng);
		tvPatientName = (TextView) findViewById(R.id.tvPPatientName);
		tvDoase = (TextView) findViewById(R.id.tvPDosageValue);
		tvMedicinName = (TextView) findViewById(R.id.tvPMedicineName);
		tvTime = (TextView) findViewById(R.id.tvPFrequencyValue);
		tvDiagnosis = (TextView) findViewById(R.id.tvPDiagnosis);
		tvInitiatedon = (TextView) findViewById(R.id.tvPInitiatedValue);
		tvStatus = (TextView) findViewById(R.id.tvPStatus);
		tvRemarks = (TextView) findViewById(R.id.tvPRemarks);
		tvTitleInstructionLink= (TextView) findViewById(R.id.tvTitleInstructionLink);
		tvLogout = (TextView) findViewById(R.id.tvNewLogout);
		linearLayoutInstruction=(LinearLayout)findViewById(R.id.linearInstruction);
		linearLayoutInstruction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (Common.isNetworkAvailable(getApplicationContext())) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvTitleInstructionLink.getText().toString()));
					startActivity(browserIntent);
					overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
				}else {
					Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
