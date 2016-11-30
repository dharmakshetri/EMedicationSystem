package co.emedicationsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.HashMap;

import co.emedicationsystem.utils.Common;

public class SplashScreen extends Activity {

	// Splash screen timer
	private static int SPLASH_TIME_OUT = 3000;
	// User Session Manager Class
	UserSessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Remove notification bar
		// /this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.spalshscreen);
		// User Session Manager
		session = new UserSessionManager(getApplicationContext());
		//Toast.makeText(getApplicationContext(), "User Login Status: " + session.isUserLoggedIn(), Toast.LENGTH_LONG).show();

		Common.patientList.clear();
		Common.parsePatientDeatilsJson(getApplicationContext(), Common.returnPatientJson(getApplicationContext()));
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity

				if (session.isUserLoggedIn()) {
					Intent i = new Intent(SplashScreen.this, PatientMedicationList.class);
					// get user data from session
					HashMap<String, String> user = session.getUserDetails();
					i.putExtra(Common.TAG_NAME, user.get(UserSessionManager.KEY_CODE));
					startActivity(i);
					overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
					finish();
					return;
				}
				Intent i = new Intent(SplashScreen.this, LoginActivity.class);
				startActivity(i);
				overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

}
