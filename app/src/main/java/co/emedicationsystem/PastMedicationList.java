package co.emedicationsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import co.emedicationsystem.utils.Common;
import co.emedicationsystem.utils.Variables;

/**
 * Created by Dharma on 7/29/2015.
 */
public class PastMedicationList extends AppCompatActivity {
	String patientId, id, type;

	TextView tvPatientName, textViewLogout, tvMedicinName, tvDosase, tvTime, tvReason, tvUsage,textViewOverPast;
	// User Session Manager Class
	UserSessionManager session;
	TextView tvLogout, tvTitleInstructionLink;
	LinearLayout linearLayoutInstruction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.past_medication_details);
		
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		// Session class instance
		session = new UserSessionManager(getApplicationContext());
		findViewById();
		Intent iPatient = getIntent();
		patientId = iPatient.getStringExtra(Common.TAG_PERSONALID);
		id = iPatient.getStringExtra(Variables.TAG_ID);

		if (session.checkLogin())
			finish();

		// get user data from session
		HashMap<String, String> user = session.getUserDetails();

		// get pid
		patientId = user.get(UserSessionManager.KEY_PERSONAL_ID);

		// get code
		String code = user.get(UserSessionManager.KEY_CODE);

		for (int p = 0; p < Variables.pastMedicationList.size(); p++) {
			if (patientId.equalsIgnoreCase(Variables.pastMedicationList.get(p).getPersonalId().toString())) {
				tvPatientName.setText(Variables.pastMedicationList.get(p).getName().toString());
				for (int pp = 0; pp < Variables.pastMedicationList.get(p).getMedicationList().size(); pp++) {
					if ((Integer.parseInt(id) - 1) == pp) {
						tvMedicinName.setText(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getMedicinename());
						tvDosase.setText(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getDosage());
						tvTime.setText(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getTime());
						tvReason.setText(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getReason());
						tvUsage.setText(Variables.pastMedicationList.get(p).getMedicationList().get(pp).getUsage());
						tvTitleInstructionLink.setText(getResources().getString(R.string.urlllink)+Variables.pastMedicationList.get(p).getMedicationList().get(pp).getMedicinename());

						textViewOverPast.setText(getResources().getString(R.string.past_medication_details));
					}

				}

			}

		}

		tvLogout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Toast.makeText(getApplicationContext(), "Log out ", Toast.LENGTH_SHORT).show();
				// Clear the User session data
				// and redirect user to LoginActivity
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(PastMedicationList.this);

				alertDialog.setTitle("Logout"); // Sets title for your alertbox

				alertDialog.setMessage("Are you sure you want to Logout ?"); // Message

				alertDialog.setIcon(R.drawable.logout32); // Icon for your

				/* When positive (yes/ok) is clicked */
				alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
						Toast.makeText(PastMedicationList.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
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

	public void findViewById() {
		textViewOverPast= (TextView) findViewById(R.id.textViewOverPast);
		textViewLogout = (TextView) findViewById(R.id.textViewLogout);
		tvPatientName = (TextView) findViewById(R.id.textViewPatientName);
		tvMedicinName = (TextView) findViewById(R.id.textMedicineName);
		tvDosase = (TextView) findViewById(R.id.textViewDosageValue);
		tvTime = (TextView) findViewById(R.id.textViewFrequencyValue);
		tvReason = (TextView) findViewById(R.id.textViewReasonValue);
		tvUsage = (TextView) findViewById(R.id.textViewUsedForValue);
		tvLogout = (TextView) findViewById(R.id.tvPastLogout);
		tvTitleInstructionLink = (TextView) findViewById(R.id.tvTitleInstructionLink);
		linearLayoutInstruction=(LinearLayout)findViewById(R.id.linearInstruction);
		linearLayoutInstruction.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (Common.isNetworkAvailable(getApplicationContext())) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvTitleInstructionLink.getText().toString()));
					startActivity(browserIntent);
					overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
				} else {
					Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
